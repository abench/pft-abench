package com.example.tests;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupModificationTests extends TestBase{
	
	@Test(dataProvider="randomValidGroupGenerator")
	public void modifySomeGroup(GroupData group){
		// save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();

		// execute test
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);

		app.getGroupHelper().modifyGroup(index,group);
		
		// save new state
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
		// compare quantity
		assertEquals(oldList.size(),newList.size());
		// Compare content
		
		oldList.remove(index);
		oldList.add(group);		
		assertEquals(oldList, newList);		
	}

}
