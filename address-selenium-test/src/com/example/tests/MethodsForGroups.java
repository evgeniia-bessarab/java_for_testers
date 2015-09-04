package com.example.tests;

import org.openqa.selenium.By;


public class MethodsForGroups  extends TestsBase {

	protected static void submitGroupCreation() {
	    driver.findElement(By.name("submit")).click();
	}

	protected static void fillGroupForm(GroupData group) {
	    driver.findElement(By.name("group_name")).clear();
	    driver.findElement(By.name("group_name")).sendKeys(group.groupname);
	    driver.findElement(By.name("group_header")).clear();
	    driver.findElement(By.name("group_header")).sendKeys(group.header);
	    driver.findElement(By.name("group_footer")).clear();
	    driver.findElement(By.name("group_footer")).sendKeys(group.footer);
	}

	protected static void initNewGroupCreation() {
	    driver.findElement(By.name("new")).click();
	}

}
