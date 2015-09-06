package com.example.tests;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestsBase{
 @Test
 public void DeleteSomeGroup() {
	 app.getNavigationHelper().openMainPage();
     app.getNavigationHelper().openGroupsPage();
     app.getGroupHelper().deleteGroup(1);
     app.getGroupHelper().returnToGroupsPage();
     
 }
}
