package Model.SecuritySystem;

import Model.Sensors.SeniorSensor;
import Model.Sensors.Sensor;
import Model.Building.Room;

public class SeniorSecurity extends Security {

	public SeniorSecurity(String name, int id) {
		super(name, id);
	}
	
	public String getType() {
		return "SeniorSecurity";
	}
	
	protected void takeAlarmAction(Room room, Sensor sensor) {
		System.out.println("Reporring an alarm alert for security type" + getType());
		super.takeAlarmAction(room, sensor);
	}
	
	protected Sensor getSensorInstance() {
		return new SeniorSensor();
	}

}
