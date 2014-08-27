/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Simulator;

import Model.SecuritySimModel;
import Model.Sensors.Sensor;
import View.SimControlPanel;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author hinsenchan
 */

public class Simulator {
    private SimulatorState currentState;
    private SimulatorState standbyState;
    private SimulatorState armState;
    private SimulatorState disarmState;
    private SimulatorState statusState;
    private SimulatorState scheduleState;
    private SimulatorState emergencyState;
    private SimulatorState testState;
    private SimControlPanel consolePanel;
    private JTextField console;
    private ArrayList<Sensor> sensorList;
    private SecuritySimModel securitySimModel;
    
    public Simulator(SecuritySimModel securitySimModel) {     
        this.securitySimModel = securitySimModel;
        
        standbyState = new SimulatorStandbyState(this);
        armState = new SimulatorArmState(this);
        disarmState = new SimulatorDisarmState(this);
        statusState = new SimulatorStatusState(this);
        scheduleState = new SimulatorScheduleState(this);
        emergencyState = new SimulatorEmergencyState(this);
        testState = new SimulatorTestState(this);
        
        setState(standbyState);
    }
    
    public void setPanel(SimControlPanel panel) {
        this.consolePanel = panel;   
    }
    
    public void setConsole(JTextField console) {
        this.console = console;
    }
    
    public void refreshSensorList() {
        sensorList = securitySimModel.getSensorList();          
    }
    
    public void setState(SimulatorState state) {
        currentState = state;        
    }
    
    public void pushArm() {
        setState(armState);
        currentState.runFunction();
    }
    
    public void pushDisarm() {
        setState(disarmState);
        currentState.runFunction();
    }
    
    public void pushStatus() {    
        setState(statusState);
        currentState.runFunction();
    }
    
    public void pushSchedule() {
        setState(scheduleState);
        currentState.runFunction();
    }
    
    public void pushEmergency() {
       setState(emergencyState);
       currentState.runFunction(); 
    }
    
    public void pushTest() {
        setState(testState);        
        currentState.runFunction();
    }
    
    public void pushOne() {
        currentState.input("1");
    }
    
    public void pushTwo() {
        currentState.input("2");
    }
    
    public void pushThree() {
        currentState.input("3");
    }
    
    public void pushFour() {
        currentState.input("4");
    }
    
    public void pushFive() {
        currentState.input("5");
    }    
     
    public void pushSix() {
        currentState.input("6");
    }
    
    public void pushSeven() {
        currentState.input("7");
    }
    
    public void pushEight() {
        currentState.input("8");
    }
    
    public void pushNine() {
        currentState.input("9");
    }
    
    public void pushZero() {
        currentState.input("0");
    }
    
    public void pushStar() {
        currentState.cancel();
    }
    
    public void pushPound() {
        currentState.confirm();
    }    

    /**
     * @return the currentState
     */
    public SimulatorState getCurrentState() {
        return currentState;
    }

    /**
     * @return the standyState
     */
    public SimulatorState getStandbyState() {
        return standbyState;
    }

    /**
     * @return the armState
     */
    public SimulatorState getArmState() {
        return armState;
    }

    /**
     * @return the disarmState
     */
    public SimulatorState getDisarmState() {
        return disarmState;
    }

    /**
     * @return the statusState
     */
    public SimulatorState getStatusState() {
        return statusState;
    }

    /**
     * @return the scheduleState
     */
    public SimulatorState getScheduleState() {
        return scheduleState;
    }

    /**
     * @return the emergencyState
     */
    public SimulatorState getEmergencyState() {
        return emergencyState;
    }

    /**
     * @return the testState
     */
    public SimulatorState getTestState() {
        return testState;
    }
    
    public JTextField getConsole() {
        return console;
    }
    
    public SimControlPanel getConsolePanel() {
        return consolePanel;
    }
    
    public ArrayList<Sensor> getSensorList() {
        return sensorList;
    }
    
    public SecuritySimModel getSecuritySimModel() {
        return securitySimModel;
    }
}