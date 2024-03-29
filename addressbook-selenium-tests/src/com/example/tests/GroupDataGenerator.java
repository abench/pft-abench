package com.example.tests;

import static com.example.fw.RandomDataHelper.getRandomCategory;
import static com.example.fw.RandomDataHelper.getRandomString;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

public class GroupDataGenerator {
	public static void main(String[] args) throws IOException{
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
		List<GroupData> groups = generateRandomGroups(amount);
		if ("csv".equals(format)){
			saveGroupsToCsvFile(groups,file);			
		} 
		else if ("xml".equals(format)){
			saveGroupsToXmlFile(groups,file);
		} 
		else {
			System.out.println("Unknown file format:" +format);
			return;
		}
		
		
	}

	private static void saveGroupsToXmlFile(List<GroupData> groups, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("group", GroupData.class);
		String xml = xstream.toXML(groups);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();		
	}
	
	public static List<GroupData> loadGroupsFromXmlFile(File file){
		XStream xstream = new XStream();
		xstream.alias("group", GroupData.class);
		return (List<GroupData>) xstream.fromXML(file);
	}

	private static void saveGroupsToCsvFile(List<GroupData> groups, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		
		for (GroupData group : groups) {
			writer.write(group.getGroupName()+","+group.getHeader()+","+group.getFooter()+",!"+"\n");
		}
		
		writer.close();
		
	}
	
	public static List<GroupData> loadGroupsFromCsvFile(File file) throws IOException {
		List<GroupData> list = new ArrayList<GroupData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line!=null) {
			String[] part = line.split(",");
			GroupData group = new GroupData()
									.withGroupName(part[0])
									.withHeader(part[1])
									.withFooter(part[2]);
			list.add(group);
			line = bufferedReader.readLine();
		}
		
		bufferedReader.close();
		return list;
	}


	public static List<GroupData> generateRandomGroups(int amount) {
		List<GroupData> list = new ArrayList<GroupData>();
		for (int i=0; i<amount; i++){
			GroupData group = new GroupData()
				.withGroupName(getRandomCategory())
				.withHeader(getRandomString())
				.withFooter(getRandomString());
			list.add(group);			
		}
		return list;
	}

}
