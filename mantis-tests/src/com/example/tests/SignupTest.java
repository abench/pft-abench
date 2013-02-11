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
	public void createUser(){
		app.getJamesHelper().createUser(user);		
	}
	
	@AfterClass
	public void createUser(){
		app.getJamesHelper().createUser(user);		
	}
	
	@Test
	public void newUserShouldSignup(){
		app.getAccountHelper().signup(user);
		assertTrue(app.getAccountHelper().isLogged(user));
	}

}
