package com.example.tests;

import java.util.Collections;
import java.util.List;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class EntryRemovalTests extends TestsBase {
	  @Test
	  public void deleteEntry() throws Exception {
		    app.getNavigationHelper().openMainPage();
		    // save old state
			List<FillEntryFormParameter> oldList = app.getEntryHelper().getEntries();
			//action
			app.getEntryHelper().chooseEntryForModification(0);
			app.getEntryHelper().submitEntryDelete();
		    app.getNavigationHelper().returnToMainPage();
		    //save new state
		    List<FillEntryFormParameter> newList = app.getEntryHelper().getEntries();
		    //compare
		    oldList.remove(0);
		    Collections.sort(oldList);
		    AssertJUnit.assertEquals(newList, oldList);
		      
	  }

}
