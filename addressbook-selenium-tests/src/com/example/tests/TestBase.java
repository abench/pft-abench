package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected static ApplicationManager app;


	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();
	}

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	}
	
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i=0; i<5; i++){
			GroupData group = new GroupData();
			group.groupName = app.getDataHelper().getRandomCategory();			
			group.header = app.getDataHelper().getRandomString();
			group.footer = app.getDataHelper().getRandomString();
			list.add(new Object[]{group});			
		}
		return list.iterator();
	}

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i=0; i<5; i++){
			ContactData contact = new ContactData();
			group.groupName = app.getDataHelper().getRandomCategory();			
			group.header = app.getDataHelper().getRandomString();
			group.footer = app.getDataHelper().getRandomString();
			
			contact.firstname = "vasja" + rndStr;
			contact.lastname = "pupkin" + rndStr;
			contact.address = "pupkin town" + rndStr;
			contact.phoneHome =  rndStr;
			contact.phoneMobile = rndStr;
			contact.phoneWork =   rndStr;
			contact.email = "pupkin" + rndStr+ "@mail.ru";
			contact.email2 = "vpupkin" + rndStr+ "@mail.ru";
			contact.birthDay = "1";
			contact.birthMonth =  "January";
			contact.address2 = "pupkin town No" + rndStr ;
			contact.home2 = "pupkin home No"  + rndStr ;

			
			list.add(new Object[]{contact});			
		}
		return list.iterator();
	}

}
