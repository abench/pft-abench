package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	public String firstname;
	public String lastname;
	public String address;
	public String phoneHome;
	public String phoneMobile;
	public String phoneWork;
	public String email;
	public String email2;
	public String birthDay;
	public String birthMonth;
	public String birthYear;
	public String address2;
	public String home2;

	public ContactData() {
	}

	@Override
	public String toString() {
		return "ContactData [lastname=" + lastname + "]";
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
}