package com.example.tests;

import com.example.utils.SortedListOf;

import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import static org.hamcrest.Matchers.*;

public class checkPrintPhones extends TestsBase{
  
  @Test
  public void printPhones() throws Exception {
	  app.navigateTo().mainPage();
		// save old state
	  SortedListOf<FillEntryFormParameter> mainPageList = app.getEntryHelper().getEntries();
	  //actions
	 
	  int countPhonesOnMainPage = app.getEntryHelper().getSearchCount();
	  app.navigateTo().printPhonesPage();
	  int countPhonesOnPrintPhonesPage = app.getEntryHelper().getNumberPrintPhones();
	  
	  AssertJUnit.assertEquals(countPhonesOnMainPage, countPhonesOnPrintPhonesPage);
	  
	  //save new state
	  SortedListOf<FillEntryFormParameter> printPhonesPageList = app.getEntryHelper().getEntriesFromPrintPhones(countPhonesOnPrintPhonesPage);
	  //compare
	  assertThat(mainPageList, equalTo(printPhonesPageList));
  }


}
