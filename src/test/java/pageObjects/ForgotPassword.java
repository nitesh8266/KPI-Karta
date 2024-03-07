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
	
	@FindBy(xpath = "//div/h2[text()='Forgot Password']")
	WebElement msgForgot;
	
	@FindBy(xpath = "//a[@class='text-white']")
	WebElement btnBacktoLogin;
	
	@FindBy (xpath = "//div[contains(text(),'Email is required!')]")
	WebElement MsgclkSubmitWithoutEnterEmail;
	
	@FindBy(xpath = "//div[@class='ng-tns-c13-1 toast-message ng-star-inserted']")
	WebElement MsgNonRegisteredEmail;
	
	@FindBy(id="email")
	WebElement txtEmail;
	
	@FindBy(xpath = "//button[@class='btn btn-light btn_default mb-3 mt-2']")
	WebElement btnSubmit;
	
	@FindBy(xpath = "//div[text()='Enter a valid email address!']")
	WebElement MsgInvalidEmail;
	
	
	public void textClearEmail()
	{
		 txtEmail.clear();
	}
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
	
//	public WebElement getmsgToastUserNotExist()
//	{
//		return msgToastUserNotExist;
//	}
	
	public String getmsgToastUserNotExist()
	{
		return MsgNonRegisteredEmail.getText();
	}
	
	public String getMsgInvalidEmail()
	{
		return MsgInvalidEmail.getText();
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
