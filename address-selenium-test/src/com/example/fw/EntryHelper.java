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
		click(By.name("submit"));
	}

	public void fillEntryForm(FillEntryFormParameter parameterObject) {	
		if(parameterObject.firstName != null) {
			enterFirstName(parameterObject.firstName);
		}
		
		if(parameterObject.lastName != null) {
			enterLastName(parameterObject.lastName);
		}
		
		if(parameterObject.address != null) {
			enterAdress(parameterObject.address);
		}
		
		if(parameterObject.phones != null) {
			enterPhones(parameterObject.phones);
		}
		
		if(parameterObject.email != null) {
		    enterEmail(parameterObject.email);
		}
		
		if(parameterObject.emailSecond != null) {
			enterSecondEmail(parameterObject.emailSecond);
		}
	    
		if(parameterObject.birthDate != null) {
			enterBirthDate(parameterObject.birthDate);
		}
		if(parameterObject.additInfo != null) {
			enterAdditionalInfo(parameterObject.additInfo);
		}
	    
	}

	public void enterAdditionalInfo(EnterAdditionalInfoParameter parameterObject) {
		if(parameterObject.address != null) {
			enterSecondAdress(parameterObject.address);
		}
		
		if(parameterObject.phone != null) {
			enterSecondPhone(parameterObject.phone);   
		}
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
		if(parameterObject.day != null) {
			selectByText(By.name("bday"),parameterObject.day);
		}
		if(parameterObject.month != null) {
			selectByText(By.name("bmonth"),parameterObject.month);
		}
		if(parameterObject.year != null) {
			type(By.name("byear"), parameterObject.year);
		}
	}

	public void enterEmail(String email) {
	    type(By.name("email"), email);
	}

	public void enterPhones(EnterPhonesParameter parameterObject) {
		if(parameterObject.work != null) {
			enterPhoneWork(parameterObject.work);
		}
		if(parameterObject.mobile != null) {
			enterPhoneMobile(parameterObject.mobile);
		}
		if(parameterObject.home != null) {
			enterPhoneHome(parameterObject.home);
		}
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


	public void submitEntryModification() {
		click(By.name("update"));
		
	}
	
	public void submitEntryDelete() {
	    click(By.xpath("//input[@value='Delete']"));
		
	}

	public void chooseEntryForModification(int index) {
		click(By.xpath("//tr[@name='entry']["+index+"]/td/a/img[@title='Edit']/.."));
	}

}
