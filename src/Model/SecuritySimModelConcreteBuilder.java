/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Controller.SecuritySimController;
import Simulator.Simulator;

/**
 *
 * @author hinsenchan
 */
//concrete builder
public class SecuritySimModelConcreteBuilder implements SecuritySimModelBuilder {
    private static SecuritySimModelConcreteBuilder instance = new SecuritySimModelConcreteBuilder();
    private SecuritySimModel securitySimModel = SecuritySimModel.getInstance();
    private SecuritySimController securitySimController = SecuritySimController.getInstance();
    private Simulator simulator = Simulator.getInstance();
    
    //return single instance
    public static SecuritySimModelConcreteBuilder getInstance() {
        return instance;
    } 
    
    private SecuritySimModelConcreteBuilder() {}
    
    //set controller for model
    public void buildController() {
        securitySimModel.setSecuritySimController(securitySimController);
    }
    //set simulator for model
    public void buildSimulator() {
        securitySimModel.setSimulator(simulator);
        simulator.setSecuritySimModel(securitySimModel);
    }
    //set comboxes for model
    public void buildComboBoxModels() {
        securitySimModel.setupComboBoxModels();
    }
    //set table column names for model
    public void buildColumnNames() {
        securitySimModel.setupColumnNames();
    }
    //set security for model
    public void buildSetupSecurity() {
        securitySimModel.setupSecurity();
    }
    //return application model
    public SecuritySimModel getSecuritySimBuilder() {
        return securitySimModel;
    }
}
