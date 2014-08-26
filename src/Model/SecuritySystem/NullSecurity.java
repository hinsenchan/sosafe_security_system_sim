package Model.SecuritySystem;

import Model.Sensors.NullSensor;
import Model.Sensors.Sensor;
import Model.Building.Room;

public class NullSecurity extends Security {

	public NullSecurity(String name, int id) {
		super(name, id);
	}
	
	public String getType() {
		return "NullSecurity";
	}
	
	protected void takeAlarmAction(Room room, Sensor sensor) {
		System.out.println("No sensor detected");
	}
	
	protected Sensor getSensorInstance() {
		return new NullSensor();
	}
}