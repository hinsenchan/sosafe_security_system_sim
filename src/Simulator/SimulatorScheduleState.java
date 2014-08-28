/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Simulator;

import Model.Sensors.Sensor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

/**
 *
 * @author hinsenchan
 */

public class SimulatorScheduleState implements SimulatorState {
    private Simulator simulator;
    private String inputBuffer = "";
    private String state = "command";
    private int time = 0;
    private Timer timer;
    private int sensor = -1;
    
    SimulatorScheduleState(Simulator simulator) {
        this.simulator = simulator;
    }
    
    public void runFunction() {
        simulator.getConsole().setText("Enter delay in seconds: _");
        simulator.getConsolePanel().repaint();
        state = "timeInput";
    }
    public void confirm() {        
        if (state.equals("timeInput")) {
            if (inputBuffer.length() > 0) {
                if (Integer.parseInt(inputBuffer) > 0) {
                    simulator.getConsole().setText("Input (0=all,1=fire,2=breakin,3=senior): _");
                    simulator.getConsolePanel().repaint();
                    time = Integer.parseInt(inputBuffer) * 1000;
                    inputBuffer = "";
                    state = "input";
                }
            }
            else {               
                simulator.getConsole().setText("INVALID TIME OR COMMAND");
                simulator.getConsolePanel().repaint();         
                state = "command";
                inputBuffer = "";
                time=0;
                simulator.setState(simulator.getStandbyState());
            }
        }
        else if (state.equals("input")) {        
            if (inputBuffer.length() > 0) {
                sensor = Integer.parseInt(inputBuffer);
                if (sensor >= 0 && sensor <= 3) {
                    int breakinSec = simulator.getSecuritySimModel().getBreakinSecurity().getSensorList().size();
                    int fireSec = simulator.getSecuritySimModel().getFireSecurity().getSensorList().size();
                    int seniorSec = simulator.getSecuritySimModel().getSeniorSecurity().getSensorList().size();
                    
                    if (((breakinSec + fireSec + seniorSec) > 0 && inputBuffer.equals("0")) || 
                            (fireSec > 0 && inputBuffer.equals("1")) || 
                            (breakinSec > 0 && inputBuffer.equals("2")) || 
                            (seniorSec > 0 && inputBuffer.equals("3"))) {
                        simulator.getConsole().setText("HOLDING FOR " + (time/1000) + " SECONDS...");  
                        simulator.getConsolePanel().repaint();
                        sensor = Integer.parseInt(inputBuffer);

                        ActionListener taskPerformer = new ActionListener() {
                            public void actionPerformed(ActionEvent evt) {
                                simulator.getConsole().setText("!!! ARMED !!!");
                                simulator.getConsolePanel().getOnLight().setOpaque(true);
                                simulator.getConsolePanel().getOffLight().setOpaque(false);  

                                if (sensor == 0) { armAllSensors(); }
                                else { armSensor(sensor); }
                                time = 0;
                                sensor = -1;
                                timer.stop();                            
                            }
                        };           
                        timer = new Timer(time,taskPerformer);   
                        timer.start();
                    }
                    else {
                        simulator.getConsole().setText("INVALID SENSOR");  
                        simulator.getConsolePanel().repaint(); 
                        time = 0;
                        inputBuffer = "";
                        simulator.setState(simulator.getStandbyState());  
                        state = "command";                        
                    }
                }
                else {
                    simulator.getConsole().setText("INVALID SENSOR");  
                    simulator.getConsolePanel().repaint(); 
                    time = 0;
                    inputBuffer = "";
                    simulator.setState(simulator.getStandbyState());  
                    state = "command";
                }
            }
            else {
                simulator.getConsole().setText("INVALID COMMAND");
                simulator.getConsolePanel().repaint();         
                state = "command";
                inputBuffer = "";
                time=0;
                simulator.setState(simulator.getStandbyState());                   
            }
        }
     
    }
    public void cancel() {                
        if (inputBuffer.length() > 0) { 
            inputBuffer = removeLastChar(inputBuffer);            
            if (state.equals("input")) {
                simulator.getConsole().setText("Input (0=all,1=fire,2=breakin,3=senior): " + inputBuffer);
            }
            else if (state.equals("timeInput")){
                simulator.getConsole().setText("Enter delay in seconds: " + inputBuffer);
            }
            simulator.getConsolePanel().repaint();
        }
        else {        
            simulator.getConsole().setText("Cancelled");
            simulator.getConsolePanel().repaint();
            state = "command";
        }
    }
    public void input(String input) {
        if (state.equals("input")) {
            inputBuffer += input;
            simulator.getConsole().setText("Input (0=all,1=fire,2=breakin,3=senior): " + inputBuffer);
            simulator.getConsolePanel().repaint();
        }
        else if (state.equals("timeInput")) {
            inputBuffer += input;
            simulator.getConsole().setText("Enter delay in seconds: " + inputBuffer);
            simulator.getConsolePanel().repaint();            
        }
        else {
            simulator.getConsole().setText("INVALID COMMAND");
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
