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
//abstract factory for security sim panel family
public interface SimPanelAbstractFactory {
    public SimBillPanel createBillPanel();
    public SimControlPanel createControlPanel();
    public SimCustomerPanel createCustomPanel();
    public SimMapPanel createMapPanel();
    public SimSensorDisplayPanel createSensorDisplayPanel();
    public SimSensorSetupPanel createSensorSetupPanel();
}
