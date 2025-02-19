package session_20;

public class Employee {

	private String firstname;
	private String lastname;
	

	private String gender;
	private int age;
	private double salary;
	
	//getter and setter methods
	
	public String getFirstName() {
		return firstname;
	}
	
	
	public void setFirstName(String  firstname) {
		//this.firstname -> means private string firstname (variable of class)
		this.firstname = firstname;
	}
	
	
	//-------------------------------
	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	

	
}
