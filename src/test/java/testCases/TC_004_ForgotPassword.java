package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_004_ForgotPassword extends BaseClass
{
	
@Test
public void Test_Forgot_Password()
	{
		HomePage hp = new HomePage(driver);
		hp.lnkForgotPassword();
	}
		
}
