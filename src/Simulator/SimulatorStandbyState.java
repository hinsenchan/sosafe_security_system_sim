/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Simulator;

import javax.swing.JTextField;

/**
 *
 * @author hinsenchan
 */

public class SimulatorStandbyState implements SimulatorState {
    private Simulator simulator;
    
    SimulatorStandbyState(Simulator simulator) {
        this.simulator = simulator;
    }
    
    public void runFunction() {

    }
    public void confirm() {
        simulator.getConsole().setText("Select a command first...");
    }
    public void cancel() {
        simulator.getConsole().setText("Select a command first...");
    }
    public void input(String input) {
        simulator.getConsole().setText("Select a command first...");
    }
}
