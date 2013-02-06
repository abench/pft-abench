package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemovalTests extends TestBaseContact {
	
	@Test
	public void deleteSomeContact(){
		app.navigateTo().mainPage();
		// store state before test
		SortedListOf<ContactData> oldList = (SortedListOf<ContactData>) app.getHibernateHelper().listContacts();
		// execute test steps		
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);		
		app.getContactHelper().deleteContact(index);		
		// store state after test
		SortedListOf<ContactData> newList = app.getModel().getContacts();
		// Compare states
		//  by list length
		assertEquals(oldList.size(),newList.size()+1);
		//  by content
		//assertThat(newList, equalTo(oldList.without(index)));
		compareContactsModelWithDatabase();		
		compareContactsModelWithUi();
	}

}
