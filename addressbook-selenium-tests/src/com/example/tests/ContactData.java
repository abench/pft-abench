package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	private String firstname;
	private String lastname;
	private String address;
	private String phoneHome;
	private String phoneMobile;
	private String phoneWork;
	private String email;
	private String email2;
	private String birthDay;
	private String birthMonth;
	private String birthYear;
	private String address2;
	private String home2;

	public ContactData() {
	}

	
	
//	@Override
//	public String toString() {
//		return "ContactData [lastname=" + lastname + "]";
//	}

	@Override
	public String toString() {
		return "ContactData [firstname=" + firstname + ", lastname=" + lastname
				+ ", address=" + address + ", phoneHome=" + phoneHome
				+ ", phoneMobile=" + phoneMobile + ", phoneWork=" + phoneWork
				+ ", email=" + email + ", email2=" + email2 + ", birthDay="
				+ birthDay + ", birthMonth=" + birthMonth + ", birthYear="
				+ birthYear + ", address2=" + address2 + ", home2=" + home2
				+ "]";
	}



	@Override
	public int hashCode() {
		//final int prime = 31;
		int result = 1;
		//result = prime * result
		//		+ ((lastname == null) ? 0 : lastname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		return this.lastname.compareTo(other.lastname);
	}

	
// Modified setters
	
	public ContactData withFirstname(String firstName) {
		this.firstname = firstName;
		return this;
	}

	public ContactData withLastname(String lastName) {
		this.lastname = lastName;
		return this;
	}

	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}

	public ContactData withPhoneHome(String phone) {
		this.phoneHome = phone;
		return this;
	}

	public ContactData withPhoneMobile(String phone) {
		this.phoneMobile = phone;
		return this;
	}

	public ContactData withPhoneWork(String phone) {
		this.phoneWork = phone;
		return this;
	}

	public ContactData withEmail(String email) {
		this.email = email;
		return this;
	}

	public ContactData withEmail2(String email) {		
		this.email2 = email;		
		return this;
	}

	public ContactData withBirthDay(String day) {
		this.birthDay = day;
		return this;
	}

	public ContactData withBirthMonth(String month) {		
		this.birthMonth = month;
		return this;
	}

	public ContactData withHome2(String home) {
		this.home2 = home;
		return this;
		
	}	
	
// Getters
	
	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneHome() {
		return phoneHome;
	}

	public String getPhoneMobile() {
		return phoneMobile;
	}

	public String getPhoneWork() {
		return phoneWork;
	}

	public String getEmail() {
		return email;
	}

	public String getEmail2() {
		return email2;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public String getBirthMonth() {
		return birthMonth;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public String getAddress2() {
		return address2;
	}

	public String getHome2() {
		return home2;
	}

}