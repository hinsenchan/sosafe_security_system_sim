/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Billing.Bills;
import Model.Billing.Customer;
import Model.Billing.FireSecurityBills;
import Model.Billing.MotionSecurityBills;
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
import javax.swing.JOptionPane;
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
    private static SecuritySimController instance;
    
    public synchronized static SecuritySimController getInstance() {
        if (instance == null) {
            instance = new SecuritySimController();            
        }
        return instance;
    }
    
    private SecuritySimController() {}
    
    public void getPanelsFromView() {
        accountLeftPanel = getSecuritySim().getAccountLeftPanel();
        accountRightPanel = getSecuritySim().getAccountRightPanel();
        setupLeftPanel = getSecuritySim().getSetupLeftPanel();
        setupRightPanel = getSecuritySim().getSetupRightPanel();
        simulationLeftPanel = getSecuritySim().getSimulationLeftPanel();
        simulationRightPanel = getSecuritySim().getSimulationRightPanel();
        billPanel = getSecuritySim().getBillPanel();        
        customerPanel = getSecuritySim().getCustomerPanel();
        mapPanel = getSecuritySim().getMapPanel();
        sensorSetupPanel = getSecuritySim().getSensorSetupPanel();
        sensorDisplayPanel = getSecuritySim().getSensorDisplayPanel();
        controlPanel = getSecuritySim().getControlPanel();        
    }
    
    public void setupPanelsInView() {
        accountLeftPanel.setLayout(new BorderLayout());
        accountLeftPanel.add(billPanel, BorderLayout.CENTER);
        accountRightPanel.setLayout(new BorderLayout());
        accountRightPanel.add(customerPanel, BorderLayout.CENTER);
        setupLeftPanel.setLayout(new BorderLayout());
        setupLeftPanel.add(mapPanel, BorderLayout.CENTER);
        setupRightPanel.setLayout(new BorderLayout());
        sensorSetupPanel.getBuildingComboBox().setModel(new DefaultComboBoxModel(getSecuritySimModel().getBuildingModel()));
        sensorSetupPanel.getAreaComboBox().setModel(new DefaultComboBoxModel(getSecuritySimModel().getAreaModel()));
        sensorSetupPanel.getRoomComboBox().setModel(new DefaultComboBoxModel(getSecuritySimModel().getRoomModel()));
        sensorSetupPanel.getSensorComboBox().setModel(new DefaultComboBoxModel(getSecuritySimModel().getSensorModel()));        
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
    
    public void setupPanelTables() {
        sensorSetupPanel.getTable().setModel(getSecuritySimModel()); // set the table model using the controller
        sensorSetupPanel.getTable().getSelectionModel().addListSelectionListener(this);
        sensorSetupPanel.getTable().getModel().addTableModelListener(this); // add a listener to the table model
        
        sensorDisplayPanel.getTable().setModel(getSecuritySimModel());
        sensorDisplayPanel.getTable().getSelectionModel().addListSelectionListener(this);
        sensorDisplayPanel.getTable().getModel().addTableModelListener(this); // add a listener to the table model                        
    }
    
    public void setupSimulator() {
        setSimulator(getSecuritySimModel().getSimulator());
        getSimulator().setConsole(controlPanel.getConsoleTextField());
        getSimulator().setPanel(controlPanel);         
    }
    
    public void handleSimCustomerPanelNew() {
        getSecuritySimModel().newModel();
        customerPanel.getContractIDTextField().setText("");
        customerPanel.getNameTextField().setText("");
        customerPanel.getEmailTextField().setText("");
        customerPanel.getPhoneTextField().setText("");
        customerPanel.getEmergencyTextField().setText(""); 
    }
        
    public void handleSimCustomerPanelLoad() {
        getSecuritySimModel().loadModel();
        String id = getSecuritySimModel().getCustomer().getServiceContractId();
        customerPanel.getContractIDTextField().setText(id);
        String name = getSecuritySimModel().getCustomer().getName();
        customerPanel.getNameTextField().setText(name);
        String email = getSecuritySimModel().getCustomer().getEmailId();
        customerPanel.getEmailTextField().setText(email);
        String phone = getSecuritySimModel().getCustomer().getPhoneNumber();
        customerPanel.getPhoneTextField().setText(phone);
        String emergency = getSecuritySimModel().getCustomer().getEmergencyContact();
        customerPanel.getEmergencyTextField().setText(emergency); 
    }
        
    public void handleSimCustomerPanelSave() {
        String id = customerPanel.getContractIDTextField().getText();
        String name = customerPanel.getNameTextField().getText();
        String email = customerPanel.getEmailTextField().getText();
        String phone = customerPanel.getPhoneTextField().getText();
        String emergency = customerPanel.getEmergencyTextField().getText();        
        getSecuritySimModel().setCustomer(name, phone, email, emergency, id);
        getSecuritySimModel().saveModel();
    }
    
    public void handleSimCustomerPanelPrint() {
        Customer customer = new Customer("","","","","");
        Bills motionBill;
        Bills fireBill;
        String output = "";

        if (getSecuritySimModel().getCustomer() != null) {
            customer = getSecuritySimModel().getCustomer();            
        }
        else {
            handleSimCustomerPanelSave();
            customer = getSecuritySimModel().getCustomer();            
        }
        if (getSecuritySimModel().getBreakinSecurity() != null) {
            motionBill = new MotionSecurityBills(getSecuritySimModel().getBuilding(), 
                    getSecuritySimModel().getBreakinSecurity(), customer);   
            output += "Breakin Security:\n";
            output += motionBill.toString();
        }
        if (getSecuritySimModel().getFireSecurity() != null) {
            motionBill = new FireSecurityBills(getSecuritySimModel().getBuilding(), 
                    getSecuritySimModel().getFireSecurity(), customer);            
            output += "Fire Security:\n";
            output += motionBill.toString();
        }
        billPanel.getMainTextArea().setText(output);
    }
    
    public void handleSimSensorSetupPanelAdd() {
        try {
            String buildingName = "Building 1";
            String buildingID = sensorSetupPanel.getBuildingComboBox().getSelectedItem().toString();
            String sectionID = sensorSetupPanel.getAreaComboBox().getSelectedItem().toString();
            String roomID = sensorSetupPanel.getRoomComboBox().getSelectedItem().toString();
            String sensorType = sensorSetupPanel.getSensorComboBox().getSelectedItem().toString();
            
            if (buildingID.equals("Select a building...") || sectionID.equals("Select an area... ") || 
                    sectionID.equals("Select a room...") || sensorType.equals("Select a sensor...")) {
                JOptionPane.showMessageDialog(sensorSetupPanel, "Please select an option for each item");
            }
            else {
                Security security = getSecuritySimModel().getNullSecurity();
                if (sensorType.equals("Motion Sensor")) { security = getSecuritySimModel().getBreakinSecurity(); }
                else if (sensorType.equals("Temperature Sensor")) { security = getSecuritySimModel().getFireSecurity(); }
                else if (sensorType.equals("Senior Sensor")) { security = getSecuritySimModel().getSeniorSecurity(); }        

                if (buildingID.equals("Add new...")) {            
                    Room room = getSecuritySimModel().createBuilding(buildingName);
                    security.addSecurityTo(room);
                }
                else if (sectionID.equals("Add new...") && roomID.equals("Add new...")) {
                    Room room = getSecuritySimModel().createSection();
                    security.addSecurityTo(room);
                }        
                else if (roomID.equals("Add new...")) {
                    CommercialBuilding cb = getSecuritySimModel().getBuilding();
                    int sectionIndex = -1;

                    for (int i=0; i<cb.getSectionList().size(); i++) {
                        if (cb.getSectionList().get(i).getSectionId() == Integer.parseInt(sectionID)) {
                            sectionIndex = i;
                            break;
                        }
                    }

                    Room room = getSecuritySimModel().createRoom(sectionIndex);
                    security.addSecurityTo(room);            
                }
                else {
                    CommercialBuilding cb = getSecuritySimModel().getBuilding();
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

                getSecuritySimModel().reloadTableDisplayData();
                getSecuritySimModel().fireTableDataChanged();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(sensorSetupPanel, "Please select an option for each item");
        }
    }
    
    public void handleSimSensorSetupPanelBuildingButton() {
        String buildingSelected = sensorSetupPanel.getBuildingComboBox().getSelectedItem().toString();
        String[] areaModel = getSecuritySimModel().getAreaModel();
        String[] roomModel = getSecuritySimModel().getRoomModel();
        if (buildingSelected.equals("Select a building...")) {
            sensorSetupPanel.getAreaComboBox().setModel(new DefaultComboBoxModel(areaModel));
            sensorSetupPanel.getRoomComboBox().setModel(new DefaultComboBoxModel(roomModel));            
        }
        else if (buildingSelected.equals("Add new...")) {
            sensorSetupPanel.getAreaComboBox().setModel(new DefaultComboBoxModel(new String[] { "Add new..." }));
            sensorSetupPanel.getRoomComboBox().setModel(new DefaultComboBoxModel(new String[] { "Add new..." }));
        }
        else {
            CommercialBuilding building = getSecuritySimModel().getBuilding();
            ArrayList<String> filteredSectionModel = new ArrayList<String>();   
            filteredSectionModel.add("Select an area...");
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
        String[] roomModel = getSecuritySimModel().getRoomModel();
        if (areaSelected.equals("Select an area...")){
            sensorSetupPanel.getRoomComboBox().setModel(new DefaultComboBoxModel(roomModel));
        }           
        else if (areaSelected.equals("Add new...")) {
            sensorSetupPanel.getRoomComboBox().setModel(new DefaultComboBoxModel(new String[] { "Add new..." }));
        }    
        else {
            Section section = getSecuritySimModel().getBuilding().getSectionList().get(Integer.parseInt(areaSelected));
            ArrayList<String> filteredRoomModel = new ArrayList<String>();            
            filteredRoomModel.add("Select a room...");
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
        getSecuritySimModel().reloadComboBoxModels();
        sensorSetupPanel.getBuildingComboBox().setModel(new DefaultComboBoxModel(getSecuritySimModel().getBuildingModel()));                                    
        sensorSetupPanel.getAreaComboBox().setModel(new DefaultComboBoxModel(getSecuritySimModel().getAreaModel()));                        
        sensorSetupPanel.getRoomComboBox().setModel(new DefaultComboBoxModel(getSecuritySimModel().getRoomModel()));                            
    }

    public void handleSimArmButton() {
        if (securitySimModel.getBuilding() != null)
            getSimulator().pushArm();
    }
    
    public void handleSimDisarmButton() {
        if (securitySimModel.getBuilding() != null)        
            getSimulator().pushDisarm();
    }
    
    public void handleSimStatusButton() {
        if (securitySimModel.getBuilding() != null)        
            getSimulator().pushStatus();
    }
    
    public void handleSimScheduleButton() {
        if (securitySimModel.getBuilding() != null)        
            getSimulator().pushSchedule();
    }    
    
    public void handleSimEmergencyButton() {
        if (securitySimModel.getBuilding() != null)        
            getSimulator().pushEmergency();
    }
    
    public void handleSimTestButton() {
        if (securitySimModel.getBuilding() != null)        
            getSimulator().pushTest();
    }    
    
    public void handleSimOneButton() {
        getSimulator().pushOne();
    }    
    
    public void handleSimTwoButton() {
        getSimulator().pushTwo();
    }
    
    public void handleSimThreeButton() {
        getSimulator().pushThree();
    }
    
    public void handleSimFourButton() {
        getSimulator().pushFour();
    }
    
    public void handleSimFiveButton() {
        getSimulator().pushFive();
    }
    
    public void handleSimSixButton() {
        getSimulator().pushSix();
    }
    
    public void handleSimSevenButton() {
        getSimulator().pushSeven();
    }
    
    public void handleSimEightButton() {
        getSimulator().pushEight();
    }
    
    public void handleSimNineButton() {
        getSimulator().pushNine();
    }
    
    public void handleSimStarButton() {
        getSimulator().pushStar();
    }
    
    public void handleSimZeroButton() {
        getSimulator().pushZero();
    }
    
    public void handleSimPoundButton() {
        getSimulator().pushPound();
    }    

    /**
     * @return the securitySim
     */
    public SecuritySim getSecuritySim() {
        return securitySim;
    }

    /**
     * @param securitySim the securitySim to set
     */
    public void setSecuritySim(SecuritySim securitySim) {
        this.securitySim = securitySim;
    }

    /**
     * @return the securitySimModel
     */
    public SecuritySimModel getSecuritySimModel() {
        return securitySimModel;
    }

    /**
     * @param securitySimModel the securitySimModel to set
     */
    public void setSecuritySimModel(SecuritySimModel securitySimModel) {
        this.securitySimModel = securitySimModel;
    }

    /**
     * @return the simulator
     */
    public Simulator getSimulator() {
        return simulator;
    }

    /**
     * @param simulator the simulator to set
     */
    public void setSimulator(Simulator simulator) {
        this.simulator = simulator;
    }
}