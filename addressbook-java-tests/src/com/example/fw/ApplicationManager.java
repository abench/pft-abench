package com.example.fw;

import java.util.Properties;

import org.netbeans.jemmy.ClassReference;
import org.netbeans.jemmy.operators.JFrameOperator;


public class ApplicationManager {
	private Properties properties;
	private FolderHelper folderHelper;
	private JFrameOperator mainFrame;
	
	
	public ApplicationManager(Properties properties){
		
		this.properties = properties;

	}

	
	
	public void stop() {
	
	}
	public JFrameOperator getApplication(){
		if (mainFrame == null){
			try {
				new ClassReference("addressbook.AddressBookFrame").startApplication();
				mainFrame = new JFrameOperator("jAddressBook");
				
			} catch (Exception e) {
				e.printStackTrace();			
			}


		}
		return mainFrame;
	}


	public FolderHelper getFolderHelper() {
		if (folderHelper == null){
			folderHelper = new FolderHelper(this);
		}
		return null;
	}
	
}

