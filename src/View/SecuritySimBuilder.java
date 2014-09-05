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
//builder for securitysim
public interface SecuritySimBuilder {
    public void buildMVCInstances();
    public void buildMVCStates();
    public void buildBillPanel();
    public void buildCustomerPanel();
    public void buildMapPanel();
    public void buildSensorSetupPanel();
    public void buildSensorDisplayPanel();
    public void buildControlPanel();
    public void buildController();
    public SecuritySim getSecuritySim();    
}
