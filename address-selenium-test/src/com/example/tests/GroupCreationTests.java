package com.example.tests;


import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import com.example.utils.SortedListOf;


public class GroupCreationTests extends TestsBase{
 
  @Test(dataProvider = "randomValidGroupGenerator")
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
	// save old state
	
	SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
	//actions
	app.getGroupHelper().createGroup(group);

    //save new state
	SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
    //compare
    assertThat(newList, equalTo(oldList.withAdded(group)));
  }

  @Test
  public void testEmptyGroupCreation() throws Exception {
	app.navigateTo().mainPage();
	app.navigateTo().groupsPage();
	// save old state
	SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
	GroupData group = new GroupData("","","");
	//actions
	app.getGroupHelper().initNewGroupCreation();
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
    //save new state
    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
    //compare
    assertThat(newList, equalTo(oldList.withAdded(group)));
    
  }
}
