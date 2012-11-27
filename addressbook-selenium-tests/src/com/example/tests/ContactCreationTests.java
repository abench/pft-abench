package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactCreationTests {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testCreateContact() throws Exception {
		openContactPage();
		gotoContactsPage();
		
		ContactData contact = new ContactData(); 
		
			contact.firstname = "vasja";
			contact.lastname = "pupkin";
			contact.address = "pupkin town";
			contact.phoneHome = "11111111";
			contact.phoneMobile = "11111111";
			contact.phoneWork = "11111111";
			contact.email = "pupkin@mail.ru";
			contact.email2 = "vpupkin@mail.ru";
			contact.birthDay = "1";
			contact.birthMonth =  "January";
			contact.address2 = "pupkin town 2";
			contact.home2 = "pupkin home 1";
		
		fillContactsForm(contact);
		submitContactsForm();
		returnMainPage();
	}

	private void returnMainPage() {
		driver.findElement(By.linkText("home page")).click();
	}

	private void submitContactsForm() {
		driver.findElement(By.name("submit")).click();
	}

	private void fillContactsForm(ContactData contact) {
		driver.findElement(By.name("firstname")).clear();
		driver.findElement(By.name("firstname")).sendKeys(contact.firstname);
		driver.findElement(By.name("lastname")).clear();
		driver.findElement(By.name("lastname")).sendKeys(contact.lastname);
		driver.findElement(By.name("address")).clear();
		driver.findElement(By.name("address")).sendKeys(contact.address);
		driver.findElement(By.name("home")).clear();
		driver.findElement(By.name("home")).sendKeys(contact.phoneHome);
		driver.findElement(By.name("mobile")).clear();
		driver.findElement(By.name("mobile")).sendKeys(contact.phoneMobile);
		driver.findElement(By.name("work")).clear();
		driver.findElement(By.name("work")).sendKeys(contact.phoneWork);
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(contact.email);
		driver.findElement(By.name("email2")).clear();
		driver.findElement(By.name("email2")).sendKeys(contact.email2);
		new Select(driver.findElement(By.name("bday"))).selectByVisibleText(contact.birthDay);
		new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(contact.birthMonth);
		driver.findElement(By.name("byear")).clear();
		driver.findElement(By.name("byear")).sendKeys(contact.birthYear);
		driver.findElement(By.name("address2")).clear();
		driver.findElement(By.name("address2")).sendKeys(contact.address2);
		driver.findElement(By.name("phone2")).clear();
		driver.findElement(By.name("phone2")).sendKeys(contact.home2);
	}

	private void gotoContactsPage() {
		driver.findElement(By.linkText("add new")).click();
	}

	private void openContactPage() {
		driver.get(baseUrl + "/addressbookv4.1.4/group.php");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
} 