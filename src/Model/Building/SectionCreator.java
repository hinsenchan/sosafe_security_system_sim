package Model.Building;

public class SectionCreator {
	private static int nextSectionId= 0;
	protected RoomCreator rc;

	public SectionCreator(RoomCreator rc) {
		this.rc = rc;
	}
	
	protected int getNextId() {
		return nextSectionId++;
	}
	
	public Section createSection(int rooms) {
		Section section = new Section(getNextId());
		for(int i = 0; i < rooms; i++) {
			section.addRoom(rc.createRoom());
		}
		return section;
	}
}
