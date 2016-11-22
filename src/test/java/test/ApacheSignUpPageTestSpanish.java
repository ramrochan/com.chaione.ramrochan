package test.java.test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import main.java.core.BaseTest;
import test.java.page.ApacheSignUpPage;

public class ApacheSignUpPageTestSpanish extends BaseTest{

	/*
	 * 
	 * Test cases for testing the registration flow in Spanish.
	 * 
	 */
	
	
	
	
	// Check whether we are on the registration page
	@Test(priority= 0)
	public void testForCurrentPage(){
		ApacheSignUpPage asp= new ApacheSignUpPage(driver);
		asp.selectSpanish();
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
		wait.until(ExpectedConditions.visibilityOf(asp.getErrorMessageSpanish()));
		Assert.assertEquals(asp.getErrorMessageSpanish().getText(),
				"Apache ya tiene una cuenta de correo electrónico para esta dirección / número de teléfono" );
	}
	
	//Test for registration with details which already exists
	@Test(priority=2)
	public void registrationWithSameInfo(){
		ApacheSignUpPage asp= new ApacheSignUpPage(driver);
		asp.registrationFlow("Ram Rochan", "Chinniah", "rrchinniah@gmail.com", "(832) 846-6751", "RamRochan@83");
		Assert.assertEquals(asp.getErrorMessageSpanish().getText(),
				"Apache ya tiene una cuenta de correo electrónico para esta dirección / número de teléfono");
	}
	
	
	//Test for registration in the Spanish page
	@Test(priority=3)
	public void registrationWithEmptyDetails(){
		ApacheSignUpPage asp= new ApacheSignUpPage(driver);
		WebDriverWait wait= new WebDriverWait(driver, 1000);
		wait.until(ExpectedConditions.visibilityOf(asp.getFirstname()));
		asp.selectSpanish();
		asp.registrationFlow("Ram", "Rochan", "ramrochan", "(832) 846-6751", "Mechatronics");
		Assert.assertEquals(asp.getPageText().getText(), "Trabajar para Apache");
	}
}
