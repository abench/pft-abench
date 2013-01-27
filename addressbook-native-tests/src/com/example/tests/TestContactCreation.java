package com.example.tests;

import org.testng.annotations.Test;

import com.example.fw.Contact;
// Lesson listerned till 15:47
public class TestContactCreation extends TestBase {
	@Test
	public void shouldCreateContactWithValidData(){
		Contact contact = new Contact().setFirstName("Vasja").setLastName("Pupkin");
		app.getContactHelper().createContact(contact);
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
