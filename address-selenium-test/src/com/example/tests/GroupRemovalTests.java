package com.example.tests;

import java.util.Random;


import org.testng.annotations.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import com.example.utils.SortedListOf;

public class GroupRemovalTests extends TestsBase{
 @Test
 public void DeleteSomeGroup() {
  // save old state
	SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
 	Random rnd=new Random();
 	int index= rnd.nextInt(oldList.size()-1);
 	
 	//actions
     app.getGroupHelper().deleteGroup(index);
     //save new state
     SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
     //compare
     assertThat(newList, equalTo(oldList.without(index)));
     
 }
}
