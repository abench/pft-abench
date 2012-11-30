package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.GroupData;
import com.example.tests.TestBase;

public class GroupHelper extends HelperBase{

	public GroupHelper(ApplicationManager manager) {
		super(manager);
		
	}

	public void submitGroupPage() {
		driver.findElement(By.name("submit")).click();
	}

	public void fillGroupForm(ApplicationManager applicationManager, TestBase testBase, GroupData group) {
		driver.findElement(By.name("new")).click();
		driver.findElement(By.name("group_name")).clear();
		driver.findElement(By.name("group_name")).sendKeys(group.groupName);
		driver.findElement(By.name("group_header")).clear();
		driver.findElement(By.name("group_header")).sendKeys(group.header);
		driver.findElement(By.name("group_footer")).clear();
		driver.findElement(By.name("group_footer")).sendKeys(group.footer);
	}

	public void returnToGroupPage() {
		driver.findElement(By.linkText("group page")).click();
	}

}
