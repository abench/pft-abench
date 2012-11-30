package com.example.tests;

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