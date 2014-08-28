/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

/**
 *
 * @author hinsenchan
 */
public class SimPanelConcreteFactory implements SimPanelAbstractFactory{  
    private static SimPanelConcreteFactory instance;
    
    public synchronized static SimPanelConcreteFactory getInstance() {
        if (instance == null) {
            instance = new SimPanelConcreteFactory();
        }
        return instance;
    }
    
    private SimPanelConcreteFactory() {}
    
    public SimBillPanel createBillPanel() {
        return SimBillPanel.getInstance();
    }
    public SimControlPanel createControlPanel() {
        return SimControlPanel.getInstance();
    }
    public SimCustomerPanel createCustomPanel() {
        return SimCustomerPanel.getInstance();
    }
    public SimMapPanel createMapPanel() {
        return SimMapPanel.getInstance();
    }
    public SimSensorDisplayPanel createSensorDisplayPanel() {
        return SimSensorDisplayPanel.getInstance();
    }
    public SimSensorSetupPanel createSensorSetupPanel() {
        return SimSensorSetupPanel.getInstance();
    }
}
