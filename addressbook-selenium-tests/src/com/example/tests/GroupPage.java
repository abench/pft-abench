package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GroupPage {
	
	private WebDriver driver;
	private String baseUrl;
	
	// Page Locators
	private String submitButtonLocator = "";
	private String newButtonLocator = "";
	private String groupNameLocator = "";
	private String groupHeaderLocator = "";
	private String groupFooterLocator = "";
	
	
	public GroupPage(WebDriver bdriver, String bUrl){
		driver = bdriver;
		baseUrl = bUrl;
		
	}
	
	public WebElement getSubmitButton(){
		return null;
		
	}
	
	public void clickSubmitButton(){
		getSubmitButton().click();
		//return null;
		
	}
	
	public WebElement getNewButton(){
		return null;
	}
	
	public void clickNewButton(){
		getNewButton().click();
		//return null;
	}
	
	
	

}
