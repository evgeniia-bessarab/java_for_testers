package com.example.fw;


import org.openqa.selenium.By;
import com.example.tests.EnterAdditionalInfoParameter;
import com.example.tests.EnterBirthDateParameter;
import com.example.tests.EnterPhonesParameter;
import com.example.tests.FillEntryFormParameter;

import com.example.utils.SortedListOf;

public class EntryHelper  extends HelperBase{

	public EntryHelper(ApplicationManager manager) {
		super(manager);
	}

	private SortedListOf<FillEntryFormParameter> cachedEntries;
	
	private void rebuildCache() {
		cachedEntries = new SortedListOf<FillEntryFormParameter>();
		int numberOfEntries = driver.findElements(By.xpath("//tr[@name='entry']")).size();
		for (int i = 0; i < numberOfEntries; i++) {
			FillEntryFormParameter entry = new FillEntryFormParameter();
			entry.withFirstName(driver.findElement(By.xpath("//tr[@name='entry']["+(i+1)+"]/td[3]")).getText());
			entry.withLastName(driver.findElement(By.xpath("//tr[@name='entry']["+(i+1)+"]/td[2]")).getText());
			entry.withEmail(driver.findElement(By.xpath("//tr[@name='entry']["+(i+1)+"]/td[4]")).getText());
			EnterPhonesParameter  phone = new EnterPhonesParameter("", "", driver.findElement(By.xpath("//tr[@name='entry']["+(i+1)+"]/td[5]")).getText());
			entry.withPhones(phone);
			cachedEntries.add(entry);
		}
	}
	public SortedListOf<FillEntryFormParameter> getEntries() {
		if (cachedEntries == null) {
			rebuildCache();
		}
		return cachedEntries;
	}
	public SortedListOf<FillEntryFormParameter> getEntriesFromPrintPhones(int numberOfEntries) {
		SortedListOf<FillEntryFormParameter> printPhonesEntries = new SortedListOf<FillEntryFormParameter>();

		int numOfFullLines = numberOfEntries / 3;
		int phonesInLastLine = numberOfEntries % 3;
		
		for (int i = 0; i <numOfFullLines; i++) {    
			for (int j = 0; j <3; j++) { 
			  String allText = driver.findElement(By.xpath("//tbody/tr["+(i+1)+"]/td[@valign='top']["+(j+1)+"]")).getText();
			  String[] listData = allText.split("\\n");
			  listData[0] = listData[0].replaceAll("[:]", "");
			  String[] listName = listData[0].split("\\s+");
			  String firstName=listName[0];
			  String lastName=listName[1];
			  String homePhone="";
			  if(listData[1].matches("H:\\s\\S*")) {
				  homePhone = listData[1].replaceAll("[H:\\s]", "");
			  }
			  
			  FillEntryFormParameter entry = new FillEntryFormParameter();
			  entry.withFirstName(firstName);
			  entry.withLastName(lastName);
			  EnterPhonesParameter  phone = new EnterPhonesParameter("", "", homePhone);
			  entry.withPhones(phone);
			  printPhonesEntries.add(entry);
			}
		}
		if(phonesInLastLine > 0 ) {
			for (int i = 0; i < phonesInLastLine; i++) { 

			  String allText = driver.findElement(By.xpath("//tbody/tr["+(numOfFullLines+1)+"]/td[@valign='top']["+(i+1)+"]")).getText();
			  String[] listData = allText.split("\\n");
			  listData[0] = listData[0].replaceAll("[:]", "");
			  String[] listName = listData[0].split("\\s+");
			  String firstName=listName[0];
			  String lastName=listName[1];
			  String homePhone="";
			  if(listData[1].matches("H:\\s\\S*")) {
				  homePhone = listData[1].replaceAll("[H:\\s]", "");
			  }
			  
			  FillEntryFormParameter entry = new FillEntryFormParameter();
			  entry.withFirstName(firstName);
			  entry.withLastName(lastName);
			  EnterPhonesParameter  phone = new EnterPhonesParameter("", "", homePhone);
			  entry.withPhones(phone);
			  printPhonesEntries.add(entry);
			}
		}
		System.out.println(printPhonesEntries);
		return  printPhonesEntries;
	}
	
	public int getNumberPrintPhones() {
		int numberOfEntries = driver.findElements(By.xpath("//td[@valign='top' and contains(.,'Birthday:')]")).size();
		return numberOfEntries;
	}
	
	public EntryHelper createEntry(FillEntryFormParameter entry) {
		  manager.navigateTo().openEntyCreateModifyPage();  
		  fillEntryForm(entry);
		  submitEntryCreation();
		  manager.navigateTo().returnToMainPage();
		  rebuildCache();
		  return this;
		
	}
	
