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
public interface SecuritySimModelBuilder {            
    public void buildController();
    public void buildSimulator();
    public void buildComboBoxModels();
    public void buildColumnNames();
    public void buildSetupSecurity();
    public SecuritySimModel getSecuritySimBuilder();
}
