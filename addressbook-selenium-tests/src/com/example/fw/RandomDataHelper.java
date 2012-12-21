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
		String cityList[]={"London","New York",""};
		return getRandomArrayElement(cityList);		
	}
	public String getRandomStreet(){
		String streetList[]={"Zelenaja","Grushevaja",""};
		Random rnd = new Random();
		return streetList[rnd.nextInt(streetList.length)];		
	}
	
	public String getRandomCategory(){
		String categoryList[] = {"Best people","Friends","Family","Colegues","Other","Work",""};
		Random rnd = new Random();
		return categoryList[rnd.nextInt(categoryList.length)];
	}
	
	public String getRandomDay(){
		String categoryList[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		Random rnd = new Random();
		return categoryList[rnd.nextInt(categoryList.length)];
	}
	
	public String getRandomMonth(){
		String categoryList[] = {"Jabuary","February","March","April","May","June","July","August","September","October","November","December"};
		Random rnd = new Random();
		return categoryList[rnd.nextInt(categoryList.length)];
	}
	
	public String getRandomPhone(){
		return getRandomNumericalString(12);		
	}
	public String getRandomNumericalString(int bound){
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
	public String getRandomString(){
		String alphavitArray[]={"q","w","e","r","t","y","u","i","o","p","a","s","d","f",
				"g","h","j","k","l","z","x","c","v","b","n","m",
				"Q","W","E","R","T","Y","U","I","O","P","A","S","D","F","G","H",
				"J","K","L","Z","X","C","V","B","N","M"};
		String str = "";
		Random rnd = new Random();
		if (rnd.nextInt(10)!=0){
			int stringLength = rnd.nextInt();
			for (int i=0; i<stringLength;i++){
				str=str+alphavitArray[rnd.nextInt(alphavitArray.length)];
			}			
		}	
		return str;		
	}




	

}
