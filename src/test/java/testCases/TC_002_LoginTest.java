package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{
	@Test(groups= {"sanity", "master"})
	public void test_Login()
	{
		logger.info("-----------------Starting TC_002_LoginTest---------------");
	//	logger.debug("------------Capture application debug log----------------");
		
		try
		{	
			LoginPage lp=new LoginPage(driver);
			
			lp.setEmail(prop.getProperty("email"));
			logger.info("Enter Email");
			
			lp.setPassword(prop.getProperty("password"));
			logger.info("Enter Password");
			
			lp.clickLogin();
			logger.info("Clicking on Submit button");
			
			DashboardPage macc= new DashboardPage(driver);
			
			boolean targetpage=macc.isDashbaordPageExists();
			
			if (targetpage==true)
			{
				logger.info("Login Test Passed");
				Assert.assertTrue(true);
			}
			else
			{
				logger.info("Login Test Failed");
				Assert.fail();
			}
			
			macc.clickNavigation();
			logger.info("Clicking on Navigation button");
			
			macc.clickLogout();
			logger.info("Clicking on logout button");
		}	
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info(" Finished TC_002_LoginTest");	
	}	
}
