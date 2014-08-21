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
		System.out.println("Reporring an alarm alert for security type" + getType());
		super.takeAlarmAction(room, sensor);
	}
	
	protected Sensor getSensorInstance() {
		return new MotionSensor();
	}
}