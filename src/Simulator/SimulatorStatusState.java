/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Simulator;

import Model.SecuritySystem.BreakinSecurity;
import Model.SecuritySystem.FireSecurity;
import Model.SecuritySystem.SeniorSecurity;

/**
 *
 * @author hinsenchan
 */
//status state
public class SimulatorStatusState implements SimulatorState {
    private Simulator simulator;
    
    SimulatorStatusState(Simulator simulator) {
        this.simulator = simulator;
    }
    //run status check
    public void runFunction() {
        BreakinSecurity motionDetect = simulator.getSecuritySimModel().getBreakinSecurity();  
        FireSecurity fireDetect = simulator.getSecuritySimModel().getFireSecurity();
        SeniorSecurity seniorDetect = simulator.getSecuritySimModel().getSeniorSecurity();
        boolean alarm = false;
        
        String status = "Status: ";

        if (!motionDetect.isStatus()) {
            status += "<motion detected> ";
            alarm = true;
        }
        if (!fireDetect.isStatus()) {
            status += "<fire detected> ";
            alarm = true;
        }
        if (!seniorDetect.isStatus()) {
            status += "<senior collapse>";
            alarm = true;
        }
        if (!alarm) {
            status += "Okay";
        }
        
        simulator.getConsole().setText(status);    
        simulator.getConsolePanel().repaint();        
    }
    //confirm action
    public void confirm() {
        simulator.getConsole().setText("SoSafe Security Alarm System");
        simulator.getConsolePanel().repaint();
        simulator.setState(simulator.getStandbyState());   
    }
    //cancel action
    public void cancel() {
        simulator.getConsole().setText("SoSafe Security Alarm System");
        simulator.getConsolePanel().repaint();
        simulator.setState(simulator.getStandbyState());  
    }
    //handle input
    public void input(String input) {
        simulator.getConsole().setText("INVALID COMMAND");
        simulator.getConsolePanel().repaint();
        simulator.setState(simulator.getStandbyState());  
    }
}
