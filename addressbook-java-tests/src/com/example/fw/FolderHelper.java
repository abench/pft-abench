package com.example.fw;

import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JTreeOperator;

import com.example.tests.Folders;

public class FolderHelper {

	private ApplicationManager manager;

	public FolderHelper(ApplicationManager manager) {
		this.manager = manager;
		
	}

	public Folders getFolders() {
		
		JFrameOperator mainFrame=manager.getApplication();
		JTreeOperator tree = new JTreeOperator(mainFrame);
		Object[] children = tree.getChildren(tree.getRoot());
		for (Object child : children) {
			
		}
		
		
		
		return null;
	}
	

	public void createFolder(String string) {
		// TODO Auto-generated method stub
		
	}

}
