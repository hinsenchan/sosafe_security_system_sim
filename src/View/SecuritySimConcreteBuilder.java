/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import Controller.SecuritySimController;
import Controller.SecuritySimControllerBuilder;
import Controller.SecuritySimControllerConcreteBuilder;
import Controller.SecuritySimControllerConcreteDirector;
import Controller.SecuritySimControllerDirector;
import Model.SecuritySimModel;
import Model.SecuritySimModelBuilder;
import Model.SecuritySimModelConcreteBuilder;
import Model.SecuritySimModelConcreteDirector;
import Model.SecuritySimModelDirector;

/**
 *
 * @author hinsenchan
 */
public class SecuritySimConcreteBuilder implements SecuritySimBuilder {
    private static SecuritySimConcreteBuilder instance = new SecuritySimConcreteBuilder();
    private SimPanelConcreteFactory panelFactory = SimPanelConcreteFactory.getInstance();    
    private SecuritySim securitySim;
    private SecuritySimController securitySimController;
    private SecuritySimModel securitySimModel;

    public static SecuritySimConcreteBuilder getInstance() {
        return instance;
    }
    
    private SecuritySimConcreteBuilder() {}

    public void buildMVCInstances() {
        securitySim = SecuritySim.getInstance();
        securitySimController = SecuritySimController.getInstance();
        securitySimModel = SecuritySimModel.getInstance();        
    }
    public void buildMVCStates() {
        SecuritySimModelBuilder modelBuilder = SecuritySimModelConcreteBuilder.getInstance();
        SecuritySimModelDirector modelDirector = SecuritySimModelConcreteDirector.getInstance();
        securitySimModel = modelDirector.build(modelBuilder);
        
        SecuritySimControllerBuilder controllerBuilder = SecuritySimControllerConcreteBuilder.getInstance();
        SecuritySimControllerDirector controllerDirector = SecuritySimControllerConcreteDirector.getInstance();
        securitySimController = controllerDirector.build(controllerBuilder);
    }
    public void buildBillPanel() {
        securitySim.setBillPanel(panelFactory.createBillPanel());
    }
    public void buildCustomerPanel() {
        securitySim.setCustomerPanel(panelFactory.createCustomPanel());
    }
    public void buildMapPanel() {
        securitySim.setMapPanel(panelFactory.createMapPanel());
    }
    public void buildSensorSetupPanel() {
        securitySim.setSensorSetupPanel(panelFactory.createSensorSetupPanel());
    }
    public void buildSensorDisplayPanel() {
        securitySim.setSensorDisplayPanel(panelFactory.createSensorDisplayPanel());
    }
    public void buildControlPanel() {
        securitySim.setControlPanel(panelFactory.createControlPanel());
    }
    public void buildController() {
        securitySim.setSecuritySimController(securitySimController);
    }
    public SecuritySim getSecuritySim() {
        return securitySim;
    }     
}
