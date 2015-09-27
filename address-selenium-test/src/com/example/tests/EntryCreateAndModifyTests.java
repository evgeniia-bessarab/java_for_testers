package com.example.tests;

import com.example.utils.SortedListOf;

import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import static com.example.tests.EntriesDataGenerator.loadEntriesFromXmlFile;
import static org.hamcrest.Matchers.*;

public class EntryCreateAndModifyTests extends TestsBase{
	@DataProvider
	public Iterator<Object[]> entriesFromFile() throws IOException {
		return wrapEntriesForDataProvider(loadEntriesFromXmlFile(new File("entries.xml"))).iterator();
	}
	
	
    @Test
    public void compareSearchCountAndEntriesCount () {
    	app.navigateTo().mainPage(); 
    	AssertJUnit.assertEquals(app.getEntryHelper().getSearchCount(), app.getEntryHelper().getEntries().size());
    	
    }
	
  @Test(dataProvider = "entriesFromFile")
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

   @Test(dataProvider = "entriesFromFile")
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
