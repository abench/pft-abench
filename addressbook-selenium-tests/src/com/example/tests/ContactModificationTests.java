package com.example.tests;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactModificationTests extends TestBaseContact {
	
	@Test(dataProvider="randomValidContactGenerator")
	public void modifySomeContact(ContactData contact){
		//store state before test
		SortedListOf<ContactData> oldList = (SortedListOf<ContactData>) app.getHibernateHelper().listContacts();		
		//execute test steps		
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);
		app.getContactHelper().modifyContact(contact,index);		
		//store state after test
		SortedListOf<ContactData> newList = app.getModel().getContacts();
		//Compare
		//  length
		assertEquals(oldList.size(),newList.size());
		//  content
		compareContactsModelWithDatabase();		
		compareContactsModelWithUi();
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
