package com.example.tests;

import org.testng.annotations.Test;

public class GroupModificationsTests extends TestsBase{
	 @Test
	 public void modifySomeGroup() {
		 app.getNavigationHelper().openMainPage();
	     app.getNavigationHelper().openGroupsPage();
	     app.getGroupHelper().initGroupModification(1);
	     GroupData group=new GroupData();
	     group.groupname="new name";
		app.getGroupHelper().fillGroupForm(group);
	     app.getGroupHelper().submitGroupModification();
	     app.getGroupHelper().returnToGroupsPage();
	     
	 }

}
