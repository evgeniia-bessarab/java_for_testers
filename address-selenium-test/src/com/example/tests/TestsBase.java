package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import static com.example.tests.GroupDataGenerator.generateRandomGroups;
import static com.example.tests.EntriesDataGenerator.generateRandomEntries;

import com.example.fw.*;

public class TestsBase {
    
	protected ApplicationManager app;


	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();

	  }

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	  }
	
	@DataProvider	
	public Iterator<Object[]> randomValidGroupGenerator() {
		return wrapGroupsForDataProvider(generateRandomGroups(5)).iterator();
	}
	

	public static List<Object[]> wrapGroupsForDataProvider(List<GroupData> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for(GroupData group : groups) {
			list.add(new Object[]{group});
		}
		return list;
	}

	@DataProvider	
	public Iterator<Object[]> randomEntryGenerator() {
		return wrapEntriesForDataProvider(generateRandomEntries(5)).iterator();
	}
	
	public static List<Object[]> wrapEntriesForDataProvider(List<FillEntryFormParameter> entries) {
		List<Object[]> list = new ArrayList<Object[]>();
		for(FillEntryFormParameter entry : entries) {
			list.add(new Object[]{entry});
		}
		return list;
	}

}
