/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Model.Billing.Customer;
import Controller.SecuritySimController;
import Model.Building.CommercialBuilding;
import Model.Building.RoomCreator;
import Model.Building.SectionCreator;
import Model.Sensors.Sensor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author hinsenchan
 */
public class SecuritySimModel implements Serializable {
    private SecuritySimController securitySimController;
    private Customer customer;
    private CommercialBuilding commercialBuilding;
    private SectionCreator sectionCreator;
    private RoomCreator roomCreator;
    private ArrayList<Object> serialDataList;
    private ArrayList<String[]> sensorSetupTable;
    private String[] buildingModel;
    private String[] areaModel;
    private String[] roomModel;
    private String[] sensorModel;
    
    
    public SecuritySimModel(SecuritySimController securitySimController) {
        this.securitySimController = securitySimController;
        sensorSetupTable = new ArrayList<String[]>();
        buildingModel = new String[] {"Select a building...", "Add new..."};
        areaModel = new String[] {"Select an area...", "Add new..."};
        roomModel = new String[] {"Select a room...", "Add new..."};
        sensorModel = new String[] {"Select a sensor...", "No Sensor", 
            "Motion Sensor", "Senior Sensor", "Temperature Sensor"};
    }
    
    public void setCustomer(String name, String phoneNumber, String emailId,
			String emergencyContact, String serviceContractId) {
        customer = new Customer(name, phoneNumber, emailId, 
                emergencyContact, serviceContractId);
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    public void createBuilding(String name, Sensor sensor) {
        commercialBuilding = new CommercialBuilding(name);
        createSection(sensor);
    }
    
    public CommercialBuilding getBuilding() {
        return commercialBuilding;
    }
    
    public void createSection(Sensor sensor) {
        RoomCreator roomCreator = new RoomCreator();
	SectionCreator sectionCreator = new SectionCreator(roomCreator);
        int sectionID = commercialBuilding.getSectionList().size();
        commercialBuilding.addSection(sectionCreator.createSection(1));
        commercialBuilding.getSectionList().get(sectionID).getRoomList().get(0).addSensor(sensor);       
        
        String[] row = new String[4];
        row[0] = commercialBuilding.getBuildingId();
        row[1] = Integer.toString(
                    commercialBuilding.getSectionList().get(sectionID).getSectionId());        
        row[2] = Integer.toString(
                    commercialBuilding.getSectionList().get(sectionID).getRoomList().get(0).getRoomId());        
        row[3] = commercialBuilding.getSectionList().get(sectionID).getRoomList().get(0)
                    .getSensorList().get(0).getType();

        sensorSetupTable.add(row); 
    }
    
    public ArrayList<String[]> getSensorSetupTable() {
        return sensorSetupTable;
    }
    
    public void newModel() {
        customer = null;
        commercialBuilding = null;
    }
    
    public void saveModel() {
        try {
            FileOutputStream fileOut = new FileOutputStream("account.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            serialDataList = new ArrayList<Object>();            
            serialDataList.add(customer);
            serialDataList.add(commercialBuilding);
            out.writeObject(serialDataList);
            out.close();
            fileOut.close();   
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void loadModel() {
        try {
            FileInputStream fileIn = new FileInputStream("account.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            serialDataList = (ArrayList<Object>)in.readObject();
            customer = (Customer)serialDataList.get(0);
            in.close();
            fileIn.close();            
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the buildingModel
     */
    public String[] getBuildingModel() {
        return buildingModel;
    }

    /**
     * @param buildingModel the buildingModel to set
     */
    public void setBuildingModel(String[] buildingModel) {
        this.buildingModel = buildingModel;
    }    
    
    /**
     * @return the areaModel
     */
    public String[] getAreaModel() {
        return areaModel;
    }

    /**
     * @param areaModel the areaModel to set
     */
    public void setAreaModel(String[] areaModel) {
        this.areaModel = areaModel;
    }

    /**
     * @return the roomModel
     */
    public String[] getRoomModel() {
        return roomModel;
    }

    /**
     * @param roomModel the roomModel to set
     */
    public void setRoomModel(String[] roomModel) {
        this.roomModel = roomModel;
    }

    /**
     * @return the sensorModel
     */
    public String[] getSensorModel() {
        return sensorModel;
    }

    /**
     * @param sensorModel the sensorModel to set
     */
    public void setSensorModel(String[] sensorModel) {
        this.sensorModel = sensorModel;
    }
}
