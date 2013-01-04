package com.example.tests;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactModificationTests extends TestBase {
	
	@Test(dataProvider="randomValidContactGenerator")
	public void modifySomeContact(ContactData contact){
		//store state before test
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
		
		//execute test steps
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);

		app.getContactHelper().modifyContact(contact,index);		
		
		//store state after test
		SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
		//Compare
		// by length
		assertEquals(oldList.size(),newList.size());
		// by content
		
		oldList.remove(index);
		oldList.add(contact);		
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
