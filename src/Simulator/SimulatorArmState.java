/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Simulator;

import Model.Sensors.Sensor;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author hinsenchan
 */

public class SimulatorArmState implements SimulatorState {
    private Simulator simulator;
    private String inputBuffer = "";
    private String state = "command";
    
    SimulatorArmState(Simulator simulator) {
        this.simulator = simulator;
    }
    
    public void runFunction() {
        simulator.getConsole().setText("Input (0=all,1=fire,2=breakin,3=senior): _");
        simulator.getConsolePanel().repaint();
        state = "input";
    }
    public void confirm() {
        int breakinSec = simulator.getSecuritySimModel().getBreakinSecurity().getSensorList().size();
        int fireSec = simulator.getSecuritySimModel().getFireSecurity().getSensorList().size();
        int seniorSec = simulator.getSecuritySimModel().getSeniorSecurity().getSensorList().size();
        
        if ((breakinSec + fireSec + seniorSec) > 0 && inputBuffer.equals("0")) {
            simulator.getConsole().setText("!!! ARMED ALL !!!");   
            simulator.getConsolePanel().getOnLight().setOpaque(true);
            simulator.getConsolePanel().getOffLight().setOpaque(false);
            armAllSensors();
        }
        else if (Integer.parseInt(inputBuffer) >= 1 && Integer.parseInt(inputBuffer) <= 3) {
            if ((fireSec > 0 && inputBuffer.equals("1")) || 
                    (breakinSec > 0 && inputBuffer.equals("2")) || 
                    (seniorSec > 0 && inputBuffer.equals("3"))) {
                simulator.getConsole().setText("!!! ARMED !!!");
                armSensor(Integer.parseInt(inputBuffer));
                simulator.getConsolePanel().getOnLight().setOpaque(true);
                simulator.getConsolePanel().getOffLight().setOpaque(false);  
            }
            else { simulator.getConsole().setText("INVALID SENSOR"); }
        }
        else {
            simulator.getConsole().setText("INVALID SENSOR");
        }
        inputBuffer = "";
        simulator.getConsolePanel().repaint();
        simulator.setState(simulator.getStandbyState());   
    }
    public void cancel() {
        if (inputBuffer.length() > 0) { 
            inputBuffer = removeLastChar(inputBuffer);            
            simulator.getConsole().setText("Input (0=all,1=fire,2=breakin,3=senior): " + inputBuffer);
            simulator.getConsolePanel().repaint();
        }
        else {        
            simulator.getConsole().setText("Cancelled");
            simulator.getConsolePanel().repaint();
        }
    }
    public void input(String input) {
        if (state.equals("input")) {
            inputBuffer += input;
            simulator.getConsole().setText("Input (0=all,1=fire,2=breakin,3=senior): " + inputBuffer);
            simulator.getConsolePanel().repaint();
        }
    }
    
    public void armAllSensors() {
        simulator.refreshSensorList();
        ArrayList<Sensor> sensorList = simulator.getSensorList();
        for (int i=0; i<sensorList.size(); i++) {
            Sensor sensor = sensorList.get(i);
            if (!sensor.getType().equals("No Sensor")) {
                sensor.setAlarmThreshold(10);
                sensor.setStatus("armed");
            }            
        }
        simulator.getSecuritySimModel().reloadTableDisplayData();
        simulator.getSecuritySimModel().fireTableDataChanged();
    }
    
    public void armSensor(int value) {
        String type = "";
        switch(value) {
            case 1: 
                type = "TemperatureSensor";
                break;            
            case 2: 
                type = "MotionSensor";
                break;
            case 3:
                type = "SeniorSensor";
                break;
        }
        
        simulator.refreshSensorList();
        ArrayList<Sensor> sensorList = simulator.getSensorList();
        for (int i=0; i<sensorList.size(); i++) {
            Sensor sensor = sensorList.get(i);
            if (sensor.getType().equals(type)) {
                sensor.setAlarmThreshold(10);
                sensor.setStatus("armed");
            }
        }
        simulator.getSecuritySimModel().reloadTableDisplayData();
        simulator.getSecuritySimModel().fireTableDataChanged();        
    }
    
    private static String removeLastChar(String str) {
        return str.substring(0,str.length()-1);
    }    
}
