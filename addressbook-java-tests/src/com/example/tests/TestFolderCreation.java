package com.example.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.containsString;

import org.testng.annotations.Test;

import com.example.fw.Folders;
class TestFolderCreation extends TestBase {
	
	@Test
	public void testFolderCreation(){
		String folder = "new folder";
		Folders oldFolders = app.getFolderHelper().getFolders();
		app.getFolderHelper().createFolder(folder);
		Folders newFolders = app.getFolderHelper().getFolders();
		assertThat(newFolders, equalTo(oldFolders.withAdded(folder)));
		
	}

	@Test
	public void testVariousFoldersCreation(){
		String folder1 = "new folder 1";
		String folder2 = "new folder 2";
		Folders oldFolders = app.getFolderHelper().getFolders();
		assertThat(app.getFolderHelper().createFolder(folder1), is(nullValue()));
		Folders newFolders1 = app.getFolderHelper().getFolders();
		assertThat(newFolders1, equalTo(oldFolders.withAdded(folder1)));
		assertThat(app.getFolderHelper().createFolder(folder2),is(nullValue()));
		Folders newFolders2 = app.getFolderHelper().getFolders();
		assertThat(newFolders2, equalTo(newFolders1.withAdded(folder2)));
		
		
	}
	@Test
	public void testWithSameNameCreation(){
		String folder1 = "new folder 3";
		String folder2 = "new folder 3";
		Folders oldFolders = app.getFolderHelper().getFolders();
		assertThat(app.getFolderHelper().createFolder(folder1),is(nullValue()));
		Folders newFolders1 = app.getFolderHelper().getFolders();
		assertThat(newFolders1, equalTo(oldFolders.withAdded(folder1)));
		assertThat(app.getFolderHelper().createFolder(folder2), containsString("Duplicated folder name"));
		Folders newFolders2 = app.getFolderHelper().getFolders();
		assertThat(newFolders2, equalTo(newFolders1.withAdded(folder2)));
		
		
	}

}
