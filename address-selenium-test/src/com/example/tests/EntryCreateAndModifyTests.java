package com.example.tests;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

import org.testng.AssertJUnit;
import java.util.Random;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class EntryCreateAndModifyTests extends TestsBase{
  @Test(dataProvider = "randomEntryGenerator")
  public void testEntryCreationWithValidData(FillEntryFormParameter entry) throws Exception {
	  
		// save old state
	  SortedListOf<FillEntryFormParameter> oldList = app.getEntryHelper().getEntries();
	  //actions
	  app.getEntryHelper().createEntry(entry);
	  //save new state
	  SortedListOf<FillEntryFormParameter> newList = app.getEntryHelper().getEntries();
	  //compare
	  assertThat(newList, equalTo(oldList.withAdded(entry)));
  }

  @Test(dataProvider = "randomEntryGenerator")
  public void modifyEntry(FillEntryFormParameter entry) throws Exception {
		app.navigateTo().mainPage();
		// save old state
		SortedListOf<FillEntryFormParameter> oldList = app.getEntryHelper().getEntries();
		//actions
		Random rnd=new Random();
	 	int index= rnd.nextInt(oldList.size()-1);
	 	
		app.getEntryHelper().modifyEntry(index,entry);
	    //save new state
		SortedListOf<FillEntryFormParameter> newList = app.getEntryHelper().getEntries();
	    //compare
	     assertThat(newList, equalTo(oldList.without(index).withAdded(entry)));
	}
  
    @Test
    public void compareSearchCountAndEntriesCount () {
    	app.navigateTo().mainPage(); 
    	AssertJUnit.assertEquals(app.getEntryHelper().getSearchCount(), app.getEntryHelper().getEntries().size());
    }

}
