package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase{

	//
	// Table of locators, used in NavigationHelper procedures
	//
	
	// Naming rules:
	// n - By.name       lctr - locator     Name - name of button, link, input, etc.   Lft - left part of locator
	// x - By.xpath                                                                    Rht - right part of locator
	// l - By.linkText
	// a - full or part of web address

	private static final String alctrMainPage 	= "/addressbookv4.1.4/";
	private static final String llctrGroupsPage = "groups";
	private static final String llctrMainPage 	= "home page";
	private static final String llctrGroupPage2 = "group page";
	

	public NavigationHelper(ApplicationManager manager) {
		super(manager);		
	}

	public void openMainPage() {
		driver.get(manager.baseUrl + alctrMainPage);
	}
	
	
	public void gotoGroupPage() {		
		driver.findElement(By.linkText(llctrGroupsPage)).click();
	}	

	public void returnMainPage() {
		driver.findElement(By.linkText(llctrMainPage)).click();
	}
	
	
	public void returnToGroupPage() {
		click(By.linkText(llctrGroupPage2));		
	}

	
}
