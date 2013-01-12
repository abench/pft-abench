package com.example.tests;

import static com.example.tests.GroupDataGenerator.loadGroupsFromCsvFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;



public class GroupCreationTests extends TestBaseGroup {
	
	@DataProvider
	public Iterator<Object[]> groupsFromCsvFile() throws IOException{
		return wrapListForDataProvider(loadGroupsFromCsvFile(new File("groups.txt"))).iterator();
	}


	//@Test(dataProvider="randomValidGroupGenerator")
	@Test(dataProvider="groupsFromCsvFile")
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