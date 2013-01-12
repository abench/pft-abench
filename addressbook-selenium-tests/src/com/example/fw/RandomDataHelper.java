package com.example.fw;

import java.util.Random;

public class RandomDataHelper{

//	public RandomDataHelper(ApplicationManager manager) {
//		super(manager);
//	}
	public static String getRandomArrayElement(String a[]){
		Random rnd = new Random();
		return a[rnd.nextInt(a.length)];
	}
	public static String getRandomFirstName(){
		String firstNameList[]={"Vasja","Petya"};
		return getRandomArrayElement(firstNameList);		
	}
	
	public static String getRandomSecondName(){
		String secondNameList[]={"Vasiljev","Petrov","Ivanov"};
		return getRandomArrayElement(secondNameList);		
	}
	
	public static String getRandomCity(){
		String cityList[]={"London","New York",""};
		return getRandomArrayElement(cityList);		
	}
	public static String getRandomStreet(){
		String streetList[]={"Zelenaja","Grushevaja",""};
		return getRandomArrayElement(streetList);		
	}
	
	public static String getRandomCategory(){
		String categoryList[] = {"Best people","Friends","Family","Colegues","Other","Work",""};
		return getRandomArrayElement(categoryList);
	}
	
	public static String getRandomDay(){
		String daysList[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		return getRandomArrayElement(daysList);
	}
	
	public static String getRandomMonth(){
		String monthList[] = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		return getRandomArrayElement(monthList);
	}
	
	public static String getRandomPhone(){
		return getRandomNumericalString(12);		
	}
	public static String getRandomNumericalString(int bound){
		String str="";
		Random rnd= new Random();
		if (rnd.nextInt(10)!=0){
			int stringLength = rnd.nextInt(bound);
			for (int i=0;i<stringLength;i++){
				str=str+rnd.nextInt(9);
			}			
		}
		return str;		
	}
	public static String getRandomString(){
		String alphavitArray[]={"q","w","e","r","t","y","u","i","o","p","a","s","d","f",
				"g","h","j","k","l","z","x","c","v","b","n","m",
				"Q","W","E","R","T","Y","U","I","O","P","A","S","D","F","G","H",
				"J","K","L","Z","X","C","V","B","N","M"};
		String str = "";
		int stringBound = 200;
		Random rnd = new Random();
		if (rnd.nextInt(10)!=0){
			int stringLength = rnd.nextInt(stringBound);
			for (int i=0; i<stringLength;i++){
				str=str+alphavitArray[rnd.nextInt(alphavitArray.length)];
			}			
		}	
		return str;
		
		
	}
	public static String getRandomAddress(){
		return getRandomCity() + " " + getRandomStreet() + " " + getRandomNumericalString(3);
	}
	public static String getRandomEmail(String userName){
		String emailProvidersList[] = {"mail.ru","google.com","yandex.ru","mailinator.com","","anonymous.org"};
		return userName+getRandomNumericalString(3)+"@"+getRandomArrayElement(emailProvidersList);
		
		
	}





	

}
