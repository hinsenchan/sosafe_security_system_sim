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
//concrete factory for security sim
public class SimPanelConcreteFactory implements SimPanelAbstractFactory{  
    private static SimPanelConcreteFactory instance;
    
    //return single instance
    public synchronized static SimPanelConcreteFactory getInstance() {
        if (instance == null) {
            instance = new SimPanelConcreteFactory();
        }
        return instance;
    }
    
    private SimPanelConcreteFactory() {}
    
    //create bill screen
    public SimBillPanel createBillPanel() {
        return SimBillPanel.getInstance();
    }
    //create control screen
    public SimControlPanel createControlPanel() {
        return SimControlPanel.getInstance();
    }
    //create custom screen
    public SimCustomerPanel createCustomPanel() {
        return SimCustomerPanel.getInstance();
    }
    //create map screen
    public SimMapPanel createMapPanel() {
        return SimMapPanel.getInstance();
    }
    //create sensor display screen
    public SimSensorDisplayPanel createSensorDisplayPanel() {
        return SimSensorDisplayPanel.getInstance();
    }
    //create sensor setup screen
    public SimSensorSetupPanel createSensorSetupPanel() {
        return SimSensorSetupPanel.getInstance();
    }
}
