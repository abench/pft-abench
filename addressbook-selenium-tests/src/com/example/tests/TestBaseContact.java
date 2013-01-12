package com.example.tests;

import static com.example.tests.ContactDataGenerator.generateRandomContacts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;


public class TestBaseContact extends TestBase {
	
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator(){
		return wrapContactListForDataProvider(generateRandomContacts(5)).iterator();
	}

	public static List<Object[]> wrapContactListForDataProvider(List<ContactData> contacts) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (ContactData contact : contacts) {
			list.add(new Object[]{contact});
		}
		return list;
	}



}
