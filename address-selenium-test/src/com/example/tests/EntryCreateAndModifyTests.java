package com.example.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Collections;
import java.util.List;


public class EntryCreateAndModifyTests extends TestsBase{
  @Test(dataProvider = "randomEntryGenerator")
  public void testEntryCreationWithValidData(FillEntryFormParameter entry) throws Exception {
	  app.getNavigationHelper().openMainPage(); 
		// save old state
	  List<FillEntryFormParameter> oldList = app.getEntryHelper().getEntries();
	  app.getNavigationHelper().openEntyCreateModifyPage();
	  //actions
	  app.getEntryHelper().fillEntryForm(entry);
	  app.getEntryHelper().submitEntryCreation();
	  app.getNavigationHelper().returnToMainPage();
	  //save new state
	  List<FillEntryFormParameter> newList = app.getEntryHelper().getEntries();
	  //compare
	  oldList.add(entry);
	  Collections.sort(oldList);
	  Collections.sort(newList);
	  AssertJUnit.assertEquals(newList, oldList);
  }
 
  @Test
  public void modifyEntry() throws Exception {
		app.getNavigationHelper().openMainPage();
		// save old state
		List<FillEntryFormParameter> oldList = app.getEntryHelper().getEntries();
		//actions
		app.getEntryHelper().chooseEntryForModification(0);
		FillEntryFormParameter entry = new FillEntryFormParameter();
	    entry.firstName = "Vasya";
	    entry.lastName= "Pupkin";
		app.getEntryHelper().fillEntryForm(entry);
		app.getEntryHelper().submitEntryModification();
	    app.getNavigationHelper().returnToMainPage();
	    //save new state
	    List<FillEntryFormParameter> newList = app.getEntryHelper().getEntries();
	    //compare
	    oldList.remove(0);
	    oldList.add(entry);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    AssertJUnit.assertEquals(newList, oldList);  
	}
  
    @Test
    public void compareSearchCountAndEntriesCount () {
    	app.getNavigationHelper().openMainPage(); 
    	AssertJUnit.assertEquals(app.getEntryHelper().getSearchCount(), app.getEntryHelper().getEntries().size());
    }

}
