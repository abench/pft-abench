package com.example.fw;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public abstract class HelperBase {
	protected ApplicationManager manager;
	protected WebDriver driver;

	//protected ApplicationManager manager;
	public HelperBase(ApplicationManager manager){
		this.manager = manager;
		this.driver = manager.driver;
		
	}

	public boolean isElementPresent(By by) {
		try {
			manager.driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
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
	

}
