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
//concrete director for security sim
public class SecuritySimConcreteDirector implements SecuritySimDirector {
    private static SecuritySimConcreteDirector instance = new SecuritySimConcreteDirector();
    
    //return single instance
    public static SecuritySimConcreteDirector getInstance() {
        return instance;
    }
    
    private SecuritySimConcreteDirector() {}
    
    //steps to build security sim
    public SecuritySim build(SecuritySimBuilder builder) {
        builder.buildMVCInstances();
        builder.buildBillPanel();
        builder.buildControlPanel();
        builder.buildCustomerPanel();
        builder.buildMapPanel();
        builder.buildSensorDisplayPanel();
        builder.buildSensorSetupPanel();
        builder.buildController();
        builder.buildMVCStates();
        return builder.getSecuritySim();
    }
}
