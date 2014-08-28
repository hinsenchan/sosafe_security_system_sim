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
public class SecuritySimModelConcreteBuilder implements SecuritySimModelBuilder {
    private static SecuritySimModelConcreteBuilder instance = new SecuritySimModelConcreteBuilder();
    private SecuritySimModel securitySimModel = SecuritySimModel.getInstance();
    private SecuritySimController securitySimController = SecuritySimController.getInstance();
    private Simulator simulator = Simulator.getInstance();
    
    public static SecuritySimModelConcreteBuilder getInstance() {
        return instance;
    } 
    
    private SecuritySimModelConcreteBuilder() {}
    
    public void buildController() {
        securitySimModel.setSecuritySimController(securitySimController);
    }
    public void buildSimulator() {
        securitySimModel.setSimulator(simulator);
        simulator.setSecuritySimModel(securitySimModel);
    }
    public void buildComboBoxModels() {
        securitySimModel.setupComboBoxModels();
    }
    public void buildColumnNames() {
        securitySimModel.setupColumnNames();
    }
    public void buildSetupSecurity() {
        securitySimModel.setupSecurity();
    }
    public SecuritySimModel getSecuritySimBuilder() {
        return securitySimModel;
    }
}
