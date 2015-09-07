package com.example.tests;


import org.testng.AssertJUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestsBase{
 
  @Test(dataProvider = "randomValidGroupGenerator")
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
	app.getNavigationHelper().openMainPage();
	app.getNavigationHelper().openGroupsPage();
	// save old state
	List<GroupData> oldList = app.getGroupHelper().getGroups();
	//actions
	app.getGroupHelper().initNewGroupCreation();
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
    //save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
    //compare
    oldList.add(group);
    Collections.sort(oldList);
    AssertJUnit.assertEquals(newList, oldList);
  }

  @Test
  public void testEmptyGroupCreation(GroupData group) throws Exception {
	app.getNavigationHelper().openMainPage();
	app.getNavigationHelper().openGroupsPage();
	// save old state
	List<GroupData> oldList = app.getGroupHelper().getGroups();
	//actions
	app.getGroupHelper().initNewGroupCreation();
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
    //save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
    //compare
    oldList.add(group);
    Collections.sort(oldList);
    AssertJUnit.assertEquals(newList, oldList);
    
  }
}
