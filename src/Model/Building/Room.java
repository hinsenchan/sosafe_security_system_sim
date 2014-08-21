package Model.Building;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import Model.Sensors.Sensor;

public class Room extends Observable implements Observer  {
	private int roomId;
	private ArrayList<Sensor> sensorList;
	
	public Room(int roomId) {
		this.roomId = roomId;
		sensorList = new ArrayList<Sensor>();
	}

	public int getRoomId() {
		return roomId;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		Sensor sensor = (Sensor) o;
		setChanged();
		notifyObservers(sensor);
	}
	
	public void addSensor(Sensor sensor) {
		sensor.addObserver(this);
		sensorList.add(sensor);
	}
	
	public void removeSensor(Sensor sensor) {
		sensor.deleteObserver(this);
		sensorList.remove(sensor);
	}

	public ArrayList<Sensor> getSensorList() {
		return sensorList;
	}
}
