/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import View.SecuritySim;
import Model.SecuritySimModel;

/**
 *
 * @author hinsenchan
 */
//concrete builder
public class SecuritySimControllerConcreteBuilder implements SecuritySimControllerBuilder {
    private static SecuritySimControllerConcreteBuilder instance = new SecuritySimControllerConcreteBuilder();
    private SecuritySim securitySim = SecuritySim.getInstance();
    private SecuritySimController securitySimController = SecuritySimController.getInstance();
    private SecuritySimModel securitySimModel = SecuritySimModel.getInstance();
    
    //return single instance
    public static SecuritySimControllerConcreteBuilder getInstance() {
        return instance;
    }
    
    private SecuritySimControllerConcreteBuilder() {}
    
    //build view
    public void buildSimView() {
        securitySimController.setSecuritySim(securitySim);
    }
    //build model
    public void buildSimModel() {
        securitySimController.setSecuritySimModel(securitySimModel);
    }
    //set panels used in controller
    public void buildPanelsFromView() {
        securitySimController.getPanelsFromView();
    }
    //set controller used in each panel
    public void buildPanelsInView() {
        securitySimController.setupPanelsInView();
    }
    //set controller used in view
    public void buildControllerInViews() {
        securitySimController.setupControllerInViews();
    }
    //setup tables in panels
    public void buildPanelTables() {
        securitySimController.setupPanelTables();
    }
    //create simulator
    public void buildSimulator() {
        securitySimController.setupSimulator();
    }
    //return controller
    public SecuritySimController getSecuritySimController() {
        return securitySimController;
    }
            
}
