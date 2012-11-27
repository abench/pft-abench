package com.example.tests;

import java.util.Random;
import java.util.regex.Pattern;
//import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
	@Test
	public void testCreateGroup() throws Exception {

		GroupData group = new GroupData();
		
		group.groupName = "group" + getRandomString();
		group.header = "header" + getRandomString();
		group.footer = "footer"  + getRandomString();

		openMainPage();
		gotoGroupPage();		
		fillGroupForm(group);
		submitGroupPage();
		returnToGroupPage();
	}
} 