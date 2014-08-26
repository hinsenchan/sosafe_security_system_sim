package Model.Building;

import java.io.Serializable;
import java.util.ArrayList;

public class Section implements Serializable {
	private  int sectionId;
	private ArrayList<Room> roomList;
	
	public Section(int id) {
		sectionId = id;
		roomList = new ArrayList<Room>();
	}
	
	public void addRoom(Room room) {
		roomList.add(room);
	}
        
        public void removeRoom(int roomId) {
                for (int i=0; i<roomList.size(); i++) {
                    if (roomList.get(i).getRoomId() == roomId) {
                        roomList.remove(i);
                        break;
                    }
                }
        }

	public int getSectionId() {
		return sectionId;
	}

	public ArrayList<Room> getRoomList() {
		return roomList;
	}
	
}
