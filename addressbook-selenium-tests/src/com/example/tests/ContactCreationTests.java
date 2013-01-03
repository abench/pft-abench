package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

	@Test(dataProvider="randomValidContactGenerator")
	public void testCreateContact(ContactData contact) throws Exception {
		
		List<ContactData> oldList = app.getContactHelper().getContacts();
		
		app.getContactHelper().createContact(contact);
		// store state after test
		List<ContactData> newList = app.getContactHelper().getContacts();
		//Compare states
		// by list length
		assertEquals(oldList.size()+1,newList.size());
		// by content
		oldList.add(contact);
		Collections.sort(oldList);
		Collections.sort(newList);		
		assertEquals(oldList, newList);

	}


} 