package test.java.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.java.constants.ApacheLogInConstants;

public class ApacheLogInPage {

	WebDriver driver;
	public ApacheLogInPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id= ApacheLogInConstants.resumeApplicationButton) private WebElement resumeApplication;
	public WebElement getResumeApplication() {
		return resumeApplication;
	}
}
