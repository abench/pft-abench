package com.example.tests;

import static org.testng.AssertJUnit.assertEquals;
import static com.example.fw.ContactHelper.MODIFICATION;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.tests.TestBase;

public class ContactModificationTests extends TestBase {
	
	@Test(dataProvider="randomValidContactGenerator")
	public void modifySomeContact(ContactData contact){
		// open page
		app.navigateTo().mainPage();
		//store state before test
		List<ContactData> oldList = app.getContactHelper().getContacts();
		
		//execute test steps
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);

		
		
		app.getContactHelper().initContactModificationByIndex(index)
			.fillContactsForm(contact, MODIFICATION)
			.updateContactsForm()
			.openMainPage();
		
		//store state after test
		List<ContactData> newList = app.getContactHelper().getContacts();
		//Compare
		// by length
		assertEquals(oldList.size(),newList.size());
		// by content
		
		oldList.remove(index);
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
