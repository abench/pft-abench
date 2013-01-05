package com.example.tests;

import static com.example.fw.RandomDataHelper.getRandomCategory;
import static com.example.fw.RandomDataHelper.getRandomString;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
			System.out.println("Please specify parameters:<amount of test data> <file> <format> ");
			return;			
		}
		List<GroupData> groups = generateRandomGroups(amount);
		if ("csv".equals(format)){
			System.out.println("Start writing csv file");
			saveGroupsToCsvFile(groups,file);
			System.out.println("Writing complete.");
		} 
		else if ("xml".equals(format)){
			saveGroupsToXmlFile(groups,file);
		} 
		else {
			System.out.println("Unknown file format:" +format);
			return;
		}
		
		
	}

	private static void saveGroupsToXmlFile(List<GroupData> groups, File file) {
		
	}

	private static void saveGroupsToCsvFile(List<GroupData> groups, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		
		for (GroupData group : groups) {
			writer.write(group.getGroupName()+","+group.getHeader()+","+group.getFooter()+"\n");
		}
		
		writer.close();
		
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
