package com.example.tests;

import org.testng.annotations.Test;
public class EntryCreateAndModifyTests {
  @Test
  public void createNonEmptyEntry() throws Exception {
	MethodsForMainPage.openMainPage(); 
	MethodsForEntry.openEntyCreateModifyPage();

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
    
	MethodsForEntry.fillEntryForm(entry);
	MethodsForEntry.submitEntryCreation();
    MethodsForMainPage.returnToMainPage();
  }

}
