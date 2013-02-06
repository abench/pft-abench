package com.example.tests;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupRemovalTests extends TestBaseGroup{
	
	
	@Test
	public void deleteSomeGroup(){
		// save old state
		SortedListOf<GroupData> oldList = new SortedListOf<GroupData>(app.getHibernateHelper().listGroups());
		// execute test
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);		
		app.getGroupHelper().deleteGroup(index);		
		// save new state
		SortedListOf<GroupData> newList = app.getModel().getGroups();		
		// compare quantity
		assertEquals(oldList.size()+1,newList.size());		
		// Compare content
		compareGroupModelWithDatabase();
		compareGroupModelWithUi();
	}

}
