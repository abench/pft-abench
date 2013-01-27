package com.example.fw;

public class Contact {

	private String lastName;
	private String firstName;
	
	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	

	public Contact setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public Contact setLastName(String lastName) {
		
		this.lastName = lastName;
		return this;
	}

}
