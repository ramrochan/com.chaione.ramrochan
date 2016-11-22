package test.java.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.java.constants.ApacheSignUpConstants;

public class ApacheSignUpPage {

	WebDriver driver;
	public ApacheSignUpPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * 
	 * This is the actions page where we use the locator to find the page elements for us to interact
	 * 
	 */
	
	@FindBy(id= ApacheSignUpConstants.firstName) private WebElement firstname;
	@FindBy(id= ApacheSignUpConstants.lastName) private WebElement lastname;
	@FindBy(id= ApacheSignUpConstants.email) private WebElement email;
	@FindBy(id= ApacheSignUpConstants.password) private WebElement password;
	@FindBy(xpath= ApacheSignUpConstants.applyButton) private WebElement applyButton;
	@FindBy(id= ApacheSignUpConstants.mobilePhone) private WebElement mobileNumber;
	@FindBy(className= ApacheSignUpConstants.popUpWindow) private WebElement popUpWindow;
	@FindBy(css= ApacheSignUpConstants.errorMessage) private WebElement errorMessage;
	@FindBy(css= ApacheSignUpConstants.errorMessageSpanish) private WebElement errorMessageSpanish;
	@FindBy(xpath= ApacheSignUpConstants.signUpPageText) private WebElement pageText;
	@FindBy(xpath= ApacheSignUpConstants.spanishButton) private WebElement spanishbutton;


	public WebElement getFirstname() {
		return firstname;
	}


	public WebElement getLastname() {
		return lastname;
	}


	public WebElement getPageText() {
		return pageText;
	}


	public WebElement getEmail() {
		return email;
	}


	public WebElement getPassword() {
		return password;
	}


	public WebElement getApplyButton() {
		return applyButton;
	}
	
	public WebElement getPopUpWindow() {
		return popUpWindow;
	}


	public WebElement getErrorMessage() {
		return errorMessage;
	}
	
	public WebElement getErrorMessageSpanish() {
		return errorMessageSpanish;
	}

	
	/*
	 *
	 * This is the where the registration flow occurs
	 *
	 */
	
	public void registrationFlow(String firstName, String lastName, String emailId, String mobileNum, String passWord){
		firstname.clear();
		firstname.sendKeys(firstName);
		lastname.clear();
		lastname.sendKeys(lastName);
		email.clear();
		email.sendKeys(emailId);
		mobileNumber.clear();
		mobileNumber.clear();
		mobileNumber.sendKeys(mobileNum);
		password.clear();
		password.sendKeys(passWord);
		applyButton.click();
	}
	
	/*
	 * 
	 * In order to do test in Spanish language we have to switch to Spanish page.
	 * 
	 */
	
	public void selectSpanish(){
		spanishbutton.click();
	}
	
}
