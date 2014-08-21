package Model.SecuritySystem;

import Model.Sensors.Sensor;
import Model.Sensors.TemperatureSensor;
import Model.Building.Room;

public class FireSecurity extends Security {

	public FireSecurity(String name, int id) {
		super(name, id);
	}
	
	public String getType() {
		return "FireSecurity";
	}
	
	protected void takeAlarmAction(Room room, Sensor sensor) {
		System.out.println("Reporring an alarm alert for security type" + getType());
		super.takeAlarmAction(room, sensor);
	}
	
	protected Sensor getSensorInstance() {
		return new TemperatureSensor();
	}
}
