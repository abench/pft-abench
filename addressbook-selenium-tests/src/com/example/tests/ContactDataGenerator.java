package com.example.tests;

import static com.example.fw.RandomDataHelper.getRandomAddress;
import static com.example.fw.RandomDataHelper.getRandomDay;
import static com.example.fw.RandomDataHelper.getRandomEmail;
import static com.example.fw.RandomDataHelper.getRandomFirstName;
import static com.example.fw.RandomDataHelper.getRandomMonth;
import static com.example.fw.RandomDataHelper.getRandomPhone;
import static com.example.fw.RandomDataHelper.getRandomSecondName;
import static com.example.fw.RandomDataHelper.getRandomNumericalString;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length<3){
			System.out.println("Please specify parameters:<amount of test data> <file> <format> ");
			return;
		}
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		if (file.exists()){
			System.out.println("File " + file + " exist. Please, remove it manually.");
			return;			
		}
		List<ContactData> contacts = generateRandomContacts(amount);
		if ("csv".equals(format)){
			saveContactsToCsvFile(contacts,file);			
		} 
		
		else if ("xml".equals(format)){
			saveContactsToXmlFile(contacts,file);
		} 
		else {
			System.out.println("Unknown file format:" +format);
			return;
		}



	}

	public static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
		// TODO Auto-generated method stub
		
		
	}
	
	public static List<ContactData> loadContactsFromXmlFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		return list;
		
	}

	public static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
		// TODO Auto-generated method stub
		FileWriter writer = new FileWriter(file);
		
		for (ContactData contact : contacts) {
			writer.write(contact.getFirstname()+","+
						contact.getLastname()+","+
					    contact.getAddress()+","+
						contact.getPhoneHome()+","+
					    contact.getPhoneMobile()+","+
						contact.getPhoneWork()+","+
					    contact.getEmail()+","+
						contact.getEmail2()+","+
					    contact.getBirthDay()+","+
						contact.getBirthMonth()+","+
					    contact.getBirthYear()+","+",!"+"\n");
//			.withEmail(getRandomEmail(randomFirstname))
//			.withEmail2(getRandomEmail(randomFirstname))
//			.withBirthDay(getRandomDay())
//			.withBirthMonth(getRandomMonth())
//			.withAddress(getRandomAddress())
//			.withHome2(getRandomAddress()));			

		}
		
		writer.close();

	}
	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		return list;
	}

	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		for (int i=0; i<amount; i++){
			String randomFirstname = getRandomFirstName();
			list.add( new ContactData()
				.withFirstname(randomFirstname)
				.withLastname(getRandomSecondName())
				.withAddress(getRandomAddress())
				.withPhoneHome(getRandomPhone())
				.withPhoneMobile(getRandomPhone())
				.withPhoneWork(getRandomPhone())
				.withEmail(getRandomEmail(randomFirstname))
				.withEmail2(getRandomEmail(randomFirstname))
				.withBirthDay(getRandomDay())
				.withBirthMonth(getRandomMonth())
				.withBirthYear(getRandomNumericalString(4))
				.withHome2(getRandomAddress()));			
		}
		
		return list;
	}

}
