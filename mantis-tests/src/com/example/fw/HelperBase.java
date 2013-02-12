package com.example.fw;

public class HelperBase {
	protected ApplicationManager manager;
	public HelperBase(ApplicationManager manager){
		this.manager = manager;
//		this.driver = manager.driver;
	}
	public void pause(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}	
	

}
