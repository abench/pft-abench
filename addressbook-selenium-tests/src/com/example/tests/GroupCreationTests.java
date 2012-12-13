package com.example.tests;

import java.util.Collections;
import java.util.List;
import static org.testng.Assert.assertEquals;

// import org.openqa.selenium.logging.NeedsLocalLogs;
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

		// goto Group page 
		
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupPage();
		
		// save old state
		List<GroupData> oldList = app.getGroupHelper().getGroups();
		
		// execute actions
		app.getGroupHelper().initGroupCreation();
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupPage();
		app.getNavigationHelper().returnToGroupPage();
		
		// save new state
		List<GroupData> newList = app.getGroupHelper().getGroups();
		
		//
		// compare old and new state
		//
		
		// by length
		assertEquals(oldList.size()+1, newList.size());
		
		// by content
		oldList.add(group);
		Collections.sort(oldList);
		Collections.sort(newList);		
		assertEquals(oldList, newList);
		
		
	}
} 