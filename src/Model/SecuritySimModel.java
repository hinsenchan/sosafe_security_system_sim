/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Model.Billing.Customer;
import Controller.SecuritySimController;
import Model.Building.CommercialBuilding;
import Model.Building.Room;
import Model.Building.RoomCreator;
import Model.Building.Section;
import Model.Building.SectionCreator;
import Model.SecuritySystem.BreakinSecurity;
import Model.SecuritySystem.FireSecurity;
import Model.SecuritySystem.NullSecurity;
import Model.SecuritySystem.SeniorSecurity;
import Model.Sensors.Sensor;
import Simulator.Simulator;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hinsenchan
 */
public class SecuritySimModel extends AbstractTableModel implements Serializable {
    private SecuritySimController securitySimController;
    private Customer customer;
    private CommercialBuilding commercialBuilding;
    private SectionCreator sectionCreator;
    private RoomCreator roomCreator;
    private ArrayList<Object> serialDataList;
    private ArrayList<String[]> tableDisplayData;
    private String[] buildingModel;
    private String[] areaModel;
    private String[] roomModel;
    private String[] sensorModel;
    private String[] columnNames;
    private NullSecurity nullSecurity;
    private BreakinSecurity breakinSecurity;
    private FireSecurity fireSecurity;
    private SeniorSecurity seniorSecurity;
    private Simulator simulator;
    private ArrayList<Sensor> sensorList;
    
    public SecuritySimModel(SecuritySimController securitySimController) {
        this.securitySimController = securitySimController;
        tableDisplayData = new ArrayList<String[]>();
        buildingModel = new String[] {"Add new..."};
        areaModel = new String[] {"Add new..."};
        roomModel = new String[] {"Add new..."};        
        sensorModel = new String[] {"Select a sensor...", "No Sensor", 
            "Motion Sensor", "Senior Sensor", "Temperature Sensor"};
        
        columnNames = new String[]{"Building", "Section", "Room", "Sensor", "Status"};
        
        nullSecurity = new NullSecurity("Null Security", 1);
        breakinSecurity = new BreakinSecurity("Breakin Security", 1);
        fireSecurity = new FireSecurity("Fire Security", 1);
        seniorSecurity = new SeniorSecurity("Senior Security", 1);
        sensorList = new ArrayList<Sensor>();
        simulator = new Simulator(this);
    }
    
    public ArrayList<Sensor> getSensorList() {
        
        sensorList.clear();
        if (commercialBuilding == null) {
            return null;
        }
        int sectionListsize = commercialBuilding.getSectionList().size();
        for (int i=0; i<sectionListsize; i++) {
            Section section = commercialBuilding.getSectionList().get(i);
            int roomListSize = section.getRoomList().size();
            for (int j=0; j<roomListSize; j++) {
                Room room = section.getRoomList().get(j);
                int sensorListSize = room.getSensorList().size();
                for (int k=0; k<sensorListSize; k++) {
                    sensorList.add(room.getSensorList().get(k));
                }
            }
        }
        return sensorList;
    }
    
    public String getColumnName(int column) {
         return columnNames[column];
     }    
    
