package com.example.fw;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class ApplicationManager {
	private WebDriver driver;
	public String baseUrl;
	private NavigationHelper navigationHelper;
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	private String alctrMainPage 	= "/addressbookv4.1.4/";	// default value
	private Properties properties;
	private HibernateHelper hibernateHelper;
	private ApplicationModel model;
	
	public ApplicationManager(Properties properties){
		
		this.properties = properties;
		model = new ApplicationModel();
		model.setGroups(getHibernateHelper().listGroups());
		model.setContacts(getHibernateHelper().listContacts());
	}
	
	public ApplicationModel getModel(){
		return model;
	}

	public NavigationHelper navigateTo(){
		if (navigationHelper == null) {
			navigationHelper = new NavigationHelper(this);			
		}
		return navigationHelper;
	}

	public GroupHelper getGroupHelper(){
		if (groupHelper == null) {
			groupHelper = new GroupHelper(this);			
		}
		return groupHelper;
	}

	public ContactHelper getContactHelper(){
		if (contactHelper == null) {
			contactHelper = new ContactHelper(this);			
		}
		return contactHelper;
	}
	
	public HibernateHelper getHibernateHelper() {
		if (hibernateHelper == null) {
			hibernateHelper = new HibernateHelper(this);			
		}
		return hibernateHelper;		
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
