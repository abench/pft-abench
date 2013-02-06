package com.example.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;
//import com.google.common.collect.ForwardingCollection;




public class ContactCreationTests extends TestBaseContact {

	@Test(dataProvider="contactsFromCsvFile")
	public void testCreateContact(ContactData contact) throws Exception {
		SortedListOf<ContactData> oldList = (SortedListOf<ContactData>) app.getHibernateHelper().listContacts();				
		app.getContactHelper().createContact(contact);
		// store state after test
		SortedListOf<ContactData> newList = app.getModel().getContacts();
		//Compare
		// list length
		assertEquals(oldList.size()+1, newList.size());
		// content		
		compareContactsModelWithDatabase();		
		compareContactsModelWithUi();		
	}


} 