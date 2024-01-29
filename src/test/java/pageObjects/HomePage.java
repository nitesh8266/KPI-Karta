package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Create Account")
	WebElement lnkRegister;

	public void clickRegister() 
	{
		lnkRegister.click();
	}
	
	@FindBy(xpath = "//a[normalize-space()='Forgot Password']")
	WebElement lnkForgotPassword;
	
	public void lnkForgotPassword()
	{
		lnkForgotPassword.click();
	}		
}