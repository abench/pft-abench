package com.example.fw;

import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JMenuBarOperator;

public class MenuHelper extends HelpersBase{

	public MenuHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}

	public void pushCreateFolder() {
		
		JMenuBarOperator menu = new JMenuBarOperator(application);
		menu.pushMenuNoBlock("File|New folder...");		
		
	}

}
