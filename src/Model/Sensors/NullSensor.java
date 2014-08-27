package Model.Sensors;


public class NullSensor extends Sensor {

	@Override
	public String getType() {
		return "No Sensor";
	}
        
        public String getStatus() {
            return "none";
        }        
}