    public void setCustomer(String name, String phoneNumber, String emailId,
			String emergencyContact, String serviceContractId) {
        customer = new Customer(name, phoneNumber, emailId, 
                emergencyContact, serviceContractId);
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    public void reloadTableDisplayData() {
        tableDisplayData.clear();
        
        int rowIndex = 0;        
        ArrayList<Section> sections = (ArrayList<Section>) commercialBuilding.getSectionList();
        int numberOfSections = sections.size();        

        for (int i=0; i<numberOfSections; i++) {                        
            Section section = sections.get(i);
            int numberOfRooms = section.getRoomList().size();
            for (int j=0; j<numberOfRooms; j++) {
                Room room = section.getRoomList().get(j);
                int numberOfSensors = room.getSensorList().size();
                for (int k=0; k<numberOfSensors; k++) {             
                    Sensor sensor = room.getSensorList().get(k);
                    
                    String[] newRow = new String[5];                    
                    newRow[0] = commercialBuilding.getBuildingId();
                    newRow[1] = Integer.toString(section.getSectionId());
                    newRow[2] = Integer.toString(room.getRoomId());
                    newRow[3] = sensor.getType();
                    newRow[4] = sensor.getStatus();
                    //newRow[4] = Integer.toString(sensor.getData());
                    
                    tableDisplayData.add(newRow);
                    rowIndex++;
                }
            }
        }        
    }
    
    public void reloadComboBoxModels() {        
        if (getBuilding() == null) {
            setBuildingModel(new String[]{"Add new..."});
            setAreaModel(new String[]{"Add new..."});
            setRoomModel(new String[]{"Add new..."});
        }
        else {            
            setBuildingModel(new String[]{"Select a building...",getBuilding().getBuildingId()});
            setAreaModel(new String[]{"Select a building first..."});
            setRoomModel(new String[]{"Select an area first..."});            
        }
    }    
    
    public CommercialBuilding getBuilding() {
        return commercialBuilding;
    }    
    
    public Room createBuilding(String name) {
        commercialBuilding = new CommercialBuilding(name);
        return createSection();
    }
    
    public Room createSection() {
        RoomCreator roomCreator = new RoomCreator();
        SectionCreator sectionCreator = new SectionCreator(roomCreator);
        commercialBuilding.addSection(sectionCreator.createSection(1));        
        int sectionIndex = commercialBuilding.getSectionList().size() - 1; 
        return commercialBuilding.getSectionList().get(sectionIndex).getRoomList().get(0);
    }
    
    public Room createRoom(int sectionIndex) {
        RoomCreator roomCreator = new RoomCreator();
        commercialBuilding.getSectionList().get(sectionIndex).getRoomList().add(roomCreator.createRoom());
        int roomIndex = commercialBuilding.getSectionList().get(sectionIndex).getRoomList().size() - 1;
        return commercialBuilding.getSectionList().get(sectionIndex).getRoomList().get(roomIndex);
    }
    
    public ArrayList<String[]> getTableDisplayData() {
        return tableDisplayData;
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
            commercialBuilding = (CommercialBuilding)serialDataList.get(1);
            reloadTableDisplayData();
            reloadComboBoxModels();
            fireTableDataChanged();
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
    
    // returns a count of the number of rows
    public int getRowCount() {
        int numrows = 0;
        if (commercialBuilding != null) {
            ArrayList<Section> sections = (ArrayList<Section>) commercialBuilding.getSectionList();
            int numberOfSections = sections.size();
            for (int i=0; i<numberOfSections; i++) {
                Section section = sections.get(i);
                int numberOfRooms = section.getRoomList().size();
                for (int j=0; j<numberOfRooms; j++) {
                    Room room = section.getRoomList().get(j);
                    int numberOfSensors = room.getSensorList().size();
                    numrows = numrows + numberOfSensors;
                }
            }
        }
        return numrows;
    }
	
    // returns a count of the number of columns
    public int getColumnCount() {
        int numcols = 5;
        return numcols;
    }     
    
    // returns the data at the given row and column number
    public Object getValueAt(int row, int col) {
        if (commercialBuilding == null) {
            return null;
        }
        reloadTableDisplayData();
        return tableDisplayData.get(row)[col];
    }    

    /**
     * @return the nullSecurity
     */
    public NullSecurity getNullSecurity() {
        return nullSecurity;
    }

    /**
     * @return the breakinSecurity
     */
    public BreakinSecurity getBreakinSecurity() {
        return breakinSecurity;
    }

    /**
     * @return the fireSecurity
     */
    public FireSecurity getFireSecurity() {
        return fireSecurity;
    }

    /**
     * @return the seniorSecurity
     */
    public SeniorSecurity getSeniorSecurity() {
        return seniorSecurity;
    }

    /**
     * @return the simulator
     */
    public Simulator getSimulator() {
        return simulator;
    }
}
