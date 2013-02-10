package com.example.fw;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public abstract class WebDriverHelperBase extends HelperBase{
	//protected ApplicationManager manager;
	protected WebDriver driver;
	
	public WebDriverHelperBase(ApplicationManager manager){
		super(manager);
		//this.manager = manager;
		this.driver = manager.getDriver();
		
		
	}



	public String getRandomString() {
		Random rnd = new Random();
		return Integer.toString(rnd.nextInt());
	
	}

	protected void type(By locator, String text) {
		if (text != null) {
			driver.findElement(locator).clear();		
			driver.findElement(locator).sendKeys(text);			
		}
	}

	protected void click(By locator) {
		driver.findElement(locator).click();
	}

	protected void selectByText(By locator, String text) {
		if (text!=null){
			new Select(driver.findElement(locator)).selectByVisibleText(text);			
		}
		
	}
	
	public void openUrl(String location){
		driver.get(manager.getProperty("baseURL")+
				   manager.getProperty("firstPage")+
				   location);
	}

	public void openAbsoluteUrl(String location){
		driver.get(location);
	}

	
// candidate to remove
	
	public boolean isElementPresent(By by) {
		try {
			manager.getDriver().findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	
}
