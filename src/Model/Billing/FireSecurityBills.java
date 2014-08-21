package Model.Billing;

import Model.SecuritySystem.Security;
import Model.Building.CommercialBuilding;

public class FireSecurityBills extends Bills {

	public FireSecurityBills(CommercialBuilding commercialBuilding,
			Security security, Customer customer) {
		super(commercialBuilding, security, customer);
		setUnitRate(22);
	}

}
