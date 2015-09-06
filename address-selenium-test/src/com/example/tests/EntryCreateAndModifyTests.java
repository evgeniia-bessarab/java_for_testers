package com.example.tests;

import org.testng.annotations.Test;

import com.example.fw.ApplicationManager;
public class EntryCreateAndModifyTests extends TestsBase{
  @Test
  public void createNonEmptyEntry() throws Exception {
	app.getNavigationHelper().openMainPage(); 
	app.getNavigationHelper().openEntyCreateModifyPage();

	FillEntryFormParameter entry = new FillEntryFormParameter("", "", "", null, "", "", null, null);
	
    entry.firstName = "Ivan";
    entry.lastName = "Ivanov";
    entry.address = "Russia";
 	
    EnterPhonesParameter allPhones = new EnterPhonesParameter("", "", "");
	entry.phones = allPhones;
	
	entry.email = "test@mail.ru";
	entry.emailSecond = "-";
	
	EnterBirthDateParameter birth = new EnterBirthDateParameter("31","May", "1990");
	entry.birthDate = birth;

    EnterAdditionalInfoParameter addInfo = new EnterAdditionalInfoParameter("USSR","-");
	entry.additInfo = addInfo;
	app.getEntryHelper().fillEntryForm(entry);
	app.getEntryHelper().submitEntryCreation();
    app.getNavigationHelper().returnToMainPage();
  }

}
