package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

	public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups= {"regression", "master"})
	public void test_account_Registration() throws InterruptedException
	{
	//	logger.debug("--------Application Log-----------");
		logger.info("----------Starting TC_001_AccountRegistrationTest-------");
		
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("Providing Customer Data");
		regpage.setFullName(randomeString().toUpperCase());
		
		regpage.setEmail(randomeString()+"@yopmail.com");// randomly generated the email
		
		String password1=randomAlphaNumeric();
		regpage.setPassword(password1);
		regpage.setConfirmPassword(password1);
		
		regpage.setTelephone(randomeNumber());
		
		regpage.setCompanyName(randomeString().toUpperCase());
		
		regpage.clickContinue();
		
		String confmsg=regpage.getConfirmationMsg();
		
		logger.info("Validating Expected Message Verify Your Account");
		Assert.assertEquals(confmsg, "Verify Your Account" , "Test Failed");
		
		regpage.clickResend();
		logger.info("Clicked on Resend");
		
//		Thread.sleep(3000);
//		regpage.getSuccessResendMsg();
//		logger.info("Printing Resend Success Message");
		
		Thread.sleep(70000);;
		regpage.clickVerify();
		logger.info("Clicked on Verify");
		
		String creatorPageMsg = regpage.getCreatorLicenseMsg();
		Assert.assertEquals(creatorPageMsg, "Select Creator License" , "Test Failed");
		logger.info("Validating Creator Page Message");
		
		regpage.clickOnSelectPlan();
		logger.info("Select Plan");
		
		String successfullSignupMsg = regpage.getSuccessfullSignupMsg();
		Assert.assertEquals(successfullSignupMsg, "THANK YOU!" , "Test Failed");
		logger.info("Validating Successfull Account Creation Message");
		
		regpage.clickOnLoginAfterSignup();
		logger.info("Clicking on Login Page After Signup");
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("----------Finished TC_001_AccountRegistrationTest-------");
	}
}
