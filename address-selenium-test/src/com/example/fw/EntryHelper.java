package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.EnterAdditionalInfoParameter;
import com.example.tests.EnterBirthDateParameter;
import com.example.tests.EnterPhonesParameter;
import com.example.tests.FillEntryFormParameter;

public class EntryHelper  extends HelperBase{

	public EntryHelper(ApplicationManager manager) {
		super(manager);
	}

	public void submitEntryCreation() {
		click(By.linkText("submit"));
	}

	public void fillEntryForm(FillEntryFormParameter parameterObject) {	
		enterFirstName(parameterObject.firstName);
		enterLastName(parameterObject.lastName);
		
		enterAdress(parameterObject.address);
		
		enterPhones(parameterObject.phones);
		
	    enterEmail(parameterObject.email);
	    enterSecondEmail(parameterObject.emailSecond);
	    
	    enterBirthDate(parameterObject.birthDate);
	    
	    enterAdditionalInfo(parameterObject.additInfo);
	    
	}

	public void enterAdditionalInfo(EnterAdditionalInfoParameter parameterObject) {
		enterSecondAdress(parameterObject.address);
		enterSecondPhone(parameterObject.phone);   
	}

	public void enterSecondAdress(String address2) {
		type(By.name("address2"), address2);
	}

	public void enterSecondPhone(String phone2) {
		type(By.name("phone2"), phone2);
	}

	public void enterSecondEmail(String emailSecond) {
		type(By.name("email2"), emailSecond);
	}

	public void enterBirthDate(EnterBirthDateParameter parameterObject) {
		selectByText(By.name("bday"),parameterObject.day);
	    selectByText(By.name("bmonth"),parameterObject.month);
	    type(By.name("byear"), parameterObject.year);
	}

	public void enterEmail(String email) {
	    type(By.name("email"), email);
	}

	public void enterPhones(EnterPhonesParameter parameterObject) {
		enterPhoneWork(parameterObject.work);
		enterPhoneMobile(parameterObject.mobile);
		enterPhoneHome(parameterObject.home);
	}

	public void enterPhoneWork(String workPhone) {
	    type(By.name("work"), workPhone);
	}

	public void enterPhoneHome(String homePhone) {
	    type(By.name("home"), homePhone);
	}

	public void enterPhoneMobile(String mobilePhone) {
	    type(By.name("mobile"), mobilePhone);
	}

	public void enterAdress(String address) {
	    type(By.name("address"), address);
	}

	public void enterLastName(String lastname) {
	    type(By.name("lastname"), lastname);
	}

	public void enterFirstName(String firstname) {
	    type(By.name("firstname"), firstname);
	}

}
