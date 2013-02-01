package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends WebDriverHelperBase{

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
	private static final String nctrlContactCheckbox= "selected[]";
	private static final String llctrMainPage 		= "home page";
	private static final String alctrMainPage 		= "/addressbookv4.1.4/";	
	public static boolean MODIFICATION = false;
	public static boolean CREATION = true;
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
		
	}

	public ContactHelper submitContactsForm() {
		click(By.name(nlctrSubmitButton));
		cachedContacts = null;
		return this;
	}

	public ContactHelper fillContactsForm(ContactData contact, boolean formType ) {
		type(By.name(nlctrFirstNameInput),contact.getFirstname());
		type(By.name(nlctrLastNameInput),contact.getLastname());
		type(By.name(nlctrAddressInput),contact.getAddress());
		type(By.name(nctrlHomeInput),contact.getPhoneHome());
		type(By.name(nlctrMobileInput),contact.getPhoneMobile());
		type(By.name(nlctrWorkInput),contact.getPhoneWork());
		type(By.name(nlctrEmailInput),contact.getEmail());
		type(By.name(nlctrEmail2Input),contact.getEmail2());
		selectByText(By.name(nlctrBdayInput), contact.getBirthDay());
		selectByText(By.name(nlctrBmonthInput),contact.getBirthMonth());
		if (formType == CREATION){
			
		}
		else {
			if (driver.findElements(By.name("new_group")).size()!=0){
				throw new Error ("Group selector exist in contact modification form");
			}
		}
			
		type(By.name(nlctrByearInput),contact.getBirthYear());
		type(By.name(nlctrAddress2Input),contact.getAddress2());
		type(By.name(nlctrHome2Input),contact.getHome2());
		return this;
	}

	public ContactHelper openContactPage() {
		driver.get(manager.baseUrl + alctrContactsPage);
		return this;
	}

	public ContactHelper initContactCreation() {
		click(By.linkText(llctrNewContactsPage));
		return this;
	}
	
	public void returnMainPage() {
		driver.findElement(By.linkText(llctrMainPage)).click();
	}
	
	public void openMainPage() {
		driver.get(manager.baseUrl + alctrMainPage);
	}



	
	private void submitDeletion() {
		click(By.xpath(xlctrDeleteButton));
		cachedContacts = null;
	}
	
	//index start from 0 
	public ContactHelper initContactModificationByIndex(int index) {
		
		//XPATH locator of element .//tr[index]/td[7]/a
		//index should be > 2
		//because first row is reserved for header
		
		int i=index+2;
		click(By.xpath(xlctrEditButtonLft+i+xlctrEditButtonRht));
		return this;
	}

	public ContactHelper updateContactsForm() {		
		click(By.xpath(xlctrUpdateButton));
		cachedContacts = null;
		return this;
	}

//------------------------------------------------------------------------
	
	private SortedListOf<ContactData> cachedContacts;
	
	public SortedListOf<ContactData> getContacts(){
		
		if (cachedContacts==null){
			rebuildCache();
		}
		return cachedContacts;
		
	}

	
	private void rebuildCache() {
		cachedContacts = new SortedListOf<ContactData>();
		manager.navigateTo().mainPage();
		List<WebElement> checkboxes= driver.findElements(By.name(nctrlContactCheckbox));
		for (WebElement checkbox:checkboxes){			
			String title = checkbox.getAttribute("title");
			String[] str= title.substring("Select (".length(), title.length()-")".length()).split("\\s+");
			cachedContacts.add(new ContactData().withLastname(str[1]));
		}
			
	}

	public ContactHelper createContact(ContactData contact) {		
		initContactCreation();		
		fillContactsForm(contact,CREATION);
		submitContactsForm();			
		returnMainPage();
		rebuildCache();
		return this;
	}

	public ContactHelper modifyContact(ContactData contact, int index) {
		initContactModificationByIndex(index);
		fillContactsForm(contact, MODIFICATION);
		updateContactsForm();
		openMainPage();
		rebuildCache();
		return this;
	}
	
	public ContactHelper deleteContact(int index) {
		initContactModificationByIndex(index);		
		submitDeletion();
		returnMainPage();
		rebuildCache();
		return this;
	}

}
