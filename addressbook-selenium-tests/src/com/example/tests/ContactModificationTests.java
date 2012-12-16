package com.example.tests;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import com.example.tests.TestBase;

public class ContactModificationTests extends TestBase {
	
	@Test
	public void modifySomeContact(){
		// open page
		app.getNavigationHelper().openMainPage();
		//store state before test
		List<ContactData> oldList = app.getContactHelper().getContacts();
		//execute test steps
		app.getContactHelper().initContactModificationByIndex(0);
		ContactData contact=new ContactData();
		contact.firstname = "vasjutka";
		contact.lastname = "pupchenko";
		contact.birthDay = "5";
		contact.birthMonth ="February";
		app.getContactHelper().fillContactsForm(contact);
		app.getContactHelper().updateContactsForm();
		app.getNavigationHelper().openMainPage();
		//store state after test
		List<ContactData> newList = app.getContactHelper().getContacts();
		//Compare
		// by length
		assertEquals(oldList.size(),newList.size());
		// by content
		
		oldList.remove(0);
		oldList.add(contact);
		Collections.sort(oldList);
		Collections.sort(newList);
		assertEquals(oldList, newList);		

		
	}
//	@Test
//	public void modifyContactEmptyBirthData(){
//		app.getNavigationHelper().openMainPage();
//		app.getContactHelper().initContactModificationByIndex(1);
//		ContactData contact=new ContactData();
//		contact.firstname = "petya";
//		app.getContactHelper().fillContactsForm(contact);
//		app.getContactHelper().updateContactsForm();
//		
//	}

}
