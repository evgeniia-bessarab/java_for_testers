package com.example.tests;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.junit.Assert.assertThat;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import static com.example.tests.GroupDataGenerator.loadGroupsFromCsvfile;
import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;
import static org.hamcrest.Matchers.*;

import com.example.utils.SortedListOf;


public class GroupCreationTests extends TestsBase{
	
	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException {
		return wrapGroupsForDataProvider(loadGroupsFromXmlFile(new File("groups.xml"))).iterator();
	}
	
 


  @Test(dataProvider = "groupsFromFile")
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
