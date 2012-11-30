package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
	@Test
	public void testCreateGroup() throws Exception {

		GroupData group = new GroupData();
		String RndStr = app.getContactHelper().getRandomString();
		group.groupName = "group" + RndStr;
		group.header = "header" + RndStr;
		group.footer = "footer"  + RndStr;

		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupPage();		
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupPage();
		app.getGroupHelper().returnToGroupPage();
	}
} 