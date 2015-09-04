package com.example.tests;


import org.openqa.selenium.By;

public class MethodsForMainPage extends TestsBase {
	
	protected static void returnToGroupsPage() {
	    driver.findElement(By.linkText("group page")).click();
	}

	protected static void openGroupsPage() {
	    driver.findElement(By.linkText("groups")).click();
	}

	protected static void openMainPage() {
	    driver.get(baseUrl + "/addressbookv4.1.4/");
	}
	
	protected static void returnToMainPage() {
		driver.findElement(By.linkText("home page")).click();
	}
	
}
