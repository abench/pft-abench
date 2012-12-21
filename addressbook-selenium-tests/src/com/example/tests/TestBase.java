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
			GroupData group = new GroupData()
				.withGroupName(app.getDataHelper().getRandomCategory())
				.withHeader(app.getDataHelper().getRandomString())
				.withFooter(app.getDataHelper().getRandomString());
			list.add(new Object[]{group});			
		}
		return list.iterator();
	}


	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i=0; i<5; i++){
			ContactData contact = new ContactData();
			//group.groupName = app.getDataHelper().getRandomCategory();			
			//group.header = app.getDataHelper().getRandomString();
			//group.footer = app.getDataHelper().getRandomString();
			
			contact.firstname = app.getDataHelper().getRandomFirstName();
			contact.lastname = app.getDataHelper().getRandomSecondName();
			contact.address = app.getDataHelper().getRandomCity() + app.getDataHelper().getRandomStreet()+app.getDataHelper().getRandomNumericalString(3);
			contact.phoneHome =  app.getDataHelper().getRandomPhone();
			contact.phoneMobile = app.getDataHelper().getRandomPhone();
			contact.phoneWork = app.getDataHelper().getRandomPhone();
			contact.email = contact.firstname+"@mail.ru";
			contact.email2 =contact.firstname + app.getDataHelper().getRandomNumericalString(3) + "@mail.ru";
			contact.birthDay = app.getDataHelper().getRandomDay();
			contact.birthMonth =  app.getDataHelper().getRandomMonth();
			contact.address2 = app.getDataHelper().getRandomCity() + app.getDataHelper().getRandomStreet()+app.getDataHelper().getRandomNumericalString(3); ;
			contact.home2 = app.getDataHelper().getRandomCity() + app.getDataHelper().getRandomStreet()+app.getDataHelper().getRandomNumericalString(3); ;

			
			list.add(new Object[]{contact});			
		}
		return list.iterator();
	}

}
