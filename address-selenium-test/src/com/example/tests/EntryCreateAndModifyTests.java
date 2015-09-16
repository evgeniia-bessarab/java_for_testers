package com.example.tests;

import com.example.utils.SortedListOf;

import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import static org.hamcrest.Matchers.*;

public class EntryCreateAndModifyTests extends TestsBase{

   @Test
    public void compareSearchCountAndEntriesCount () {
    	app.navigateTo().mainPage(); 
    	AssertJUnit.assertEquals(app.getEntryHelper().getSearchCount(), app.getEntryHelper().getEntries().size());
    	
    }
	
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
	 	System.out.println(oldList.size());
	 	if (oldList.size()>0) {
	 	  int index;
	 	
	 	  if (oldList.size()==1){
	 		index=0;
	 	  }
	 	  else {
		   	index= rnd.nextInt(oldList.size()-1);
	 	  }

	 	  System.out.println(index);
		  app.getEntryHelper().modifyEntry(index,entry);
	      //save new state
		  SortedListOf<FillEntryFormParameter> newList = app.getEntryHelper().getEntries();
	      //compare
	      assertThat(newList, equalTo(oldList.without(index).withAdded(entry)));
	 	}
	}

}
