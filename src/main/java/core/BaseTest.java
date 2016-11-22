package main.java.core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {

	protected WebDriver driver;
	
	/*
	 * 
	 * This is the base test which can used for setup and tear down of the browser
	 * All the tests extends this class
	 * 
	 * 
	 */

	
	
	
	
	@BeforeClass
	@Parameters("browser")
	public void browserSetup(String browser){
		driver = BrowserFactory.getDriver(browser);
		driver.get("https://apache-atm-qa.azurewebsites.net/");	
	}
	
	@AfterClass
	public void cleanUp(){
		driver.close();
	}
}
