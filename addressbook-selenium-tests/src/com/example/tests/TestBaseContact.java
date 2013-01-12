package com.example.tests;

import static com.example.tests.ContactDataGenerator.generateRandomContacts;
import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;


public class TestBaseContact extends TestBase {
	
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator(){
		return wrapContactListForDataProvider(generateRandomContacts(5)).iterator();
	}

	@DataProvider
	public Iterator<Object[]> contactsFromCsvFile() throws IOException{
		return wrapContactListForDataProvider(loadContactsFromCsvFile(new File("contacts.txt"))).iterator();
	}
	
	@DataProvider
	public Iterator<Object[]> contactsFromXmlFile() throws IOException{
		return wrapContactListForDataProvider(loadContactsFromXmlFile(new File("contacts.txt"))).iterator();
	}

	
	public static List<Object[]> wrapContactListForDataProvider(List<ContactData> contacts) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (ContactData contact : contacts) {
			list.add(new Object[]{contact});
		}
		return list;
	}



}
