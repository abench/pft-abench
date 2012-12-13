package com.example.tests;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase{
	
	
	@Test
	public void deleteSomeGroup(){
		
		// navigate to group page
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupPage();
		
		// save old state
		List<GroupData> oldList = app.getGroupHelper().getGroups();

		// execute test
		app.getGroupHelper().deleteGroup(0);
		app.getNavigationHelper().returnToGroupPage();
		
		// save new state
		List<GroupData> newList = app.getGroupHelper().getGroups();
		
		// compare quantity
		assertEquals(oldList.size(),newList.size()+1);
		
		// Compare content
		oldList.remove(0);		
		Collections.sort(oldList);
		Collections.sort(newList);
		assertEquals(oldList, newList);	

	}

}
