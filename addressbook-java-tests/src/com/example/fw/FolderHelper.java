package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JLabel;

import org.netbeans.jemmy.operators.JButtonOperator;
import org.netbeans.jemmy.operators.JDialogOperator;
import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JLabelOperator;
import org.netbeans.jemmy.operators.JTextFieldOperator;
import org.netbeans.jemmy.operators.JTreeOperator;




public class FolderHelper extends HelpersBase{

	public FolderHelper(ApplicationManager manager){
		super (manager); 
		
	}
	
	public Folders getFolders() {
		List<String> list = new ArrayList<String>();
		JFrameOperator mainFrame=application;
		JTreeOperator tree = new JTreeOperator(mainFrame);
		Object[] children = tree.getChildren(tree.getRoot());
		for (Object child : children) {
			list.add(""+child);
			
		}		
		return new Folders(list) ;
	}
	

	public String createFolder(String folderName) {
		manager.getMenuHelper().pushCreateFolder();
		JDialogOperator dialog = new JDialogOperator(application);
		new JTextFieldOperator(dialog).setText(folderName);
		new JButtonOperator(dialog,"OK").push();
		return waitMessageDialog("Warning", 3000);
		
	}


}
