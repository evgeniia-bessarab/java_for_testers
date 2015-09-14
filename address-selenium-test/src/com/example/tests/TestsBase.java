package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

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
		 List<Object[]> list = new ArrayList<Object[]>();
		 
		 for(int i=0; i<5;i++) {
			 GroupData group = new GroupData()
			 .withName(generateRandomString())
			 .withHeader(generateRandomString())
			 .withFooter(generateRandomString());
			 list.add(new Object[]{group});
		 }
		 return list.iterator();
	}
	

	@DataProvider	
	public Iterator<Object[]> randomEntryGenerator() {
		 List<Object[]> list = new ArrayList<Object[]>();
		 
		 for(int i=0; i<1;i++) {
			 EnterBirthDateParameter birthDate=new EnterBirthDateParameter(generateRandomNumberDay(), generateRandomNumberMonth(), generateRandomNumberYear());
			 EnterPhonesParameter phones=new EnterPhonesParameter(generateRandomString(), generateRandomString(), generateRandomString());
			 EnterAdditionalInfoParameter addInfo=new EnterAdditionalInfoParameter(generateRandomString(), generateRandomString());
			 FillEntryFormParameter entry = new FillEntryFormParameter()
			 .withFirstName(generateNonEmptyRandomString())
			 .withLastName(generateNonEmptyRandomString())
			 .withAddress(generateNonEmptyRandomString())
			 .withEmailSecond(generateNonEmptyRandomString())
			 .withEmail(generateNonEmptyRandomString())
			 .withBirthDate(birthDate)			 
			 .withPhones(phones)
			 .withAdditInfo(addInfo);
			 list.add(new Object[]{entry});
		 }
		 return list.iterator();
	}
	protected String generateNonEmptyRandomString() {
		Random rnd =new Random();
		return "test"+rnd.nextInt();
}
	public String generateRandomString() {
			Random rnd =new Random();
			 if(rnd.nextInt(3)==0) {
				   return "";
			 } else {
					 return "test"+rnd.nextInt();
			 }	
	}
	protected String generateRandomNumberDay() {
		Random rnd =new Random();
		return Integer.toString(rnd.nextInt(31));
	}
	public String generateRandomNumberMonth() {
		Random rnd =new Random();
		String[] monthList = new String[] {"January","February","March","April","May","June","July", "August","September","October", "November", "December"};
		int index = rnd.nextInt(11);
		return monthList[index];
	}
	public String generateRandomNumberYear() {
		Random rnd =new Random();
		return Integer.toString(1900+rnd.nextInt(100));
	}

}
