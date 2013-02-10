package com.example.fw;

import org.openqa.selenium.By;

public class AccountHelper extends WebDriverHelperBase {

	public AccountHelper(ApplicationManager manager) {
		super(manager);
	}

	public void signup(User user) {
		openUrl("/");
		click(By.cssSelector("span.bracket-link"));
		type(By.name("username"), user.login);
		type(By.name("email"),user.email);
		click(By.cssSelector("input.button"));
		
		Message msg = manager.getMailHelper().getNewMail();
		String confirmationLink = extractConfirmationLink(msg);
		openAbsoluteUrl(confirmationLink);
		
		type(By.name("password1"), user.password);
		type(By.name("password2"), user.password);
		click(By.cssSelector("input.button"));
		
		//openUrl("signup_page.php");
		
	}

	public boolean isLogged(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
