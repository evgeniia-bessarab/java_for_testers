package com.example.tests;

import org.testng.annotations.Test;

public class EntryRemovalTests extends TestsBase {
	  @Test
	  public void deleteEntry() throws Exception {
		    app.getNavigationHelper().openMainPage();
			app.getEntryHelper().chooseEntryForModification(1);
			app.getEntryHelper().submitEntryDelete();
		    app.getNavigationHelper().returnToMainPage();
		      
	  }

}
