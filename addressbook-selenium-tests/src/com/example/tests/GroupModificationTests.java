package com.example.tests;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{
	
	@Test
	public void modifySomeGroup(){
		
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupPage();
		
		// save old state
		List<GroupData> oldList = app.getGroupHelper().getGroups();

		// execute test
		app.getGroupHelper().initGroupModification(0);
		
		GroupData group = new GroupData();
		group.groupName = "new name";
		
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupModification();
			
		app.getNavigationHelper().returnToGroupPage();
		
		// save new state
		List<GroupData> newList = app.getGroupHelper().getGroups();
		// compare quantity
		assertEquals(oldList.size(),newList.size());
		// Compare content
		
		oldList.remove(0);
		oldList.add(group);
		Collections.sort(oldList);
		Collections.sort(newList);
		assertEquals(oldList, newList);		
	}

}
