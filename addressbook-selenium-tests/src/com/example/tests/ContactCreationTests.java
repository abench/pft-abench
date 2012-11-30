package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

	@Test
	public void testCreateContact() throws Exception {
		openContactPage();
		gotoContactsPage();
		
		ContactData contact = new ContactData(); 
		
			contact.firstname = "vasja" + getRandomString();
			contact.lastname = "pupkin" + getRandomString();
			contact.address = "pupkin town" + getRandomString();
			contact.phoneHome =  getRandomString();
			contact.phoneMobile = getRandomString();
			contact.phoneWork =   getRandomString();
			contact.email = "pupkin" + getRandomString()+ "@mail.ru";
			contact.email2 = "vpupkin" + getRandomString()+ "@mail.ru";
			contact.birthDay = "1";
			contact.birthMonth =  "January";
			contact.address2 = "pupkin town No" + getRandomString() ;
			contact.home2 = "pupkin home No"  + getRandomString() ;
		
		fillContactsForm(contact);
		submitContactsForm();
		returnMainPage();
	}


} 