package com.example.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class MethodsForEntry extends TestsBase {
	
	protected static void submitEntryCreation() {
		driver.findElement(By.name("submit")).click();
	}

	protected static void fillEntryForm(FillEntryFormParameter parameterObject) {	
		enterFirstName(parameterObject.firstName);
		enterLastName(parameterObject.lastName);
		
		enterAdress(parameterObject.address);
		
		enterPhones(parameterObject.phones);
		
	    enterEmail(parameterObject.email);
	    enterSecondEmail(parameterObject.emailSecond);
	    
	    enterBirthDate(parameterObject.birthDate);
	    
	    enterAdditionalInfo(parameterObject.additInfo);
	    
	}

	
	protected static void openEntyCreateModifyPage() {
		driver.findElement(By.linkText("add new")).click();
	}


	protected static void enterAdditionalInfo(EnterAdditionalInfoParameter parameterObject) {
		enterSecondAdress(parameterObject.address);
		enterSecondPhone(parameterObject.phone);   
	}

	protected static void enterSecondAdress(String address2) {
		driver.findElement(By.name("address2")).clear();
	    driver.findElement(By.name("address2")).sendKeys(address2);
	}
	
	protected static void enterSecondPhone(String phone2) {
		driver.findElement(By.name("phone2")).clear();
	    driver.findElement(By.name("phone2")).sendKeys(phone2);
	}

	
	protected static void enterSecondEmail(String emailSecond) {
		driver.findElement(By.name("email2")).clear();
	    driver.findElement(By.name("email2")).sendKeys(emailSecond);
	}

	
	protected static void enterBirthDate(EnterBirthDateParameter parameterObject) {
		new Select(driver.findElement(By.name("bday"))).selectByVisibleText(parameterObject.day);
	    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(parameterObject.month);
	    driver.findElement(By.name("byear")).clear();
	    driver.findElement(By.name("byear")).sendKeys(parameterObject.year);
	}


	protected static void enterEmail(String email) {
		driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys(email);
	}

	protected static void enterPhones(EnterPhonesParameter parameterObject) {
		enterPhoneWork(parameterObject.work);
		enterPhoneMobile(parameterObject.mobile);
		enterPhoneHome(parameterObject.home);
	}
	
	protected static void enterPhoneWork(String workPhone) {
		driver.findElement(By.name("work")).clear();
	    driver.findElement(By.name("work")).sendKeys(workPhone);
	}

	protected static void enterPhoneMobile(String mobilePhone) {
		driver.findElement(By.name("mobile")).clear();
	    driver.findElement(By.name("mobile")).sendKeys(mobilePhone);
	}

	protected static void enterPhoneHome(String homePhone) {
		driver.findElement(By.name("home")).clear();
	    driver.findElement(By.name("home")).sendKeys(homePhone);
	}

	protected static void enterAdress(String address) {
		driver.findElement(By.name("address")).clear();
	    driver.findElement(By.name("address")).sendKeys(address);
	}

	protected static void enterLastName(String lastname) {
		driver.findElement(By.name("lastname")).clear();
	    driver.findElement(By.name("lastname")).sendKeys(lastname);
	}

	protected static void enterFirstName(String firstname) {
		driver.findElement(By.name("firstname")).clear();
	    driver.findElement(By.name("firstname")).sendKeys(firstname);
	}


}
