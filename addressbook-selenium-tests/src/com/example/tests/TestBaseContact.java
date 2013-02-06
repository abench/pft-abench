package com.example.tests;

import static com.example.tests.ContactDataGenerator.generateRandomContacts;
import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

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

	
	public void compareContactsModelWithUi() {
		if (wantToCheck()){
			
			if ("yes".equals(app.getProperty("check.ui"))){
				assertThat(app.getModel().getGroups(), equalTo(app.getGroupHelper().getUiGroups()));	
			}	
		}
	}

	public void compareContactsModelWithDatabase() {
		if (wantToCheck()){
			if ("yes".equals(app.getProperty("check.db"))){
				assertThat(app.getModel().getContacts(), equalTo(app.getHibernateHelper().listContacts()));		
			}
		}
	}

	public static List<Object[]> wrapContactListForDataProvider(List<ContactData> contacts) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (ContactData contact : contacts) {
			list.add(new Object[]{contact});
		}
		return list;
	}



}
