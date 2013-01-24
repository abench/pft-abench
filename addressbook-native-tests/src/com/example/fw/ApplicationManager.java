package com.example.fw;

import java.util.Properties;


public class ApplicationManager {
	private Properties properties;
//	private FolderHelper folderHelper;

//	private MenuHelper menuHelper;
	
	
	public ApplicationManager(Properties properties){
		
		this.properties = properties;

	}

	
	
	public void stop() {
//		getApplication().requestClose();
		
	
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

