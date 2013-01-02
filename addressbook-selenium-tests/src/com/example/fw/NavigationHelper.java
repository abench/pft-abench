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
	
	

	public NavigationHelper(ApplicationManager manager) {
		super(manager);		
	}

	public void mainPage() {
		if (!onMainPage()){
			
			click(By.linkText("home"));
		}
		
	}
	
	
	private boolean onMainPage() {		
		return driver.findElements(By.id("maintable")).size()>0;
	}

	public void groupPage() {	
		if (!onGroupPage()){
			driver.findElement(By.linkText(llctrGroupsPage)).click();			
		}
		
	}	

	private boolean onGroupPage() {
		if (driver.getCurrentUrl().contains("/group.php")
				&& driver.findElements(By.name("new")).size()>0){
			return true;
		}
		else {
			return false;
		}
		
	}

	public void returnMainPage() {
		driver.findElement(By.linkText(llctrMainPage)).click();
	}
	
	

	
}
