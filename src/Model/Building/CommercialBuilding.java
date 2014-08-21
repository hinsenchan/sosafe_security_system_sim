package Model.Building;

import java.util.ArrayList;
import java.util.List;

public class CommercialBuilding {
	private String buildingId;
	private List<Section> sectionList;
	private String address;

	public CommercialBuilding(String id) {
		buildingId = id;
		sectionList = new ArrayList<Section>();
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public void addSection(Section sc) {
		sectionList.add(sc);
	}

	public String getBuildingId() {
		return buildingId;
	}

	public List<Section> getSectionList() {
		return sectionList;
	}

}
