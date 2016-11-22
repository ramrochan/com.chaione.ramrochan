package test.java.test;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import main.java.core.BaseTest;
import test.java.page.ApacheLogInPage;
import test.java.page.ApacheSignUpPage;

public class ApacheSignUpPageTest extends BaseTest{
	
	
	
	/*
	 * 
	 * Test cases for testing the registration flow.
	 * 
	 */
	
	
	// Check whether we are on the registration page
	@Test(priority= 0)
	public void testForCurrentPage(){
		ApacheSignUpPage asp= new ApacheSignUpPage(driver);
		WebDriverWait wait= new WebDriverWait(driver, 1000);
		wait.until(ExpectedConditions.visibilityOf(asp.getFirstname()));
		String actual=driver.getCurrentUrl();
		Assert.assertEquals( actual, "https://apache-atm-qa.azurewebsites.net/");
	}
	
	//Test for registration with random details
	@Test(priority=1)
	public void registrationWithWrongDetails(){
		ApacheSignUpPage asp= new ApacheSignUpPage(driver);
		WebDriverWait wait= new WebDriverWait(driver, 1000);
		wait.until(ExpectedConditions.visibilityOf(asp.getFirstname()));
		asp.registrationFlow("123", "123", "123@gmail.com", "(123) 123-1234", "12345");
		wait.until(ExpectedConditions.visibilityOf(asp.getErrorMessage()));
		Assert.assertEquals(asp.getErrorMessage().getText(),
				"Apache already has an account for this email address / phone number" );
	}
	
	//Test for registration with empty details
	@Test(priority=2)
	public void registrationWithEmptyDetails(){
		ApacheSignUpPage asp= new ApacheSignUpPage(driver);
		asp.registrationFlow(" ", " ", " ", " ", " ");
		Assert.assertEquals(asp.getPageText().getText(), "Work for Apache");
	}
	
	//Test for registration with correct details
	@Test(priority=3)
	public void registrationWithCorrectDetails(){
		ApacheSignUpPage asp= new ApacheSignUpPage(driver);
		asp.registrationFlow("Ram", "Chinniah", "ramrochanchinniah@gmail.com", "(510) 358-8328", "RamRochan");
		ApacheLogInPage alp= new ApacheLogInPage(driver);
		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(alp.getResumeApplication()));
		Assert.assertEquals(alp.getResumeApplication().getText(),
				"RESUME APPLICATION");
	}
	
	//Test for registration with details which already exists
	@Test(priority=4)
	public void registrationWithSameInfo(){
		ApacheSignUpPage asp= new ApacheSignUpPage(driver);
		asp.registrationFlow("Ram Rochan", "Chinniah", "rrchinniah@gmail.com", "(832) 846-6751", "RamRochan@83");
		Assert.assertEquals(asp.getErrorMessage().getText(),
				"Apache already has an account for this email address / phone number");
	}
	
}
