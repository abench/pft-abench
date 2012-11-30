package com.example.fw;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase{

	public ContactHelper(ApplicationManager manager) {
		super(manager);
		
	}

	public void submitContactsForm() {
		click(By.name("submit"));
	}

	public void fillContactsForm(ContactData contact) {
		type(By.name("firstname"),contact.firstname);
		type(By.name("lastname"),contact.lastname);
		type(By.name("address"),contact.address);
		type(By.name("home"),contact.phoneHome);
		type(By.name("mobile"),contact.phoneMobile);
		type(By.name("work"),contact.phoneWork);
		type(By.name("email"),contact.email);
		type(By.name("email2"),contact.email2);
		selectByText(By.name("bday"), contact.birthDay);
		selectByText(By.name("bmonth"),contact.birthMonth);
		type(By.name("byear"),contact.birthYear);
		type(By.name("address2"),contact.address2);
		type(By.name("phone2"),contact.home2);
	}

	private void selectByText(By locator, String text) {
		new Select(driver.findElement(locator)).selectByVisibleText(text);
	}

	public void openContactPage() {
		driver.get(manager.baseUrl + "/addressbookv4.1.4/group.php");
	}

	public void gotoContactsPage() {
		click(By.linkText("add new"));
	}
}