package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	
	@Test
	public void deleteSomeContact(){
		app.getNavigationHelper().openMainPage();
		// store state before test
		List<ContactData> oldList = app.getContactHelper().getContacts();
		// execute test steps
		app.getContactHelper().deleteContact(0);
		app.getNavigationHelper().returnMainPage();
		// store state after test
		List<ContactData> newList = app.getContactHelper().getContacts();
		// Compare states
		//  by list length
		assertEquals(oldList.size(),newList.size()+1);
		//  by content
		oldList.remove(0);
		Collections.sort(oldList);
		Collections.sort(newList);		
		assertEquals(oldList, newList);

		
	}

}
