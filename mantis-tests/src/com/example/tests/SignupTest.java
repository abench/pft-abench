package com.example.tests;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

import com.example.fw.User;

public class SignupTest extends TestBase{
	
	@Test
	public void newUserShouldSignup(){
		User user = new User()
						.withLogin("testuser1")
						.withPassword("123456")
						.withEmail("testuser1@localhost");
		app.getAccountHelper().signup(user);
		AssertJUnit.assertTrue(app.getAccountHelper().isLogged(user));
	}

}
