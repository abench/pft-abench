package com.example.fw;

import java.io.IOException;


public class ProcessHelper extends HelpersBase {

	private Process exec;

	public ProcessHelper(ApplicationManager manager) {
		super(manager);
	}
	
	public void startAppUnderTest() throws IOException{
		String command = manager.getProperty("app.path");
		exec = Runtime.getRuntime().exec(command);
		
	}
	
	public void stopAppUnderTest() throws IOException{
		exec.destroy();
	}

}
