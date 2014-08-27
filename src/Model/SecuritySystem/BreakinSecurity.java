package Model.SecuritySystem;

import Model.Sensors.MotionSensor;
import Model.Sensors.Sensor;
import Model.Building.Room;

public class BreakinSecurity extends Security {

	public BreakinSecurity(String name, int id) {
		super(name, id);
	}
	
	public String getType() {
		return "BreakinSecurity";
	}
	
	protected void takeAlarmAction(Room room, Sensor sensor) {
                sensor.setStatus("break-in detected");
		super.takeAlarmAction(room, sensor);
	}
	
	protected Sensor getSensorInstance() {
		return new MotionSensor();
	}
}