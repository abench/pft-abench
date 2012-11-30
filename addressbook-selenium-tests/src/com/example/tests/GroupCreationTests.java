package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
	@Test
	public void testCreateGroup() throws Exception {

		GroupData group = new GroupData();
		
		group.groupName = "group" + app.getContactHelper().getRandomString();
		group.header = "header" + app.getContactHelper().getRandomString();
		group.footer = "footer"  + app.getContactHelper().getRandomString();

		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupPage();		
		app.getGroupHelper().fillGroupForm(app, this, group);
		app.getGroupHelper().submitGroupPage();
		app.getGroupHelper().returnToGroupPage();
	}
} 