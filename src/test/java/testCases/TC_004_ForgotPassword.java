package testCases;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_004_ForgotPassword extends BaseClass
{
	
@Test(groups= {"sanity", "master"})
public void Test_Forgot_Password()
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
		logger.info("Clicked on Register Forgot Password Link");
		
		forgotp.clickonSubmit();
		logger.info("Click on Submit Without Entering Email");
		
		Thread.sleep(2000);
		String getErrorMsgclkSubmitWithoutEnterEmail = forgotp.getErrorMsgclkSubmitWithoutEnterEmail();
		logger.info("Validating Error message without entering email and click on Submit");
		Assert.assertEquals(getErrorMsgclkSubmitWithoutEnterEmail, "Email is required!", "Test Failed");
		
		forgotp.setEmail(prop.getProperty("wrongemail"));
		logger.info("Entering Wrong Email");
		
		forgotp.clickonSubmit();
		logger.info("Click on Submit after Entering Wrong Email");
		
		WebElement element= forgotp.getmsgToastUserNotExist();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element);
		
		String getmsgToastUserNotExist = forgotp.getmsgToastUserNotExist();
		logger.info("Validating Toast Message");
		Assert.assertEquals(getmsgToastUserNotExist, "User does not exists", "Test Failed");
		
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