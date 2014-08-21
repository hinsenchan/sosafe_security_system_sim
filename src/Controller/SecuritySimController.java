/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Billing.Customer;
import Model.SecuritySimModel;
import Model.Sensors.MotionSensor;
import Model.Sensors.NullSensor;
import Model.Sensors.SeniorSensor;
import Model.Sensors.Sensor;
import Model.Sensors.TemperatureSensor;
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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hinsenchan
 */
public class SecuritySimController {
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
    
    public SecuritySimController(SecuritySim securitySim) {
        this.securitySim = securitySim;
        this.securitySimModel = new SecuritySimModel(this);
        getPanelsFromView();
        setupPanelsInView();
        setupControllerInViews();
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
        //sensorDisplayPanel.setController(this);
        //controlPanel.setController(this);
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
        
        if (buildingID.equals("Add new...")) {
            Sensor sensor = new NullSensor();
            
            if (sensorType.equals("Motion Sensor")) { sensor = new MotionSensor(); }
            else if (sensorType.equals("Temperature Sensor")) { sensor = new TemperatureSensor(); }
            else if (sensorType.equals("Senior Sensor")) { sensor = new SeniorSensor(); }
            
            securitySimModel.createBuilding(buildingName, sensor);
            ArrayList<String[]> sensorSetupTable = securitySimModel.getSensorSetupTable();
            DefaultTableModel dtm = (DefaultTableModel)sensorSetupPanel.getTable().getModel();
            dtm.setRowCount(sensorSetupTable.size());
            for (int i=0; i<sensorSetupTable.size(); i++) {                
                for (int j=0; j<sensorSetupTable.get(i).length; j++) {
                    String value = sensorSetupTable.get(i)[j];
                    sensorSetupPanel.getTable().setValueAt(value, i, j);
                }
            }
        }
        else if (sectionID.equals("Add new...")) {
            Sensor sensor = new NullSensor();
            
            if (sensorType.equals("Motion Sensor")) { sensor = new MotionSensor(); }
            else if (sensorType.equals("Temperature Sensor")) { sensor = new TemperatureSensor(); }
            else if (sensorType.equals("Senior Sensor")) { sensor = new SeniorSensor(); }
            
            securitySimModel.createSection(sensor);            
            ArrayList<String[]> sensorSetupTable = securitySimModel.getSensorSetupTable();
            DefaultTableModel dtm = (DefaultTableModel)sensorSetupPanel.getTable().getModel();
            dtm.setRowCount(sensorSetupTable.size());            
            for (int i=0; i<sensorSetupTable.size(); i++) {                
                for (int j=0; j<sensorSetupTable.get(i).length; j++) {
                    String value = sensorSetupTable.get(i)[j];
                    sensorSetupPanel.getTable().setValueAt(value, i, j);
                }
            }            
        }
        
    }
    
    public void handleSimSensorSetupPanelBuildingButton() {
        String buildingSelected = sensorSetupPanel.getBuildingComboBox().getSelectedItem().toString();
        String[] areaModel = securitySimModel.getAreaModel();
        String[] roomModel = securitySimModel.getRoomModel();
        if (buildingSelected.equals("Add new...")) {
            sensorSetupPanel.getAreaComboBox().setModel(new DefaultComboBoxModel(new String[] { "Add new..." }));
            sensorSetupPanel.getRoomComboBox().setModel(new DefaultComboBoxModel(new String[] { "Add new..." }));
        }
        else {
            sensorSetupPanel.getAreaComboBox().setModel(new DefaultComboBoxModel(areaModel));
            sensorSetupPanel.getRoomComboBox().setModel(new DefaultComboBoxModel(roomModel));
        }
    }
    
    public void handleSimSensorSetupPanelAreaButton() {
        String areaSelected = sensorSetupPanel.getAreaComboBox().getSelectedItem().toString();
        String[] roomModel = securitySimModel.getRoomModel();
        if (areaSelected.equals("Add new...")) {
            sensorSetupPanel.getRoomComboBox().setModel(new DefaultComboBoxModel(new String[] { "Add new..." }));
        }
        else {
            sensorSetupPanel.getRoomComboBox().setModel(new DefaultComboBoxModel(roomModel));
        }        
    }
}
