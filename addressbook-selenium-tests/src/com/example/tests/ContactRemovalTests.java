package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemovalTests extends TestBase {
	
	@Test
	public void deleteSomeContact(){
		app.navigateTo().mainPage();
		// store state before test
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
		// execute test steps
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);

		
		app.getContactHelper().deleteContact(index);
			
		
		// store state after test
		SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
		// Compare states
		//  by list length
		assertEquals(oldList.size(),newList.size()+1);
		//  by content
		oldList.remove(index);
		Collections.sort(oldList);
		Collections.sort(newList);		
		assertEquals(oldList, newList);
		
	}

}
