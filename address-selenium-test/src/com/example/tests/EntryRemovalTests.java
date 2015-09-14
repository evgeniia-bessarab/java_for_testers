package com.example.tests;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class EntryRemovalTests extends TestsBase {
	  @Test
	  public void deleteEntry() throws Exception {
		    app.navigateTo().mainPage();
		    // save old state
			SortedListOf<FillEntryFormParameter> oldList = app.getEntryHelper().getEntries();
			//action
			Random rnd=new Random();
		 	int index= rnd.nextInt(oldList.size()-1);
			app.getEntryHelper().deleteEntry(index);
		    //save new state
			SortedListOf<FillEntryFormParameter> newList = app.getEntryHelper().getEntries();
		    //compare
			assertThat(newList, equalTo(oldList.without(index)));
		      
	  }

}
