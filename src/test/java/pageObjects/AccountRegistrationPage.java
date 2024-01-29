package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage 
{

	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	// Elements
		@FindBy(id="fullName")
		WebElement txtFullname;

		@FindBy(id="email")
		WebElement txtEmail;

		@FindBy(id="password")
		WebElement txtPassword;

		@FindBy(id = "confirmPassword")
		WebElement txtConfirmPassword;
		
		@FindBy(id="phone")
		WebElement txtTelephone;

		@FindBy(id="companyName")
		WebElement txtCompanyName;
		
		@FindBy(xpath = "//button[normalize-space()='NEXT']")
		WebElement btnContinue;

		@FindBy(xpath = "//h2[normalize-space()='Verify Your Account']")
		WebElement msgConfirmation;
		
		@FindBy(xpath = "//a[normalize-space()='Resend Code']")
		WebElement btnClickOnResend;
		
		@FindBy(xpath = "//button[normalize-space()='Verify']")
		WebElement btnClickOnVerify;
		
		@FindBy(xpath = "//h4[normalize-space()='Select Creator License']")
		WebElement msgCreatorLicense;
		
		@FindBy(xpath = "//div[@class='col-sm-6 pr-0']//button[@class='btn_sty_2'][normalize-space()='Select Plan']")
		WebElement btnSelectPlan;
		
		@FindBy(xpath = "//h2[normalize-space()='THANK YOU!']")
		WebElement msgSignUp;
		
		@FindBy(xpath = "//a[normalize-space()='LOGIN']")
		WebElement btnClickOnLoginAfterSignUp;
		
		public void setFullName(String fname)
		{
			txtFullname.sendKeys(fname);
		}

		public void setEmail(String email) 
		{
			txtEmail.sendKeys(email);
		}

		public void setPassword(String pwd) 
		{
			txtPassword.sendKeys(pwd);
		}
		
		public void setConfirmPassword(String pwd) 
		{
			txtConfirmPassword.sendKeys(pwd);
		}
		
		public void setTelephone(String tel)
		{
			txtTelephone.sendKeys(tel);
		}

		public void setCompanyName(String cName)
		{
			txtCompanyName.sendKeys(cName);
		}
		public void clickContinue() 
		{
		btnContinue.click();		
		}

		public String getConfirmationMsg() 
		{
			try 
			{
				return (msgConfirmation.getText());
			} catch (Exception e) {
				return (e.getMessage());
			}
		}
		
		public void clickResend()
		{
			btnClickOnResend.click();
		}
		
		public void clickVerify()
		{
			btnClickOnVerify.click();
		}
		
		public String getCreatorLicenseMsg() 
		{
			try 
			{
				return (msgCreatorLicense.getText());
			} catch (Exception e) {
				return (e.getMessage());
			}
		}
		
		public void clickOnSelectPlan()
		{
			btnSelectPlan.click();
		}
		
		public String getSuccessfullSignupMsg()
		{
			try 
			{
				return (msgSignUp.getText());
			} catch (Exception e) {
				return (e.getMessage());
			}
		}	
		public void clickOnLoginAfterSignup()
		{
			btnClickOnLoginAfterSignUp.click();
		}
}
