package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;


import org.testng.annotations.Test;

import com.example.utils.SortedListOf;



public class GroupCreationTests extends TestBaseGroup {
	
	
	@Test(dataProvider="groupsFromCsvFile")
	public void testGroupCreationWithValidData(GroupData group) throws Exception {
		// save old state
		SortedListOf<GroupData> oldList = new SortedListOf<GroupData>(app.getHibernateHelper().listGroups());
		
		// execute actions
		app.getGroupHelper().createGroup(group);
		
		// save new state
		SortedListOf<GroupData> newList = app.getModel().getGroups();
		
		//
		// compare old and new state
		//
		
		// by length
		assertEquals(oldList.size()+1, newList.size());
		
		// by content
		if (wantToCheck()){
			if ("yes".equals(app.getProperty("check.db"))){
				assertThat(app.getModel().getGroups(), equalTo(app.getHibernateHelper().listGroups()));		
			}
			
			if ("yes".equals(app.getProperty("check.ui"))){
				assertThat(app.getModel().getGroups(), equalTo(app.getGroupHelper().getUiGroups()));	
			}	
		}
		
	}
} 