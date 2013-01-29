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
		manager.getAutoItHelper()
			.send("TDBEdit12", fname);
		manager.getAutoItHelper()
			.send("TDBEdit11", lname);
	}

	public void initContactCreation() {
		manager.getAutoItHelper()
			.winWaitAndActivate("AddressBook Portable", "", 20000);
		manager.getAutoItHelper().click("Add").winWaitAndActivate("Add Contact", "", 20000);
	}

	public Contact getFirstContact() {
		manager.getAutoItHelper()
			.winWaitAndActivate("AddressBook Portable", "", 5000)
			.focus("TListView1")
			.send("{DOWN}{SPACE}")
			.click("Edit")
			.winWaitAndActivate("Update Contact", "", 5000);
		Contact contact = new Contact().setFirstName(manager.getAutoItHelper().getText("TDBEdit12"))
				.setLastName(manager.getAutoItHelper().getText("TDBEdit11"));
		manager.getAutoItHelper()
			.click("Cancel")
			.winWaitAndActivate("AddressBook Portable", "", 5000);		
		return contact;		
	}
}
