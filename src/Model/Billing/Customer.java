package Model.Billing;

import java.io.Serializable;

public class Customer implements Serializable {
	private String name;
	private String phoneNumber;
	private String emailId;
        private String emergencyContact;
	private String serviceContractId;
	
	public Customer(String name, String phoneNumber, String emailId,
			String emergencyContact, String serviceContractId) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
                this.emergencyContact = emergencyContact;
		this.serviceContractId = serviceContractId;                
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}
        
        public String getEmergencyContact() {
                return emergencyContact;
        }

	public String getServiceContractId() {
		return serviceContractId;
	}
	
	public String toString() {
                String output = "";
		output += "##############################################" + "\n";
		output += "# Customer Details." + "\n";
		output += "##############################################" + "\n";
		output += "# Name : " + name + "\n";
		output += "# serviceContractId : " + serviceContractId + "\n";
		output += "# PhoneNumber : " + phoneNumber + "\n";
		output += "# emailId : " + emailId + "\n";
                output += "# emergency : " + emergencyContact + "\n";
		output += "##############################################";
                
                return output;
	}

}
