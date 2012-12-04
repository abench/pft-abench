package com.example.tests;

import org.testng.annotations.Test;

import com.example.tests.TestBase;

public class ContactModificationTests extends TestBase {
	
	@Test
	public void modifySomeContact(){
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactModificationByIndex(1);
		ContactData contact=new ContactData();
		contact.firstname = "vasjutka";
		contact.birthDay = "5";
		contact.birthMonth ="February";
		app.getContactHelper().fillContactsForm(contact);
		app.getContactHelper().updateContactsForm();
		
	}
	@Test
	public void modifyContactEmptyBirthData(){
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactModificationByIndex(1);
		ContactData contact=new ContactData();
		contact.firstname = "petya";
		app.getContactHelper().fillContactsForm(contact);
		app.getContactHelper().updateContactsForm();
		
	}

}
