/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Billing.Customer;
import Model.Building.CommercialBuilding;
import Model.Building.Room;
import Model.Building.Section;
import Model.SecuritySimModel;
import Model.SecuritySystem.Security;
import Simulator.Simulator;
import View.SecuritySim;
import View.SimBillPanel;
import View.SimControlPanel;
import View.SimCustomerPanel;
import View.SimMapPanel;
import View.SimSensorDisplayPanel;
import View.SimSensorSetupPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 *
 * @author hinsenchan
 */
public class SecuritySimController implements ListSelectionListener, TableModelListener{
    private SecuritySim securitySim;
    private JPanel accountLeftPanel;
    private JPanel accountRightPanel;
    private JPanel setupLeftPanel;
    private JPanel setupRightPanel;
    private JPanel simulationLeftPanel;
    private JPanel simulationRightPanel;
    private SimBillPanel billPanel;
    private SimCustomerPanel customerPanel;
    private SimMapPanel mapPanel;
    private SimSensorSetupPanel sensorSetupPanel;
    private SimSensorDisplayPanel sensorDisplayPanel;
    private SimControlPanel controlPanel;
    private SecuritySimModel securitySimModel;
    private Simulator simulator;
    
    public SecuritySimController(SecuritySim securitySim) {
        this.securitySim = securitySim;
        this.securitySimModel = new SecuritySimModel(this);
        getPanelsFromView();
        setupPanelsInView();
        setupControllerInViews();
        
        sensorSetupPanel.getTable().setModel(securitySimModel); // set the table model using the controller
        sensorSetupPanel.getTable().getSelectionModel().addListSelectionListener(this);
        sensorSetupPanel.getTable().getModel().addTableModelListener(this); // add a listener to the table model
        
        sensorDisplayPanel.getTable().setModel(securitySimModel);
        sensorDisplayPanel.getTable().getSelectionModel().addListSelectionListener(this);
        sensorDisplayPanel.getTable().getModel().addTableModelListener(this); // add a listener to the table model                
        
        simulator = securitySimModel.getSimulator();
        simulator.setConsole(controlPanel.getConsoleTextField());
        simulator.setPanel(controlPanel);    
    }
    
    public void getPanelsFromView() {
        accountLeftPanel = securitySim.getAccountLeftPanel();
        accountRightPanel = securitySim.getAccountRightPanel();
        setupLeftPanel = securitySim.getSetupLeftPanel();
        setupRightPanel = securitySim.getSetupRightPanel();
        simulationLeftPanel = securitySim.getSimulationLeftPanel();
        simulationRightPanel = securitySim.getSimulationRightPanel();
        billPanel = securitySim.getBillPanel();        
        customerPanel = securitySim.getCustomerPanel();
        mapPanel = securitySim.getMapPanel();
        sensorSetupPanel = securitySim.getSensorSetupPanel();
        sensorDisplayPanel = securitySim.getSensorDisplayPanel();
        controlPanel = securitySim.getControlPanel();        
    }
    
    public void setupPanelsInView() {
        accountLeftPanel.setLayout(new BorderLayout());
        accountLeftPanel.add(billPanel, BorderLayout.CENTER);
        accountRightPanel.setLayout(new BorderLayout());
        accountRightPanel.add(customerPanel, BorderLayout.CENTER);
        setupLeftPanel.setLayout(new BorderLayout());
        setupLeftPanel.add(mapPanel, BorderLayout.CENTER);
        setupRightPanel.setLayout(new BorderLayout());
        sensorSetupPanel.getBuildingComboBox().setModel(new DefaultComboBoxModel(securitySimModel.getBuildingModel()));
        sensorSetupPanel.getAreaComboBox().setModel(new DefaultComboBoxModel(securitySimModel.getAreaModel()));
        sensorSetupPanel.getRoomComboBox().setModel(new DefaultComboBoxModel(securitySimModel.getRoomModel()));
        sensorSetupPanel.getSensorComboBox().setModel(new DefaultComboBoxModel(securitySimModel.getSensorModel()));        
        setupRightPanel.add(sensorSetupPanel, BorderLayout.CENTER);
        simulationLeftPanel.setLayout(new BorderLayout());
        simulationLeftPanel.add(sensorDisplayPanel, BorderLayout.CENTER);
        simulationRightPanel.setLayout(new FlowLayout());
        simulationRightPanel.add(controlPanel);         
    }
    
    public void setupControllerInViews() {
        billPanel.setController(this);
        customerPanel.setController(this);
        //mapPanel.setController(this);
        sensorSetupPanel.setController(this);
        sensorDisplayPanel.setController(this);
        controlPanel.setController(this);
    }
    
