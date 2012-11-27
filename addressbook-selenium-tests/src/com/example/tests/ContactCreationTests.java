package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
// import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

	@Test
	public void testCreateContact() throws Exception {
		openContactPage();
		gotoContactsPage();
		
		ContactData contact = new ContactData(); 
		
			contact.firstname = "vasja" + getRandomString();
			contact.lastname = "pupkin" + getRandomString();
			contact.address = "pupkin town" + getRandomString();
			contact.phoneHome =  getRandomString();
			contact.phoneMobile = getRandomString();
			contact.phoneWork =   getRandomString();
			contact.email = "pupkin" + getRandomString()+ "@mail.ru";
			contact.email2 = "vpupkin" + getRandomString()+ "@mail.ru";
			contact.birthDay = "1";
			contact.birthMonth =  "January";
			contact.address2 = "pupkin town No" + getRandomString() ;
			contact.home2 = "pupkin home No"  + getRandomString() ;
		
		fillContactsForm(contact);
		submitContactsForm();
		returnMainPage();
	}


} 