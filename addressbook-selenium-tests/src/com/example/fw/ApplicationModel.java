package com.example.fw;

import java.util.List;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class ApplicationModel {
	private SortedListOf<GroupData> groups;
	public SortedListOf<GroupData> getGroups(){
		return groups;
	}
	public void setGroups(List<GroupData> groups){
		this.groups = new SortedListOf<GroupData>(groups);	
	}
	

}
