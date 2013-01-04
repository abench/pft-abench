package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactCreationTests extends TestBase {

	@Test(dataProvider="randomValidContactGenerator")
	public void testCreateContact(ContactData contact) throws Exception {
		
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
		
		app.getContactHelper().createContact(contact);
		// store state after test
		SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
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