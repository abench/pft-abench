package com.example.tests;

import java.util.Random;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class GroupCreationTests {
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
	public void testCreateGroup() throws Exception {
		openMainPage();
		gotoGroupPage();
		
		GroupData group = new GroupData();
		Random rnd = new Random();
		//rnd.nextInt()
		
		
		
		group.groupName = "group" + Integer.toString(rnd.nextInt());
		group.header = "group header";
		group.footer = "group footer";
		
		fillGroupForm(group);
		submitGroupPage();
		returnToGroupPage();
	}

	private void returnToGroupPage() {
		driver.findElement(By.linkText("group page")).click();
	}

	private void submitGroupPage() {
		driver.findElement(By.name("submit")).click();
	}

	private void fillGroupForm(GroupData group) {
		driver.findElement(By.name("new")).click();
		driver.findElement(By.name("group_name")).clear();
		driver.findElement(By.name("group_name")).sendKeys(group.groupName);
		driver.findElement(By.name("group_header")).clear();
		driver.findElement(By.name("group_header")).sendKeys(group.header);
		driver.findElement(By.name("group_footer")).clear();
		driver.findElement(By.name("group_footer")).sendKeys(group.footer);
	}

	private void gotoGroupPage() {		
		driver.findElement(By.linkText("groups")).click();
	}

	private void openMainPage() {
		driver.get(baseUrl + "/addressbookv4.1.4/");
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