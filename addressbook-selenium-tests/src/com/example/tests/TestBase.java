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
			
				contact.withFirstname(app.getDataHelper().getRandomFirstName())
				.withLastname(app.getDataHelper().getRandomSecondName())
				.withAddress(app.getDataHelper().getRandomCity() + app.getDataHelper().getRandomStreet()+app.getDataHelper().getRandomNumericalString(3))
				.withPhoneHome(app.getDataHelper().getRandomPhone())
				.withPhoneMobile(app.getDataHelper().getRandomPhone())
				.withPhoneWork(app.getDataHelper().getRandomPhone())
				.withEmail(contact.firstname+"@mail.ru")
				.withEmail2(contact.firstname + app.getDataHelper().getRandomNumericalString(3) + "@mail.ru")
				.withBirthDay(app.getDataHelper().getRandomDay())
				.withBirthMonth(app.getDataHelper().getRandomMonth())
				.withAddress(app.getDataHelper().getRandomCity() + app.getDataHelper().getRandomStreet()+app.getDataHelper().getRandomNumericalString(3))
				.withHome2(app.getDataHelper().getRandomCity() + app.getDataHelper().getRandomStreet()+app.getDataHelper().getRandomNumericalString(3));

			
			list.add(new Object[]{contact});			
		}
		return list.iterator();
	}

}
