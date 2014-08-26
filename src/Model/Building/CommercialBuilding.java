package Model.Building;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CommercialBuilding implements Serializable {
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
        
        public void removeSection(int sectionId) {
                for (int i=0; i<sectionList.size(); i++) {
                    if (sectionList.get(i).getSectionId() == sectionId) {
                        sectionList.remove(i);
                        break;
                    }
                }            
        }

	public String getBuildingId() {
		return buildingId;
	}

	public List<Section> getSectionList() {
		return sectionList;
	}

}
