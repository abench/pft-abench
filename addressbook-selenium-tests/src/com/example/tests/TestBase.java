package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;
import static com.example.fw.RandomDataHelper.*;

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
				.withGroupName(getRandomCategory())
				.withHeader(getRandomString())
				.withFooter(getRandomString());
			list.add(new Object[]{group});			
		}
		return list.iterator();
	}


	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i=0; i<5; i++){
			String randomFirstname = getRandomFirstName();
			ContactData contact = new ContactData()
				.withFirstname(randomFirstname)
				.withLastname(getRandomSecondName())
				.withAddress(getRandomAddress())
				.withPhoneHome(getRandomPhone())
				.withPhoneMobile(getRandomPhone())
				.withPhoneWork(getRandomPhone())
				.withEmail(getRandomEmail(randomFirstname))
				.withEmail2(getRandomEmail(randomFirstname))
				.withBirthDay(getRandomDay())
				.withBirthMonth(getRandomMonth())
				.withAddress(getRandomAddress())
				.withHome2(getRandomAddress());

			
			list.add(new Object[]{contact});			
		}
		return list.iterator();
	}

}
