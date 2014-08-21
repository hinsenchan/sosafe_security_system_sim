package Model.Building;

public class RoomCreator {
	private static int nextRoomId = 0;
	
	private int getNextId() {
		return nextRoomId++;
	}
	
	public Room createRoom() {
		return new Room(getNextId());
	}

}
