package com.example.fw;

import java.util.Properties;


public class ApplicationManager {
	private Properties properties;
//	private FolderHelper folderHelper;
	private ContactHelper contactHelper;

//	private MenuHelper menuHelper;
	
	
	public ApplicationManager(Properties properties){
		
		this.properties = properties;

	}

	
	
	public void stop() {
//		getApplication().requestClose();
		
	
	}



	public ContactHelper getContactHelper() {
		if (contactHelper == null){
		contactHelper = new ContactHelper(this);
	}
	return contactHelper;
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

