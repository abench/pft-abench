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
	private static final String llctrGroupPage2 = "group page";
	
	public GroupHelper(ApplicationManager manager) {
		super(manager);		
	}

	public GroupHelper submitGroupPage() {
		click(By.name(nlctrSubmit));
		return this;
	}
	

	public GroupHelper fillGroupForm(GroupData group) {		
		type(By.name(nlctrGroupName), group.getGroupName());
		type(By.name(nlctrGroupHeader),group.getHeader());
		type(By.name(nlctrGroupFooter),group.getFooter());
		return this;
	}
	
	
	public GroupHelper initGroupCreation() {
		manager.navigateTo().groupPage();
		click(By.name(nlctrNewButton));
		return this;
	}
	 

	
	// index starts from 0
	public GroupHelper selectGroupByIndex(int index) {
		click(By.xpath(xlctrGroupSelectorLft +index+1+xlctrGroupSelectorRht));
		return this;
	}
	

	public GroupHelper initGroupModification(int index) {
		manager.navigateTo().groupPage();
		selectGroupByIndex(index);
		click(By.name(nlctrEditBtn));
		return this;
	}

	public GroupHelper submitGroupModification() {
		click(By.name(nlctrUpdateBtn));
		return this;
	}

	public void returnToGroupPage() {
		click(By.linkText(llctrGroupPage2));		
	}
	
	private void submitDeletion() {
		click(By.name(nlctrDeleteButton));
	}
	
	
	//-----------------------------------------------------------------------------------------
	
	public List<GroupData> getGroups() {
		
		List<GroupData> groups = new ArrayList<GroupData>();
		manager.navigateTo().groupPage();
		List<WebElement> checkboxes = driver.findElements(By.name(nlctrGroupCheckbox));
		for (WebElement checkbox : checkboxes) {			
			String atr = checkbox.getAttribute("title");
			String title = atr.substring("Select (".length(), atr.length()-")".length());
			groups.add(new GroupData().withGroupName(title));
		}
		
		return groups;
	}

	public GroupHelper createGroup(GroupData group) {
		manager.navigateTo().groupPage();
		initGroupCreation();
		fillGroupForm(group);
		submitGroupPage();		
		returnToGroupPage();
		return this;

	}

	public GroupHelper  modifyGroup(int index, GroupData group) {
		initGroupModification(index);
		fillGroupForm(group);
		submitGroupModification();
		returnToGroupPage();
		return this;
	
		
	}
	public GroupHelper deleteGroup(int index) {
		selectGroupByIndex(index);
		submitDeletion();
		returnToGroupPage();
		return this;
		
	}

	
	
}
