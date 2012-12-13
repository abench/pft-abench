package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;

public class GroupHelper extends HelperBase{
	
	//
	// Table of locators, used in GroupHelper procedures
	//
	
	// Naming rules:
	// n - By.name       lctr - locator     Name - name of button, link, input, etc.   Lft - left part of locator
	// x - By.xpath                                                                    Rht - right part of locator
	// l - By.linkText

	private static final String nlctrSubmit				= "submit";
	private static final String nlctrGroupName			= "group_name";
	private static final String nlctrGroupHeader		= "group_header";
	private static final String nlctrGroupFooter		= "group_footer";
	private static final String nlctrNewButton			= "new";
	private static final String nlctrDeleteButton		= "delete";
	private static final String xlctrGroupSelectorLft	= "//input[@name = 'selected[]'][";
	private static final String xlctrGroupSelectorRht 	= "]";
	private static final String nlctrEditBtn 			= "edit";
	private static final String nlctrUpdateBtn 			= "update";
	private static final String nlctrGroupCheckbox		= "selected[]";
	
	public GroupHelper(ApplicationManager manager) {
		super(manager);		
	}

	public void submitGroupPage() {
		click(By.name(nlctrSubmit));		
	}
	

	public void fillGroupForm(GroupData group) {		
		type(By.name(nlctrGroupName), group.groupName);
		type(By.name(nlctrGroupHeader),group.header);
		type(By.name(nlctrGroupFooter),group.footer);
	}
	
	
	public void initGroupCreation() {
		click(By.name(nlctrNewButton));
	}
	 

	public void deleteGroup(int index) {
		selectGroupByIndex(index);
		click(By.name(nlctrDeleteButton));
		
	}
	
	// index starts from 0
	public void selectGroupByIndex(int index) {
		click(By.xpath(xlctrGroupSelectorLft +index+1+xlctrGroupSelectorRht));
	}
	

	public void initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name(nlctrEditBtn));		
	}

	public void submitGroupModification() {
		click(By.name(nlctrUpdateBtn));	
	}

	public List<GroupData> getGroups() {
		List<GroupData> groups = new ArrayList<GroupData>();
		List<WebElement> checkboxes = driver.findElements(By.name(nlctrGroupCheckbox));
		for (WebElement checkbox : checkboxes) {
			GroupData group = new GroupData();
			String title = checkbox.getAttribute("title");
			group.groupName =title.substring("Select (".length(), title.length()-")".length());
			groups.add(group);
		}
		
		return groups;
	}
	
	
}
