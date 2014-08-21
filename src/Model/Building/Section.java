package Model.Building;

import java.util.ArrayList;

public class Section {
	private  int sectionId;
	private ArrayList<Room> roomList;
	
	public Section(int id) {
		sectionId = id;
		roomList = new ArrayList<Room>();
	}
	
	public void addRoom(Room room) {
		roomList.add(room);
	}

	public int getSectionId() {
		return sectionId;
	}

	public ArrayList<Room> getRoomList() {
		return roomList;
	}
	
}
