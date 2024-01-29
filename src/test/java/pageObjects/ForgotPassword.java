package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPassword extends BasePage
{
	public ForgotPassword(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//h2[normalize-space()='Forgot Password']")
	WebElement msgForgot;
	
	@FindBy(xpath = "//strong[normalize-space()='Login']")
	WebElement btnBacktoLogin;
	
	@FindBy(id="email")
	WebElement txtEmail;
	
	@FindBy(xpath = "//button[normalize-space()='SUBMIT']")
	WebElement btnSubmit;
	
	public String getmsgForgot()
	{
		try 
		{
			return (msgForgot.getText());
		} 
		catch (Exception e) 
		{
			return (e.getMessage());
		}
	}
	
	public void clickonBacktoLogin()
	{
		btnBacktoLogin.click();
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void clickonSubmit()
	{
		btnSubmit.click();
	}
	
}
