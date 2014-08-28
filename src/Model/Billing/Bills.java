package Model.Billing;

import Model.SecuritySystem.Security;
import Model.Building.CommercialBuilding;

public class Bills {
	CommercialBuilding commercialBuilding;
	Security security;
	Customer customer;
	int unitRate;

	public Bills(CommercialBuilding commercialBuilding, Security security,
			Customer customer) {
		this.commercialBuilding = commercialBuilding;
		this.security = security;
		this.customer = customer;
	}
	
	public String toString() {
                String output = "";
                output += customer.toString();
		output += "\nEmergency number : " + security.getCallingNum();
		output += "\nEffective Dates  : " + security.getSchedule();
		output += "\nTotal amount  : " + (security.getBillabeUnits() * getUnitRate());
                output += "\n\n";
                return output;
	}

	public int getUnitRate() {
		return unitRate;
	}

	public void setUnitRate(int unitRate) {
		this.unitRate = unitRate;
	}
}
