package com.example.fw;

import javax.swing.JDialog;

import org.netbeans.jemmy.operators.JDialogOperator;
import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JLabelOperator;

public class HelpersBase {
	protected final ApplicationManager manager;
	protected final JFrameOperator application;

	public  HelpersBase(ApplicationManager manager) {
		this.manager = manager;
		this.application =  manager.getApplication();
		
	}
	protected String waitMessageDialog(String title, int timeout) {
		long start = System.currentTimeMillis();
		long currentTime = start;
		while (currentTime<start+timeout){
			JDialog dialog = JDialogOperator.findJDialog(application.getOwner(), title, false, false);
			if (dialog!= null){
				JDialogOperator dialogOp = new JDialogOperator(dialog);
				String message = new JLabelOperator(dialogOp).getText();
				dialogOp.requestClose();
				return message;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			currentTime = System.currentTimeMillis();
			
		}
		
		return null;
	}



}
