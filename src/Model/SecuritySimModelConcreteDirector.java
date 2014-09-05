/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author hinsenchan
 */
//concrete director
public class SecuritySimModelConcreteDirector implements SecuritySimModelDirector {
    private static SecuritySimModelConcreteDirector instance = new SecuritySimModelConcreteDirector();
    
    //return single instance
    public static SecuritySimModelConcreteDirector getInstance() {
        return instance;
    }
    
    private SecuritySimModelConcreteDirector() {}
    
    //build application model
    public SecuritySimModel build(SecuritySimModelBuilder builder) {
        builder.buildController();
        builder.buildComboBoxModels();
        builder.buildColumnNames();
        builder.buildSetupSecurity();
        builder.buildSimulator();
        return builder.getSecuritySimBuilder();
    }
}
