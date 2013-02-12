package com.example.tests;

import static org.testng.Assert.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.example.fw.User;

public class SignupTest extends TestBase{
	public 		User user = new User()
							.withLogin("testuser1")
							.withPassword("123456")
							.withEmail("testuser1@localhost");
	@BeforeClass
	public void createMailUser(){
		if (!app.getJamesHelper().doesUserExist(user.login)){
			app.getJamesHelper().createUser(user.login, user.password);
		}				
	}
	
	@AfterClass
	public void deleteMailUser(){
		if (app.getJamesHelper().doesUserExist(user.login)){
			app.getJamesHelper().deleteUser(user.login);			
		}				
	}
	
	@Test
	public void newUserShouldSignup(){
		app.getAccountHelper().signup(user);
		app.getAccountHelper().login(user);
		assertTrue(app.getAccountHelper().isLogged(user));
	}

}
