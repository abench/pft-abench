package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.fw.Contact;

public class TestContactCreation extends TestBase {
	@Test
	public void shouldCreateContactWithValidData(){
		Contact contact = new Contact().setFirstName("Vasja").setLastName("Pupkin");
		app.getContactHelper().createContact(contact);
		Contact createdContact = app.getContactHelper().getFirstContact();
		Assert.assertEquals(contact, createdContact);		
	}

}
