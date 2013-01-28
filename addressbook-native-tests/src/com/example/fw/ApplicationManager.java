package com.example.fw;

import java.io.IOException;
import java.util.Properties;


public class ApplicationManager {
	private static ApplicationManager singleton;
	private Properties properties;
//	private FolderHelper folderHelper;
	private ContactHelper contactHelper;
	private ProcessHelper processHelper;
	private AutoItHelper autoItHelper;
	private static int delayTime = 5000;
	

//	private MenuHelper menuHelper;
	
	
//	public ApplicationManager(Properties properties){
//		
//		this.properties = properties;
//
//	}

	public static ApplicationManager getInstance(Properties properties) throws IOException{
		if (singleton==null){
			singleton =  new ApplicationManager();
			singleton.setProperties(properties);
			singleton.start();
			
			
			// Delay to wait on application start
			// Start is slow, because I am running it on virtual machine
			
			delay();
		}
		return singleton;
		
	}

	public static void delay() {
		try {			
			Thread.sleep(delayTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void start() throws IOException {
		getProcessHelper().startAppUnderTest();
		
	}

	public void stop() throws IOException {
//		getApplication().requestClose();
		getProcessHelper().stopAppUnderTest();	
	}


	public ContactHelper getContactHelper() {
		if (contactHelper == null){
		contactHelper = new ContactHelper(this);
	}
	return contactHelper;
	}

	public ProcessHelper getProcessHelper() {
		if (processHelper == null){
			processHelper = new ProcessHelper(this);
	}
	return processHelper;
	}

	public AutoItHelper getAutoItHelper() {
		if (autoItHelper == null){
			autoItHelper = new AutoItHelper(this);
	}
	return autoItHelper;
	}

	
	public void setProperties(Properties props){
		this.properties = props;
	}
	public String getProperty(String property) {
		return properties.getProperty(property);
	}




//	public FolderHelper getFolderHelper() {
//		if (folderHelper == null){
//			folderHelper = new FolderHelper(this);
//		}
//		return folderHelper;
//	}
//
//
//
//	public MenuHelper getMenuHelper() {
//		if (menuHelper == null){
//			menuHelper = new MenuHelper(this);
//		}
//		return menuHelper;
//	}
	
}

