/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Simulator;

/**
 *
 * @author hinsenchan
 */

//state interface for simulator
public interface SimulatorState {
    public void runFunction();
    public void confirm();
    public void cancel();
    public void input(String input);
}
