package com.example.fw;


public class ContactHelper extends HelpersBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void createContact(Contact contact) {
		initContactCreation();
		fillContactForm(contact);
		confirmContactCreation();
			
			
		
	}

	public void confirmContactCreation() {
		manager.getAutoItHelper()
			.click("Save");
	}

	public void fillContactForm(Contact contact) {
		String fname=contact.getFirstName();
		String lname = contact.getLastName();
//		manager.getAutoItHelper().winWaitAndActivate("Add Contact", "", 20000);
		manager.getAutoItHelper()
			.send("TDBEdit12", fname);
//		try {
//			Thread.sleep(20000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		manager.getAutoItHelper()
			.send("TDBEdit11", lname);
	}

	public void initContactCreation() {
		manager.getAutoItHelper()
			.winWaitAndActivate("AddressBook Portable", "", 20000);
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		manager.getAutoItHelper().click("Add").winWaitAndActivate("Add Contact", "", 20000);
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	

}
