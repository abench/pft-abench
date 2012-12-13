package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase{

	//
	// Table of locators, used in GroupHelper procedures
	//
	
	// Naming rules:
	// n - By.name       lctr - locator     Name - name of button, link, input, etc.   Lft - left part of locator
	// x - By.xpath                                                                    Rht - right part of locator
	// l - By.linkText
	// a - full or part of web address
	
	private static final String xlctrUpdateButton = ".//input[@value='Update']";
	private static final String xlctrEditButtonRht = "]/td[7]/a";
	private static final String xlctrEditButtonLft = ".//tr[";
	private static final String xlctrDeleteButton = ".//input[@value='Delete']";
	private static final String llctrNewContactsPage = "add new";
	private static final String alctrContactsPage = "/addressbookv4.1.4/group.php";
	private static final String nlctrHome2Input = "phone2";
	private static final String nlctrAddress2Input = "address2";
	private static final String nlctrByearInput = "byear";
	private static final String nlctrBmonthInput 	= "bmonth";
	private static final String nlctrBdayInput 		= "bday";
	private static final String nlctrEmail2Input 	= "email2";
	private static final String nlctrEmailInput 	= "email";
	private static final String nlctrWorkInput 		= "work";
	private static final String nlctrMobileInput 	= "mobile";
	private static final String nlctrSubmitButton 	= "submit";
	private static final String nlctrFirstNameInput = "firstname";
	private static final String nlctrLastNameInput 	= "lastname";
	private static final String nlctrAddressInput 	= "address";
	private static final String nctrlHomeInput 		= "home";
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
		
	}

	public void submitContactsForm() {
		click(By.name(nlctrSubmitButton));
	}

	public void fillContactsForm(ContactData contact) {
		type(By.name(nlctrFirstNameInput),contact.firstname);
		type(By.name(nlctrLastNameInput),contact.lastname);
		type(By.name(nlctrAddressInput),contact.address);
		type(By.name(nctrlHomeInput),contact.phoneHome);
		type(By.name(nlctrMobileInput),contact.phoneMobile);
		type(By.name(nlctrWorkInput),contact.phoneWork);
		type(By.name(nlctrEmailInput),contact.email);
		type(By.name(nlctrEmail2Input),contact.email2);
		selectByText(By.name(nlctrBdayInput), contact.birthDay);
		selectByText(By.name(nlctrBmonthInput),contact.birthMonth);
		type(By.name(nlctrByearInput),contact.birthYear);
		type(By.name(nlctrAddress2Input),contact.address2);
		type(By.name(nlctrHome2Input),contact.home2);
	}

	public void openContactPage() {
		driver.get(manager.baseUrl + alctrContactsPage);
	}

	public void gotoContactsPage() {
		click(By.linkText(llctrNewContactsPage));
	}

	public void deleteContact(int index) {
		initContactModificationByIndex(index);		
		click(By.xpath(xlctrDeleteButton));
		
	}

	public void initContactModificationByIndex(int index) {
		
		//XPATH locator of element .//tr[index]/td[7]/a
		//index should be > 2
		//because first row is reserved for header
		
		int i=index+1;
		click(By.xpath(xlctrEditButtonLft+i+xlctrEditButtonRht));
		
	}

	public void updateContactsForm() {		
		click(By.xpath(xlctrUpdateButton));
		
	}
	
	public List<ContactData> getContacts(){
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> checkboxes= driver.findElements(By.name("selected[]"));
		for (WebElement checkbox:checkboxes){
			ContactData contact = new ContactData();
			String title = checkbox.getAttribute("title");
			String[] str= title.substring("Select (".length(), title.length()-")".length()).split("\\s+");
			//title.  
			//contact.firstname p.groupName =title.substring("Select (".length(), title.length()-")".length());
			contact.firstname=str[0];
			contacts.add(contact);

		}
		
		return contacts;
	}
}
