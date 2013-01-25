package com.example.tests;

import org.testng.annotations.Test;
// Lesson listerned till 15:47
public class TestContactCreation extends TestBase {
	@Test
	public void shouldCreateContactWithValidData(){
		Contact contact = new Contact().setFirstName("Vasja").setLastName("Pupkin");
		app.getContactHelper().createContact(contact);
		
		
		
	}

}
