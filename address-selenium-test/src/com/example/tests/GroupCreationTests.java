package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	MethodsForMainPage.openMainPage();
	MethodsForMainPage.openGroupsPage();
	MethodsForGroups.initNewGroupCreation();
    GroupData group = new GroupData();
    group.footer="footer 1";
    group.header="header 1";
    group.groupname="group 1";
    MethodsForGroups.fillGroupForm(group);
    MethodsForGroups.submitGroupCreation();
    MethodsForMainPage.returnToGroupsPage();
  }

  @Test
  public void testEmptyGroupCreation() throws Exception {
	MethodsForMainPage.openMainPage();
	MethodsForMainPage.openGroupsPage();
	MethodsForGroups.initNewGroupCreation();
    GroupData group = new GroupData();
    group.footer="";
    group.header="";
    group.groupname="";
    MethodsForGroups.fillGroupForm(group);
    MethodsForGroups.submitGroupCreation();
    MethodsForMainPage.returnToGroupsPage();
  }
}
