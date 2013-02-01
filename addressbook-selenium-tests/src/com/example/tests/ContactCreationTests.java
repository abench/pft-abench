package com.example.tests;

import static org.testng.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;
//import com.google.common.collect.ForwardingCollection;




public class ContactCreationTests extends TestBaseContact {

	@Test(dataProvider="contactsFromCsvFile")
	public void testCreateContact(ContactData contact) throws Exception {
		
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
		
		app.getContactHelper().createContact(contact);
		// store state after test
		SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
		//Compare states
		// by list length
		assertEquals(oldList.size()+1, newList.size());
		// by content
		assertThat(newList, equalTo(oldList.withAdded(contact)));
		
	}


} 