    public void handleSimCustomerPanelNew() {
        securitySimModel.newModel();
        customerPanel.getContractIDTextField().setText("");
        customerPanel.getNameTextField().setText("");
        customerPanel.getEmailTextField().setText("");
        customerPanel.getPhoneTextField().setText("");
        customerPanel.getEmergencyTextField().setText(""); 
    }
        
    public void handleSimCustomerPanelLoad() {
        securitySimModel.loadModel();
        String id = securitySimModel.getCustomer().getServiceContractId();
        customerPanel.getContractIDTextField().setText(id);
        String name = securitySimModel.getCustomer().getName();
        customerPanel.getNameTextField().setText(name);
        String email = securitySimModel.getCustomer().getEmailId();
        customerPanel.getEmailTextField().setText(email);
        String phone = securitySimModel.getCustomer().getPhoneNumber();
        customerPanel.getPhoneTextField().setText(phone);
        String emergency = securitySimModel.getCustomer().getEmergencyContact();
        customerPanel.getEmergencyTextField().setText(emergency); 
    }
        
    public void handleSimCustomerPanelSave() {
        String id = customerPanel.getContractIDTextField().getText();
        String name = customerPanel.getNameTextField().getText();
        String email = customerPanel.getEmailTextField().getText();
        String phone = customerPanel.getPhoneTextField().getText();
        String emergency = customerPanel.getEmergencyTextField().getText();        
        securitySimModel.setCustomer(name, phone, email, emergency, id);
        securitySimModel.saveModel();
    }
    
    public void handleSimCustomerPanelPrint() {
        Customer customer;
        
        if ((customer = securitySimModel.getCustomer()) != null) {
            String output = customer.toString();
            billPanel.getMainTextArea().setText(output);
        }
        else {
            handleSimCustomerPanelSave();
            customer = securitySimModel.getCustomer();
            String output = customer.toString();
            billPanel.getMainTextArea().setText(output);
        }
    }
    
    public void handleSimSensorSetupPanelAdd() {
        String buildingName = sensorSetupPanel.getBuildingTextField().getText();
        String buildingID = sensorSetupPanel.getBuildingComboBox().getSelectedItem().toString();
        String sectionID = sensorSetupPanel.getAreaComboBox().getSelectedItem().toString();
        String roomID = sensorSetupPanel.getRoomComboBox().getSelectedItem().toString();
        String sensorType = sensorSetupPanel.getSensorComboBox().getSelectedItem().toString();

        Security security = securitySimModel.getNullSecurity();
        if (sensorType.equals("Motion Sensor")) { security = securitySimModel.getBreakinSecurity(); }
        else if (sensorType.equals("Temperature Sensor")) { security = securitySimModel.getFireSecurity(); }
        else if (sensorType.equals("Senior Sensor")) { security = securitySimModel.getSeniorSecurity(); }        
        
        if (buildingID.equals("Add new...")) {            
            Room room = securitySimModel.createBuilding(buildingName);
            security.addSecurityTo(room);
        }
        else if (sectionID.equals("Add new...")) {
            Room room = securitySimModel.createSection();
            security.addSecurityTo(room);
        }        
        else if (roomID.equals("Add new...")) {
            CommercialBuilding cb = securitySimModel.getBuilding();
            int sectionIndex = -1;

            for (int i=0; i<cb.getSectionList().size(); i++) {
                if (cb.getSectionList().get(i).getSectionId() == Integer.parseInt(sectionID)) {
                    sectionIndex = i;
                    break;
                }
            }
            
            Room room = securitySimModel.createRoom(sectionIndex);
            security.addSecurityTo(room);            
        }
        else {
            CommercialBuilding cb = securitySimModel.getBuilding();
            int sectionIndex = -1;
            int roomIndex = -1;
            Room room;

            for (int i=0; i<cb.getSectionList().size(); i++) {
                if (cb.getSectionList().get(i).getSectionId() == Integer.parseInt(sectionID)) {
                    for (int j=0; j<cb.getSectionList().get(i).getRoomList().size(); j++) {
                        if (cb.getSectionList().get(i).getRoomList().get(j).getRoomId() == Integer.parseInt(roomID)) {
                            room = cb.getSectionList().get(i).getRoomList().get(j);
                            security.addSecurityTo(room); 
                            break;
                        }
                    }
                }
            }                        
        }        
        
        securitySimModel.reloadTableDisplayData();
        securitySimModel.fireTableDataChanged();
    }
    
