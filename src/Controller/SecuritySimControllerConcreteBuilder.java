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
public class SecuritySimControllerConcreteBuilder implements SecuritySimControllerBuilder {
    private static SecuritySimControllerConcreteBuilder instance = new SecuritySimControllerConcreteBuilder();
    private SecuritySim securitySim = SecuritySim.getInstance();
    private SecuritySimController securitySimController = SecuritySimController.getInstance();
    private SecuritySimModel securitySimModel = SecuritySimModel.getInstance();
    
    public static SecuritySimControllerConcreteBuilder getInstance() {
        return instance;
    }
    
    private SecuritySimControllerConcreteBuilder() {}
    
    public void buildSimView() {
        securitySimController.setSecuritySim(securitySim);
    }
    public void buildSimModel() {
        securitySimController.setSecuritySimModel(securitySimModel);
    }
    public void buildPanelsFromView() {
        securitySimController.getPanelsFromView();
    }
    public void buildPanelsInView() {
        securitySimController.setupPanelsInView();
    }
    public void buildControllerInViews() {
        securitySimController.setupControllerInViews();
    }
    public void buildPanelTables() {
        securitySimController.setupPanelTables();
    }
    public void buildSimulator() {
        securitySimController.setupSimulator();
    }
    public SecuritySimController getSecuritySimController() {
        return securitySimController;
    }
            
}
