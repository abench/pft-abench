package com.example.tests;

import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

	@Test
	public void testCreateContact() throws Exception {
		app.getNavigationHelper().openMainPage();
		List<ContactData> oldList = app.getContactHelper().getContacts();
		
		app.getContactHelper().openContactPage();
		app.getContactHelper().gotoContactsPage();
		
		ContactData contact = new ContactData(); 
		String rndStr = app.getContactHelper().getRandomString();
			contact.firstname = "vasja" + rndStr;
			contact.lastname = "pupkin" + rndStr;
			contact.address = "pupkin town" + rndStr;
			contact.phoneHome =  rndStr;
			contact.phoneMobile = rndStr;
			contact.phoneWork =   rndStr;
			contact.email = "pupkin" + rndStr+ "@mail.ru";
			contact.email2 = "vpupkin" + rndStr+ "@mail.ru";
			contact.birthDay = "1";
			contact.birthMonth =  "January";
			contact.address2 = "pupkin town No" + rndStr ;
			contact.home2 = "pupkin home No"  + rndStr ;
		
		
		app.getContactHelper().fillContactsForm(contact);
		app.getContactHelper().submitContactsForm();
		app.getNavigationHelper().returnMainPage();
	}


} 