package Model.SecuritySystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import Model.Sensors.Sensor;
import Model.Building.Room;
import Model.Building.Section;

///security will observe room
public class Security implements Observer {
	protected String name;
	protected int id;
	protected String callingNum;
	protected boolean status;
	protected String schedule;
	protected List<Sensor> sensorList;
	
	public Security (String name, int id) {
		this.name = name;
		this.id = id;
		this.callingNum = "911";
		status = true;
		schedule = "All days";
		sensorList = new ArrayList<Sensor>();
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		Room room = (Room)arg0;
		Sensor sensor = (Sensor) arg1;
		takeAlarmAction(room, sensor);
	}

	protected void takeAlarmAction(Room room, Sensor sensor) {
		System.out.println("Room with id " + room.getRoomId() +
				" raised alarm of type" + sensor.getType() +
				". And the sesor data value was " + sensor.getData());
		System.out.println("Calling ..." + getCallingNum());
	}

	public String getCallingNum() {
		return callingNum;
	}

	public void setCallingNum(String callingNum) {
		this.callingNum = callingNum;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public String getType() {
		return null;
	}
	
	protected Sensor getSensorInstance() {
		return null;
	}
	
	public void addSecurityTo(Section section) {
		for(Room room: section.getRoomList()) {
			addSecurityTo(room);
		}
	}
	
	public void addSecurityTo(Room room) {
		Sensor sensor = getSensorInstance();
		sensorList.add(sensor);
		room.addSensor(sensor);
		room.addObserver(this);
	}
	
	public int getBillabeUnits() {
		if (!status) {
			return 0;
		}
		return sensorList.size();
	}
	
}