	public EntryHelper modifyEntry(int index, FillEntryFormParameter entry) {
		chooseEntryForModification(index);
		fillEntryForm(entry);
		submitEntryModification();
	    manager.navigateTo().returnToMainPage();	
	    rebuildCache();
	    return this;
	}
	

	public EntryHelper deleteEntry(int index) {
		chooseEntryForModification(index);
		submitEntryDelete();
	    manager.navigateTo().returnToMainPage();
	    rebuildCache();
	    return this;
		
	}
	
	public EntryHelper submitEntryCreation() {
		click(By.name("submit"));
		cachedEntries = null;
		return this;
	}

	public EntryHelper fillEntryForm(FillEntryFormParameter parameterObject) {	
		if(parameterObject.getFirstName() != null) {
			enterFirstName(parameterObject.getFirstName());
		}
		
		if(parameterObject.getLastName() != null) {
			enterLastName(parameterObject.getLastName());
		}
		
		if(parameterObject.getAddress() != null) {
			enterAdress(parameterObject.getAddress());
		}
		
		if(parameterObject.getPhones() != null) {
			enterPhones(parameterObject.getPhones());
		}
		
		if(parameterObject.getEmail() != null) {
		    enterEmail(parameterObject.getEmail());
		}
		
		if(parameterObject.getEmailSecond() != null) {
			enterSecondEmail(parameterObject.getEmailSecond());
		}
	    
		if(parameterObject.getBirthDate() != null) {
			enterBirthDate(parameterObject.getBirthDate());
		}
		if(parameterObject.getAdditInfo() != null) {
			enterAdditionalInfo(parameterObject.getAdditInfo());
		}
		return this;
	}

	public EntryHelper enterAdditionalInfo(EnterAdditionalInfoParameter parameterObject) {
		if(parameterObject.address != null) {
			enterSecondAdress(parameterObject.address);
		}
		
		if(parameterObject.phone != null) {
			enterSecondPhone(parameterObject.phone);   
		}
		return this;
	}

	public EntryHelper enterSecondAdress(String address2) {
		type(By.name("address2"), address2);
		return this;
	}

	public EntryHelper enterSecondPhone(String phone2) {
		type(By.name("phone2"), phone2);
		return this;
	}

	public EntryHelper enterSecondEmail(String emailSecond) {
		type(By.name("email2"), emailSecond);
		return this;
	}

	public EntryHelper enterBirthDate(EnterBirthDateParameter parameterObject) {
		if(parameterObject.day != null) {
			selectByText(By.name("bday"),parameterObject.day);
		}
		if(parameterObject.month != null) {
			selectByText(By.name("bmonth"),parameterObject.month);
		}
		if(parameterObject.year != null) {
			type(By.name("byear"), parameterObject.year);
		}
		return this;
	}

	public EntryHelper enterEmail(String email) {
	    type(By.name("email"), email);
	    return this;
	}

	public EntryHelper enterPhones(EnterPhonesParameter parameterObject) {
		if(parameterObject.work != null) {
			enterPhoneWork(parameterObject.work);
		}
		if(parameterObject.mobile != null) {
			enterPhoneMobile(parameterObject.mobile);
		}
		if(parameterObject.home != null) {
			enterPhoneHome(parameterObject.home);
		}
		return this;
	}

	public EntryHelper enterPhoneWork(String workPhone) {
	    type(By.name("work"), workPhone);
	    return this;
	}

	public EntryHelper enterPhoneHome(String homePhone) {
	    type(By.name("home"), homePhone);
	    return this;
	}

	public EntryHelper enterPhoneMobile(String mobilePhone) {
	    type(By.name("mobile"), mobilePhone);
	    return this;
	}

	public EntryHelper enterAdress(String address) {
	    type(By.name("address"), address);
	    return this;
	}

	public EntryHelper enterLastName(String lastname) {
	    type(By.name("lastname"), lastname);
	    return this;
	}

	public EntryHelper enterFirstName(String firstname) {
	    type(By.name("firstname"), firstname);
	    return this;
	}


	public EntryHelper submitEntryModification() {
		click(By.name("update"));
		cachedEntries = null;
		return this;		
	}
	
	public EntryHelper submitEntryDelete() {
	    click(By.xpath("//input[@value='Delete']"));
	    cachedEntries = null;
	    return this;
		
	}

	public EntryHelper chooseEntryForModification(int index) {
		click(By.xpath("//tr[@name='entry']["+(index+1)+"]/td/a/img[@title='Edit']/.."));
		return this;
	}



	public int getSearchCount() {
		int searchCount = Integer.parseInt(driver.findElement(By.id("search_count")).getText());
		return searchCount;	
	}


}
