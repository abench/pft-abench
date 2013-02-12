package com.example.fw;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class ApplicationManager {
	private WebDriver driver;
	public String baseUrl;
	private String alctrMainPage 	= "/addressbookv4.1.4/";	// default value
	private Properties properties;
	private HibernateHelper hibernateHelper;
	private ApplicationModel model;
	private AccountHelper accountHelper;
	private MailHelper mailHelper;
	private JamesHelper jamesHelper;
	
	public ApplicationManager(Properties properties){
		
		this.properties = properties;
		model = new ApplicationModel();
//		model.setGroups(getHibernateHelper().listGroups());
//		model.setContacts(getHibernateHelper().listContacts());
	}
	
	public ApplicationModel getModel(){
		return model;
	}

	
	public HibernateHelper getHibernateHelper() {
		if (hibernateHelper == null) {
			hibernateHelper = new HibernateHelper(this);			
		}
		return hibernateHelper;		
	}

	public AccountHelper getAccountHelper() {
		if (accountHelper == null) {
			accountHelper = new AccountHelper(this);			
		}
		return accountHelper;
	}

	public MailHelper getMailHelper() {
		if (mailHelper == null) {
			mailHelper = new MailHelper(this);			
		}

		return mailHelper;
	}
	
	public JamesHelper getJamesHelper() {
		if (jamesHelper == null) {
			jamesHelper = new JamesHelper(this);			
		}

		return jamesHelper;
	}
	
	public WebDriver getDriver(){
		String browser = properties.getProperty("browser");
		if (driver == null){
		if (browser.equals("firefox")){
			driver = new FirefoxDriver();
		} else if (browser.equals("ie")){
			driver = new InternetExplorerDriver();			
		} else {
			throw new Error("Unsupported browser" + browser);
		}
		
		baseUrl = properties.getProperty("baseURL");//"http://localhost/";
		alctrMainPage = properties.getProperty("firstPage");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl + alctrMainPage);
		}
		return driver;	
	}
	
	public String getProperty(String key){
		return properties.getProperty(key);
	}
	public void stop() {
		driver.quit();		
	}




}
