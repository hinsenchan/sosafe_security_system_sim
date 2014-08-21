package Model.Billing;

import Model.SecuritySystem.Security;
import Model.Building.CommercialBuilding;

public class MotionSecurityBills extends Bills {
    public MotionSecurityBills(CommercialBuilding commercialBuilding,
			Security security, Customer customer) {
		super(commercialBuilding, security, customer);
		setUnitRate(20);
	}
}
