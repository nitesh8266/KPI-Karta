package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_004_ForgotPassword extends BaseClass
{

@Test(groups= {"sanity", "master"})
public void test_Forgot_Password()
	{
	logger.info("----------Starting TC_004_ForgotPasswordPage-------");
	
	try
	{
		HomePage hp = new HomePage(driver);
		hp.lnkForgotPassword();
		logger.info("Clicked on Forgot Password Link");
		
		ForgotPassword forgotp = new ForgotPassword (driver);
		String getmsgForgot = forgotp.getmsgForgot();
		logger.info("Validating Expected Message Forgot Password");
		Assert.assertEquals(getmsgForgot, "Forgot Password" , "Test Failed");
		
		forgotp.clickonBacktoLogin();
		logger.info("Validating Back to Login button");
		
		hp.lnkForgotPassword();
		logger.info("Clicked on Forgot Password Link");
		
		forgotp.clickonSubmit();
		logger.info("Click on Submit Without Entering Email");
		
		String getErrorMsgclkSubmitWithoutEnterEmail = forgotp.getErrorMsgclkSubmitWithoutEnterEmail();
		logger.info("Validating Error message without entering email");
		Assert.assertEquals(getErrorMsgclkSubmitWithoutEnterEmail, "Email is required!", "Test Failed");
		
		forgotp.setEmail(prop.getProperty("invalidEmail"));
		logger.info("Enter Invalid Email Id");
		
		String getErrorMsgInvalidEmail = forgotp.getMsgInvalidEmail();
		logger.info("Validating Error message after entering Invalid Email");
		Assert.assertEquals(getErrorMsgInvalidEmail, "Enter a valid email address!", "Test Failed");
		
//		forgotp.setEmail(prop.getProperty("nonRegisteredEmail"));
//		logger.info("Enter wrong Email Id");
//		
//		forgotp.clickonSubmit();
//		logger.info("Click on  Submit after entering Non-Registered Email");
//		
//		String getmsgToastUserNotExist = forgotp.getmsgToastUserNotExist();
//		logger.info("Validating Toast Message");
//		Assert.assertEquals(getmsgToastUserNotExist, " User does not exists ", "Test Failed1S");
		
		forgotp.textClearEmail();
		logger.info("Removing entered data from email field");
		
		forgotp.setEmail(prop.getProperty("email"));
		logger.info("Enter Email Id");
		
		forgotp.clickonSubmit();
		logger.info("Click on Submit");
	}
		
	catch(Exception e)
	{
		Assert.fail();
	}
	logger.info("----------Finished TC_004_ForgotPasswordPage-------");
}
}