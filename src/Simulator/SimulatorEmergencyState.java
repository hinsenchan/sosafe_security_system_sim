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

public class SimulatorEmergencyState implements SimulatorState {
    private Simulator simulator;
    
    SimulatorEmergencyState(Simulator simulator) {
        this.simulator = simulator;
    }
    
    public void runFunction() {                
        simulator.getConsole().setText("Confirm emergency (*=NO,#=YES):");    
        simulator.getConsolePanel().repaint();        
    }
    public void confirm() {
        simulator.getConsole().setText("Dialing " + 
                simulator.getSecuritySimModel().getBreakinSecurity().getCallingNum() + " ...");
        simulator.getConsolePanel().repaint();
        simulator.setState(simulator.getStandbyState());   
    }
    public void cancel() {
        simulator.getConsole().setText("Cancelled");
        simulator.getConsolePanel().repaint();
        simulator.setState(simulator.getStandbyState());  
    }
    public void input(String input) {
        simulator.getConsole().setText("INVALID COMMAND");
        simulator.getConsolePanel().repaint();
        simulator.setState(simulator.getStandbyState());  
    }
}
