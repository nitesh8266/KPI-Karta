package testCases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.MyProfilePage;
import testBase.BaseClass;

public class TC_005_MyProfilePage extends BaseClass
{
	@Test(groups= {"sanity", "master"})
	public void test_MyPeofile()
	{
		logger.info("-----------------Starting TC_005_MyProfileTest---------------");
		try
		{
		LoginPage lp=new LoginPage(driver);
		DashboardPage macc= new DashboardPage(driver);
		MyProfilePage mpp = new MyProfilePage(driver);
		
		lp.setEmail(prop.getProperty("email"));
		logger.info("Enter Email");
		
		lp.setPassword(prop.getProperty("password"));
		logger.info("Enter Password");
		
		lp.clickLogin();
		logger.info("Clicking on Submit button");
		
		macc.clickNavigation();
		logger.info("Clicking on Navigation button");
		
		mpp.clkOnMyProfile();
		logger.info("Clicking on My Profile button");
		
		String myProfilePageTitle = driver.getTitle();
		Assert.assertEquals(myProfilePageTitle, "My Profile - KPI Karta", "My Profile Title not matching - Test Failed");
		logger.info("Validating My Profile Page Title");
		
		Thread.sleep(2000);
		String msgAccUserName = mpp.getUserName();
		Assert.assertEquals(msgAccUserName, "Rahul Kumar", "User Name not Matching -Test Failed");
		logger.info("Validating User Name");
		
		String msgUserStateCountry = mpp.getUserCountryName();
		Assert.assertEquals(msgUserStateCountry, "Haryana / India", "User Country Name not Matching -Test Failed");
		logger.info("Validating User State/Country Name");
		
		String personalDetailsmsg = mpp.getMsgPersonalDetails();
		Assert.assertEquals(personalDetailsmsg, "Personal Details", "Personal Details MSG -Test Failed");
		logger.info("Validating User Personal Details MSG");
		
		mpp.clkOnProfileImgUpload();
		logger.info("Clicking on the User Profile Image Upload");
		
		mpp.clkOnProfileImgPopupClose();
		logger.info("Clicking on Pop up Close button");
		
			
//		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
//		Alert alertwindow=mywait.until(ExpectedConditions.alertIsPresent());
//		alertwindow.getText(); //Are you sure, you want to update your profile?
//		alertwindow.dismiss();
//		alertwindow.accept();	
		
		}
	
		catch(Exception e)
			{
				Assert.fail();
			}
	logger.info("----------Finished TC_005_MyProfilePage-------");
	}
}
