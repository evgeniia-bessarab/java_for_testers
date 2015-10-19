package com.example.fw;

import com.example.tests.Contact;

public class ContactHelper extends HelperBase{

	public ContactHelper(ApplicationManager applicationManager) {
		super(applicationManager);
		// TODO Auto-generated constructor stub
	}

	public void createContact(Contact contact) {
		initContactCreation();
		fillcontactForm(contact);
		confirmContactCreation();
		
	}

	private void confirmContactCreation() {
		manager.getAutoItHelper()
		  .click("Save")
		  .winWaitAndActivate("AddressBook Portable", "", 5000);
	}

	private void fillcontactForm(Contact contact) {
		manager.getAutoItHelper()
		  .send("TDBEdit12", contact.firstName)
		  .send("TDBEdit11", contact.lastName);
	}

	private void initContactCreation() {
		manager.getAutoItHelper()
		  .winWaitAndActivate("AddressBook Portable", "", 5000)
		  .click("Add").winWaitAndActivate("Add Contact", "", 5000);
	}

	public Contact getFirstContact() {
		manager.getAutoItHelper()
		  .winWaitAndActivate("AddressBook Portable", "", 5000)
		  .focus("TListView1")
		  .send("{DOWN}{SPACE}")
		  .click("Edit")
		  .winWaitAndActivate("Update Contact", "", 5000);
		Contact contact = new Contact()
				.setFirstName(manager.getAutoItHelper().getText("TDBEdit12"))
				.setLastName(manager.getAutoItHelper().getText("TDBEdit11"));
		manager.getAutoItHelper()
		  .click("Cancel")
		  .winWaitAndActivate("AddressBook Portable", "", 5000);
		return contact;
		
		
	}

}
