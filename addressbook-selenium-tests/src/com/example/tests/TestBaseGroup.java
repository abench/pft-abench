package com.example.tests;

import static com.example.tests.GroupDataGenerator.generateRandomGroups;
import static com.example.tests.GroupDataGenerator.loadGroupsFromCsvFile;
import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

public class TestBaseGroup extends TestBase {

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		return wrapListForDataProvider(generateRandomGroups(5)).iterator();
	}
	
	@DataProvider
	public Iterator<Object[]> groupsFromCsvFile() throws IOException {
		return wrapListForDataProvider(loadGroupsFromCsvFile(new File("groups.txt"))).iterator();
	}

	@DataProvider
	public Iterator<Object[]> groupsFromXmlFile() throws IOException {
		return wrapListForDataProvider(loadGroupsFromXmlFile(new File("groups.xml"))).iterator();
	}

	public static List<Object[]> wrapListForDataProvider(List<GroupData> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (GroupData group:groups){
			list.add(new Object[]{group});
			
		}
		return list;
	}


}
