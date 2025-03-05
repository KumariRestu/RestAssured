package session_23;

import java.util.List;

import session_22.EmployeeNestedPojoClass;

public class NestedJSONPojoClass {

	private String companyName;
	private String street;
	private String city;
	private String state;
	private String pincode;
	private List<String > bankAccount;
	private List <EmployeeNestedPojoClass> employeeList;
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public List<String> getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(List<String> bankAccount) {
		this.bankAccount = bankAccount;
	}

	public List<EmployeeNestedPojoClass> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<EmployeeNestedPojoClass> employeeList) {
		this.employeeList = employeeList;
	}


	
}
