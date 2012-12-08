package com.example.fw;

import java.util.Random;

public class RandomDataHelper extends HelperBase {

	public RandomDataHelper(ApplicationManager manager) {
		super(manager);
	}
	public String getRandomArrayElement(String a[]){
		Random rnd = new Random();
		return a[rnd.nextInt(a.length)];
	}
	public String getRandomFirstName(){
		String firstNameList[]={"Vasja","Petya"};
		return getRandomArrayElement(firstNameList);		
	}
	
	public String getRandomSecondName(){
		String secondNameList[]={"Vasiljev","Petrov","Ivanov"};
		return getRandomArrayElement(secondNameList);		
	}
	
	public String getRandomCity(){
		String cityList[]={"London","New York"};
		return getRandomArrayElement(cityList);		
	}
	public String getRandomStreet(){
		String streetList[]={"Zelenaja","Grushevaja"};
		Random rnd = new Random();
		return streetList[rnd.nextInt(streetList.length)];		
	}
	public String getRandomPhone(){
		String str = "";
		int PhoneLength = 12;
		Random rnd = new Random();
		for (int i = 0; i<PhoneLength; i++){
			str=str+rnd.nextInt(9);
		}
		return str;		
	}
	public String getRandomNumericalString(){
		return null;		
	}
	public String getRandomString(){
		String alphavitArray[]={"q","w","e","r","t","y","u","i","o","p","a","s","d","f",
				"g","h","j","k","l","z","x","c","v","b","n","m",
				"Q","W","E","R","T","Y","U","I","O","P","A","S","D","F","G","H",
				"J","K","L","Z","X","C","V","B","N","M"};
		String str = "";
		Random rnd = new Random();
		int stringLength = rnd.nextInt();
		for (int i=0; i<stringLength;i++){
			str=str+alphavitArray[rnd.nextInt(alphavitArray.length)];
		}
	
		return str;		
	}




	

}
