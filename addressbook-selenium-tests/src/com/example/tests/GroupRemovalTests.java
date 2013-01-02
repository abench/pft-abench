package com.example.tests;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

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
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);
		
		app.getGroupHelper()
			.deleteGroup(index)
			.returnToGroupPage();
		
		// save new state
		List<GroupData> newList = app.getGroupHelper().getGroups();
		
		// compare quantity
		assertEquals(oldList.size()+1,newList.size());
		
		// Compare content
		oldList.remove(index);		
		Collections.sort(oldList);
		Collections.sort(newList);
		assertEquals(oldList, newList);	

	}

}
