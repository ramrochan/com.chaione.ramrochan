package main.java.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

	
	/*
	 * 
	 * This is the Factory design pattern for the browsers
	 * 
	 */
	
	
	public static WebDriver getDriver(String browsername){
		WebDriver driver = null;
		if(browsername.equalsIgnoreCase("ff")){
			driver = new FirefoxDriver();
		}else if(browsername.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
			driver = new ChromeDriver();
		}else if(browsername.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Internet Explorer\\iexplore.exe");
			driver = new InternetExplorerDriver();
		}
		return driver;
	}
}
