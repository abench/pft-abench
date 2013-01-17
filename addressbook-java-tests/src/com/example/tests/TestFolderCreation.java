package com.example.tests;

import org.testng.annotations.Test;

public class TestFolderCreation extends TestBase {
	@Test
	public void testFolderCreation(){
		String folder = "new folder";
		Folders oldFolders = app.getFolderHelper().getFolders();
		app.getFolderHelper().createFolder("new folder");
		Folders newFolders = app.getFolderHelper().getFolders();
		assertThat(newFolders, equalTo(oldFolders.withAdded(folder)));
		
	}

}
