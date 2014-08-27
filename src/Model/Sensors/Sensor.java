package Model.Sensors;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Observable;

public class Sensor extends Observable implements Serializable {
	protected int data;
	private int alarmThreshold;
        private String status;
	
	public int getAlarmThreshold() {
		return alarmThreshold;
	}

	public void setAlarmThreshold(int alarmThreshold) {
		this.alarmThreshold = alarmThreshold;
	}

	public Sensor() {
		data = 0 ;
		alarmThreshold = 999;
                status = "disarmed";
	}
        
        public String getStatus() {
            return status;
        }
        
        public void setStatus(String status) {
            this.status = status;
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
