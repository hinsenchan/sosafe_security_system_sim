/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

/**
 *
 * @author hinsenchan
 */
public interface SecuritySimControllerBuilder {
    public void buildSimView();
    public void buildSimModel();
    public void buildPanelsFromView();
    public void buildPanelsInView();
    public void buildControllerInViews();
    public void buildPanelTables();
    public void buildSimulator();
    public SecuritySimController getSecuritySimController();
}
