package com.example.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.example.tests.GroupData;


public class GroupPage {
	
	private WebDriver driver;
	private String baseUrl;
	private String pageUrl = "addressbookv4.1.4/group.php"; 
	
	// Page Locators
	private String submitButtonLocator = "submit";
	private String newButtonLocator = "new";
	private String groupNameLocator = "group_name";
	private String groupHeaderLocator = "group_header";
	private String groupFooterLocator = "group_footer";
	
	
//	driver.findElement(By.name()).click();
//	driver.findElement(By.name()).clear();
//	driver.findElement(By.name("group_name")).sendKeys(group.groupName);
//	driver.findElement(By.name("group_header")).clear();
//	driver.findElement(By.name("group_header")).sendKeys(group.header);
//	driver.findElement(By.name("group_footer")).clear();
//	driver.findElement(By.name()).sendKeys(group.footer);

	
	
	public GroupPage(WebDriver bdriver, String bUrl){
		driver = bdriver;
		baseUrl = bUrl;
		
		
	}
	
	public WebElement getFieldByName(String name){
		return driver.findElement(By.name(name));
	}
	
	public void fillField(String name, String value){
		getFieldByName(name).clear();
		getFieldByName(name).sendKeys(value);		
	}
	
	public void fillGroupForm(GroupData data){
		fillField(groupNameLocator,data.groupName);
		fillField(groupHeaderLocator, data.header);
		fillField(groupFooterLocator, data.footer);
	}
	public WebElement getSubmitButton(){
		return driver.findElement(By.name(submitButtonLocator));		
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
