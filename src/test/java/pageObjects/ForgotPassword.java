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
	
	@FindBy (xpath = "//div[contains(text(),'Email is required!')]")
	WebElement MsgclkSubmitWithoutEnterEmail;
	
	@FindBy(xpath = "//div[@class='ng-tns-c13-1 toast-message ng-star-inserted']")
	public WebElement msgToastUserNotExist;
	
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
	
	public String getErrorMsgclkSubmitWithoutEnterEmail()
	{
	return (MsgclkSubmitWithoutEnterEmail.getText());
	}
	
	public WebElement getmsgToastUserNotExist()
	{
		return msgToastUserNotExist;
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
