package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupModificationsTests extends TestsBase{
	@Test(dataProvider = "randomValidGroupGenerator")
	 public void modifySomeGroup(GroupData group) {
		 app.navigateTo().mainPage();
	     app.navigateTo().groupsPage();
	     // save old state
	    SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
	  	
	 	Random rnd=new Random();
	 	int index= rnd.nextInt(oldList.size()-1);
	 	
	  	//actions
	     app.getGroupHelper().modifyGroup(index,group);
	     //save new state
	     SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
	     //compare
	     //oldList.remove(index);
	     //oldList.add(group);
	     //Assert.assertEquals(newList, oldList);
	     assertThat(oldList, equalTo(newList.without(index).withAdded(group)));
	     
	 }

}