    public void handleSimSensorSetupPanelBuildingButton() {
        String buildingSelected = sensorSetupPanel.getBuildingComboBox().getSelectedItem().toString();
        String[] areaModel = securitySimModel.getAreaModel();
        String[] roomModel = securitySimModel.getRoomModel();
        if (buildingSelected.equals("Select a building...")) {
            sensorSetupPanel.getAreaComboBox().setModel(new DefaultComboBoxModel(areaModel));
            sensorSetupPanel.getRoomComboBox().setModel(new DefaultComboBoxModel(roomModel));            
        }
        else if (buildingSelected.equals("Add new...")) {
            sensorSetupPanel.getAreaComboBox().setModel(new DefaultComboBoxModel(new String[] { "Add new..." }));
            sensorSetupPanel.getRoomComboBox().setModel(new DefaultComboBoxModel(new String[] { "Add new..." }));
        }
        else {
            CommercialBuilding building = securitySimModel.getBuilding();
            ArrayList<String> filteredSectionModel = new ArrayList<String>();            
            filteredSectionModel.add("Add new...");            
            for (int i=0; i<building.getSectionList().size(); i++) {
                filteredSectionModel.add(Integer.toString(building.getSectionList().get(i).getSectionId()));
            }            
            String[] stringSectionModel = new String[filteredSectionModel.size()];
            sensorSetupPanel.getAreaComboBox().setModel(new DefaultComboBoxModel(filteredSectionModel.toArray(stringSectionModel)));
        }
    }
    
    public void handleSimSensorSetupPanelAreaButton() {
        String areaSelected = sensorSetupPanel.getAreaComboBox().getSelectedItem().toString();
        String[] roomModel = securitySimModel.getRoomModel();
        if (areaSelected.equals("Select an area...")){
            sensorSetupPanel.getRoomComboBox().setModel(new DefaultComboBoxModel(roomModel));
        }           
        else if (areaSelected.equals("Add new...")) {
            sensorSetupPanel.getRoomComboBox().setModel(new DefaultComboBoxModel(new String[] { "Add new..." }));
        }    
        else {
            Section section = securitySimModel.getBuilding().getSectionList().get(Integer.parseInt(areaSelected));
            ArrayList<String> filteredRoomModel = new ArrayList<String>();            
            filteredRoomModel.add("Add new...");
            for (int i=0; i<section.getRoomList().size(); i++) {
                filteredRoomModel.add(Integer.toString(section.getRoomList().get(i).getRoomId()));
            }            
            String[] stringRoomModel = new String[filteredRoomModel.size()];
            sensorSetupPanel.getRoomComboBox().setModel(new DefaultComboBoxModel(filteredRoomModel.toArray(stringRoomModel)));
        }
    }
    
    public void valueChanged(ListSelectionEvent e) {
        System.out.println("value changed fired");
    }
    
    public void tableChanged(TableModelEvent e) {
        reloadComboBoxModels(); 
    }    
    
    public void reloadComboBoxModels() {
        securitySimModel.reloadComboBoxModels();
        sensorSetupPanel.getBuildingComboBox().setModel(new DefaultComboBoxModel(securitySimModel.getBuildingModel()));                                    
        sensorSetupPanel.getAreaComboBox().setModel(new DefaultComboBoxModel(securitySimModel.getAreaModel()));                        
        sensorSetupPanel.getRoomComboBox().setModel(new DefaultComboBoxModel(securitySimModel.getRoomModel()));                            
    }

    public void handleSimArmButton() {
        simulator.pushArm();
    }
    
    public void handleSimDisarmButton() {
        simulator.pushDisarm();
    }
    
    public void handleSimStatusButton() {
        simulator.pushStatus();
    }
    
    public void handleSimScheduleButton() {
        simulator.pushSchedule();
    }    
    
    public void handleSimEmergencyButton() {
        simulator.pushEmergency();
    }
    
    public void handleSimTestButton() {
        simulator.pushTest();
    }    
    
    public void handleSimOneButton() {
        simulator.pushOne();
    }    
    
    public void handleSimTwoButton() {
        simulator.pushTwo();
    }
    
    public void handleSimThreeButton() {
        simulator.pushThree();
    }
    
    public void handleSimFourButton() {
        simulator.pushFour();
    }
    
    public void handleSimFiveButton() {
        simulator.pushFive();
    }
    
    public void handleSimSixButton() {
        simulator.pushSix();
    }
    
    public void handleSimSevenButton() {
        simulator.pushSeven();
    }
    
    public void handleSimEightButton() {
        simulator.pushEight();
    }
    
    public void handleSimNineButton() {
        simulator.pushNine();
    }
    
    public void handleSimStarButton() {
        simulator.pushStar();
    }
    
    public void handleSimZeroButton() {
        simulator.pushZero();
    }
    
    public void handleSimPoundButton() {
        simulator.pushPound();
    }    
}