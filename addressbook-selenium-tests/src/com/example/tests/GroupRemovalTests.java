package com.example.tests;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupRemovalTests extends TestBase{
	
	
	@Test
	public void deleteSomeGroup(){
		// save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();

		// execute test
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);
		
		app.getGroupHelper().deleteGroup(index);
			
		
		// save new state
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
		
		// compare quantity
		assertEquals(oldList.size()+1,newList.size());
		
		// Compare content
		oldList.remove(index);		
		assertEquals(oldList, newList);	

	}

}
