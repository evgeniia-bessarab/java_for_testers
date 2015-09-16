package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase{

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void returnToMainPage() {
		click(By.linkText("home page"));
		
	}

	public void mainPage() {
		if(! onMainPage()){
			click(By.linkText("home"));
		}
	}

	private boolean onMainPage() {
		return (driver.findElements(By.id("maintable")).size() > 0);
	}

	public void groupsPage() {
		if(! onGroupPage()){
			click(By.linkText("groups"));
		}
		
	}

	private boolean onGroupPage() {
		if(driver.getCurrentUrl().contains("/groups.php")
			&& driver.findElements(By.name("new")).size() > 0) {
				return true;
			} else {
				return false;
			}
	}

	public void openEntyCreateModifyPage() {
		if(! onEntryPage()){
			click(By.linkText("add new"));
		}
	}

	private boolean onEntryPage() {
		if(driver.getCurrentUrl().contains("/edit.php")
		   && driver.findElements(By.name("submit")).size() > 0) {
				return true;
			} else {
				return false;
			}
	}

	public void printPhonesPage() {
		click(By.linkText("print phones"));
	}

}
