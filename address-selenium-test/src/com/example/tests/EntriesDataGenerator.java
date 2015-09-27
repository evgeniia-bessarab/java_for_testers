package com.example.tests;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class EntriesDataGenerator {
public static void main(String[] args)  throws IOException{
		
		if(args.length < 3) {
			System.out.println("Please. specify parameters: <amount of test sata> <file> <format>");
			return;
		}
		
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		
		if(file.exists()) {
			System.out.println("File exists, please remote it manually: "+file+"\n");
			return;
		}
		List<FillEntryFormParameter> entries = generateRandomEntries(amount);
		if ("csv".equals(format)) {
			saveEntriesToCsvFile(entries, file);
		} else if ("xml".equals(format)) {
			saveEntriesToXmlFile(entries, file);
		} else{
			System.out.println("Unknown format " + format);
			return;
		}
		
	}

	private static void saveEntriesToXmlFile(List<FillEntryFormParameter> entries, File file) throws IOException{
		XStream xstream = new XStream();
		xstream.alias("entry", FillEntryFormParameter.class);
		String xml = xstream.toXML(entries);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();	
	}

	public static List<FillEntryFormParameter> loadEntriesFromXmlFile(File file) throws IOException{
		XStream xstream = new XStream();
		xstream.alias("entry", FillEntryFormParameter.class);
		return (List<FillEntryFormParameter>)xstream.fromXML(file);		
	}

	private static void saveEntriesToCsvFile(List<FillEntryFormParameter> entries, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (FillEntryFormParameter entry : entries) {
			writer.write( entry.getFirstName() + ","+entry.getLastName()+","+entry.getAddress()+","+entry.getEmail()+","+entry.getEmailSecond()+","
		                 +entry.getAdditInfo().address+","+entry.getAdditInfo().phone+","
					     +entry.getBirthDate().day + "," + entry.getBirthDate().month + "," +entry.getBirthDate().year
					     +entry.getPhones().home +"," + entry.getPhones().mobile + "," + entry.getPhones().work+ ",!"+"\n");
		}
		writer.close();
	}

	public static List<FillEntryFormParameter> loadEntriesFromCsvfile(File file) throws IOException {
		List<FillEntryFormParameter> list = new ArrayList<FillEntryFormParameter>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader); 
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] part = line.split(",");
			
			EnterAdditionalInfoParameter addInfo = new EnterAdditionalInfoParameter(part[5],part[6]);
			EnterBirthDateParameter birthDate = new EnterBirthDateParameter(part[7], part[8], part[9]);
			EnterPhonesParameter  phone = new EnterPhonesParameter(part[10], part[11], part[12]);
			FillEntryFormParameter entry = new FillEntryFormParameter()
					.withFirstName(part[0])
					.withLastName(part[1])
					.withAddress(part[2])
					.withEmail(part[3])
					.withEmailSecond(part[4])
					.withAdditInfo(addInfo)
					.withBirthDate(birthDate)
					.withPhones(phone);
			list.add(entry);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
	}

	public static List<FillEntryFormParameter> generateRandomEntries(int amount) {
	     List<FillEntryFormParameter> list = new ArrayList<FillEntryFormParameter>();
		 
		 for(int i=0; i<amount;i++) {
			 EnterBirthDateParameter birthDate=new EnterBirthDateParameter(generateRandomNumberDay(), generateRandomNumberMonth(), generateRandomNumberYear());
			 EnterPhonesParameter phones=new EnterPhonesParameter(generateRandomString(), generateRandomString(), generateNonEmptyRandomString());
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
			 list.add(entry);
		 }
		 return list;
	}
	
	public static String generateRandomString() {
		Random rnd =new Random();
		 if(rnd.nextInt(3)==0) {
			   return "";
		 } else {
				 return "test"+rnd.nextInt();
		 }	
   }
	
	public static String generateNonEmptyRandomString() {
		Random rnd =new Random();
		return "testlklklkl"+rnd.nextInt();
   }

	public static String generateRandomNumberDay() {
		Random rnd =new Random();
		return Integer.toString(rnd.nextInt(31));
	}
	public static String generateRandomNumberMonth() {
		Random rnd =new Random();
		String[] monthList = new String[] {"January","February","March","April","May","June","July", "August","September","October", "November", "December"};
		int index = rnd.nextInt(11);
		return monthList[index];
	}
	public static String generateRandomNumberYear() {
		Random rnd =new Random();
		return Integer.toString(1900+rnd.nextInt(100));
	}	

}
