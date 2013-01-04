package com.example.tests;

import static org.testng.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;



public class GroupCreationTests extends TestBase {
	
	
	@Test(dataProvider="randomValidGroupGenerator")
	public void testGroupCreationWithValidData(GroupData group) throws Exception {
		// save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
		
		// execute actions
		app.getGroupHelper().createGroup(group);
		
		// save new state
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
		
		//
		// compare old and new state
		//
		
		// by length
		assertEquals(oldList.size()+1, newList.size());
		
		// by content
		assertThat(newList, equalTo(oldList.withAdded(group)));		
	}
} 