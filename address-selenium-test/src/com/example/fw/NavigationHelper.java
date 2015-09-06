package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase{

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void returnToMainPage() {
		click(By.linkText("home page"));
		
	}

	public void openMainPage() {
		driver.get(manager.baseUrl + "/addressbookv4.1.4/");
	}

	public void openGroupsPage() {
		click(By.linkText("groups"));
	}

	public void openEntyCreateModifyPage() {
		click(By.linkText("add new"));
	}

}
