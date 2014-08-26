package Model.Sensors;

import java.io.Serializable;
import java.util.Observable;

public class Sensor extends Observable implements Serializable {
	protected int data;
	private int alarmThreshold;
	
	public int getAlarmThreshold() {
		return alarmThreshold;
	}

	public void setAlarmThreshold(int alarmThreshold) {
		this.alarmThreshold = alarmThreshold;
	}

	public Sensor() {
		data = 0 ;
		alarmThreshold = 5;
	}

	public int getData(){
		return data;
	}

	public String getType() {
		return null;
	}

	public void setData(int x) {
		data = x;
		//goes above tolerance limit, should inform the observer
		if(data > alarmThreshold) {
			setChanged();
			notifyObservers(new Integer(data));
		}
	}
}
