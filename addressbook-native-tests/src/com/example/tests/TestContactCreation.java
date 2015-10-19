package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestContactCreation extends TestsBase {
	@Test
	public void shouldCreateContactWthValidDate() {
		Contact contact = new Contact().setFirstName("tester").setLastName("tester");
		app.getContactHelper().createContact(contact);
		Contact createContact = app.getContactHelper().getFirstContact();
		Assert.assertEquals(contact, createContact);
	}

}
