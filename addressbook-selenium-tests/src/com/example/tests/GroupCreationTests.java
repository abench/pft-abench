package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
	@Test
	public void testCreateGroup() throws Exception {

		
		String RndStr = "";
		RndStr = app.getGroupHelper().getRandomString();
		
		GroupData group = new GroupData();
		
		group.groupName = "group" + RndStr;
		group.header = "header" + RndStr;
		group.footer = "footer"  + RndStr;

		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupPage();
		app.getGroupHelper().initGroupCreation();
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupPage();
		app.getNavigationHelper().returnToGroupPage();
	}
} 