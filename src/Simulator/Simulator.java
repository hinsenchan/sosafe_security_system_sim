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

//simulator that holds logic for control panel
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
    private static Simulator instance;
    
    //return single instance
    public synchronized static Simulator getInstance() {
        if (instance == null) {
            instance = new Simulator();
        }
        return instance;
    }
    
    private Simulator() {        
        standbyState = new SimulatorStandbyState(this);
        armState = new SimulatorArmState(this);
        disarmState = new SimulatorDisarmState(this);
        statusState = new SimulatorStatusState(this);
        scheduleState = new SimulatorScheduleState(this);
        emergencyState = new SimulatorEmergencyState(this);
        testState = new SimulatorTestState(this);
        
        setState(standbyState);
    }
    
    //set panel used for this simulator
    public void setPanel(SimControlPanel panel) {
        this.consolePanel = panel;   
    }
    
    //set console display on control panel
    public void setConsole(JTextField console) {
        this.console = console;
    }
    
    //refresh list of sensors
    public void refreshSensorList() {
        sensorList = getSecuritySimModel().getSensorList();          
    }
    
    //set state of simulator
    public void setState(SimulatorState state) {
        currentState = state;        
    }
    
    //handle arm button
    public void pushArm() {
        setState(armState);
        currentState.runFunction();
    }
    
    //handle disarm button
    public void pushDisarm() {
        setState(disarmState);
        currentState.runFunction();
    }
    
    //handle status button
    public void pushStatus() {    
        setState(statusState);
        currentState.runFunction();
    }
    
    //handle schedule button
    public void pushSchedule() {
        setState(scheduleState);
        currentState.runFunction();
    }
    
    //handle emergency button
    public void pushEmergency() {
       setState(emergencyState);
       currentState.runFunction(); 
    }
    
    //handle test button
    public void pushTest() {
        setState(testState);        
        currentState.runFunction();
    }
    
    //handle one button
    public void pushOne() {
        currentState.input("1");
    }
    
    //handle two button
    public void pushTwo() {
        currentState.input("2");
    }
    
    //handle three button
    public void pushThree() {
        currentState.input("3");
    }
    
    //handle four button
    public void pushFour() {
        currentState.input("4");
    }
    
    //handle five button
    public void pushFive() {
        currentState.input("5");
    }    
     
    //handle six button
    public void pushSix() {
        currentState.input("6");
    }
    
    //handle seven button
    public void pushSeven() {
        currentState.input("7");
    }
    
    //handle eight button
    public void pushEight() {
        currentState.input("8");
    }
    
    //handle nine button
    public void pushNine() {
        currentState.input("9");
    }
    
    //handle zero button
    public void pushZero() {
        currentState.input("0");
    }
    
    //handle star button
    public void pushStar() {
        currentState.cancel();
    }
    
    //handle pound button
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
    
    //get access to control panel display console
    public JTextField getConsole() {
        return console;
    }
    
    //get console panel
    public SimControlPanel getConsolePanel() {
        return consolePanel;
    }
    
    //get list of sensors
    public ArrayList<Sensor> getSensorList() {
        return sensorList;
    }
    
    //get application model
    public SecuritySimModel getSecuritySimModel() {
        return securitySimModel;
    }

    /**
     * @param securitySimModel the securitySimModel to set
     */
    public void setSecuritySimModel(SecuritySimModel securitySimModel) {
        this.securitySimModel = securitySimModel;
    }
}