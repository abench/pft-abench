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
	
	
//	public ContactData(String firstname, String lastname, String address,
//			String phoneHome, String phoneMobile, String phoneWork,
//			String email, String email2, String birthDay, String birthMonth,
//			String birthYear, String address2, String home2) {
//		this.firstname = firstname;
//		this.lastname = lastname;
//		this.address = address;
//		this.phoneHome = phoneHome;
//		this.phoneMobile = phoneMobile;
//		this.phoneWork = phoneWork;
//		this.email = email;
//		this.email2 = email2;
//		this.birthDay = birthDay;
//		this.birthMonth = birthMonth;
//		this.birthYear = birthYear;
//		this.address2 = address2;
//		this.home2 = home2;
//	}
}