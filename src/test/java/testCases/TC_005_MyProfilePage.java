package testCases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.KPIKarta.Action.Action;

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
		Action action = new Action();
		SoftAssert softAssert = new SoftAssert();
		
		lp.setEmail(prop.getProperty("email"));
		logger.info("Enter Email");
		
		lp.setPassword(prop.getProperty("password"));
		logger.info("Enter Password");
		
		lp.clickLogin();
		logger.info("Clicking on Submit button");
		
		macc.clickNavigation();
		logger.info("Clicking on Navigation button");
		
		mpp.btnMyProfile.click();
		logger.info("Clicking on My Profile button");
		
		Assert.assertEquals(driver.getTitle(), "My Profile - KPI Karta", "My Profile Title not matching - Test Failed");
		logger.info("Validating My Profile Page Title");
		
		Thread.sleep(3000);
		softAssert.assertEquals(mpp.msgUserName.getText(), "Rahul Kumar", "User Name not Matching -Test Failed");
		logger.info("Validating User Name");
		
		softAssert.assertEquals(mpp.msgStateCountryName.getText(), "N/A", "User Country Name not Matching -Test Failed");
		logger.info("Validating User State/Country Name");
		
		Assert.assertEquals(mpp.btnPersonalDetails.getText(), "Personal Details", "Personal Details MSG -Test Failed");
		logger.info("Validating User Personal Details MSG");
		
		mpp.btnImageUpload.click();
		logger.info("Clicking on the User Profile Image Upload button");
		
		action.fluentWait(driver, mpp.msgUploadImage);
		softAssert.assertEquals(mpp.msgUploadImage.getText(), "Upload Picture", "Upload Image MSG -Test Failed");
		logger.info("Validating Upload Picture MSG");
		
		softAssert.assertEquals(mpp.msgUploadYourPicture.getText(), "Upload your picture", "Upload your picture MSG -Test Failed");
		logger.info("Validating Upload your Picture MSG");
		
		softAssert.assertEquals(mpp.msgRecommendedDimensions.getText(), "Recommended Dimensions: 300 x 300 pixels.", "Recommended Dimensions MSG -Test Failed");
		logger.info("Validating Recommended Dimensions: 300 x 300 pixels. MSG");
		
		
		softAssert.assertEquals(mpp.btnUpload.getText(), "UPLOAD", "Upload button Label -Test Failed");
		logger.info("Validating Upload Button Label Msg");
		
		mpp.btnUploadImgPopupClose.click();
		logger.info("Clicking on Pop up Close button");
		
		mpp.btnImageUpload.click();
		logger.info("Clicking on the User Profile Image Upload button");
		
//		mpp.profileImgUpload(".//testData//nature.jpg");
		
		mpp.profileImgUpload("C:\\Users\\Nitesh\\Downloads\\nature.jpg");
		logger.info("Clicking on the Upload your picture to upload picture from system");
		
		action.fluentWait(driver, mpp.lblUploadPictureAfterUploadImage);
		softAssert.assertEquals(mpp.lblUploadPictureAfterUploadImage.getText(), "Upload Picture", "Upload Picture Label After Upload Image - Test Failed");
		logger.info("Validating Upload picture label after image upload");
		
		softAssert.assertEquals(mpp.msgCropImage.getText(), "Crop Image", "Crop Image MSG - Test Failed");
		logger.info("Validating Upload Picture Label After Upload Image");
		
		softAssert.assertEquals(mpp.RecDimensionMsg.getText(), "Recommended Dimensions: 300 x 300 pixels.", "Rec Dimensions Msg after Image Upload - Test Failed");
		logger.info("Validating Rec Dimensions Msg after Image Upload");
		
		softAssert.assertEquals(mpp.msgTxtCrop.getText(), "To crop this image, drag the region below and then click \"Submit\"", "Crop Image Guide Msg - Test Failed");
		logger.info("Validating Crop Guide MSG after Uploading the Image");
		
		mpp.setProfileImageSlider(20);
		logger.info("Validatng adjusting Profile Image with slider");
		
		mpp.setProfileImageRange(0.1, 0.1);
		logger.info("Validatng adjusting Profile Image with Range");
		
		mpp.btnUpload.click();
		logger.info("Clicking on the Upload image after uploading the profile Image");
		
		// IMG Profile Validate
		//Image Profile Validate after Uploading Image in Personal Details
		
		action.fluentWait(driver, mpp.msgProfileName);
		softAssert.assertEquals(mpp.msgProfileName.getText(), "Full Name", "Full Name Label MSG - Test Failed");
		logger.info("Validating Full Name Label MSG");
		
		// Need to ask to get dynamic Data
//		action.fluentWait(driver, mpp.msgProfileName);
//		softAssert.assertEquals(mpp.txtProfileName.getText(), "Rahul Kumar", "User Name MSG - Test Failed");
//		logger.info("Validating User Name Entered during Sign Up");
	
		mpp.txtProfileName.clear();
		logger.info("Clear User Name");
		
		mpp.txtProfileName.sendKeys(Keys.SPACE);
		logger.info("Vlidating clicking on Space Button");
		
		softAssert.assertEquals(mpp.msgBlankSpaceIsnotallowed.getText(), "Blank space is not allowed!", "Error Msg after clicking space btn - Test Failed");
		logger.info("Vlidating error message clicking on Space Button");
		
		mpp.txtProfileName.sendKeys(Keys.BACK_SPACE);
		logger.info("Vlidating clicking on Back Space Button");

		softAssert.assertEquals(mpp.msgFullNameisRequired.getText(), "Full name is required!", "Error Msg after clear full Name - Test Failed");
		logger.info("Validating Error Message after Clear Full Name Field");
		
		mpp.txtProfileName.sendKeys(randomeString().toUpperCase());
		logger.info("Enter Full Name");
		
		softAssert.assertEquals(mpp.msgEmailId.getText(), "Email", "Email Lable - Test Failed");
		logger.info("Validating Lable Msg Email field");
		
//		//Get EmailID entered during Sign Up
		
		softAssert.assertEquals(mpp.msgTelephoneNumber.getText(), "Telephone Number", "Telephone Number field Lable - Test Failed");
		logger.info("Validating Lable Msg Telephone Number field");
		
//		mpp.txtTelephoneNumber.sendKeys(randomeString().toUpperCase());
//		logger.info("Entering Invalid Telephone Number");
//		
//		mpp.txtTelephoneNumber.sendKeys(Keys.ENTER);
//		mpp.blankSpace.click();
//		
//		action.fluentWait(driver, mpp.msgInvalidTelephoneNumber);
//		softAssert.assertEquals(mpp.msgInvalidTelephoneNumber.getText(), "Telephone number is not valid!", "Invalid Telephone Number Msg - Test Failed");
//		logger.info("Validating Error Message of Telephone Number after Entering Invalid Telephone Number");
//		
//		mpp.txtTelephoneNumber.clear();
//		logger.info("Validating Clear Telephone Number field after Entering Invalid Telephone Number");
		
		mpp.txtTelephoneNumber.sendKeys("876547");
		logger.info("Validating TP after Entering less digit Telephone Number");
		
		action.fluentWait(driver, mpp.msgTelephoneNumTotalDigit);
		softAssert.assertEquals(mpp.msgTelephoneNumTotalDigit.getText(), "Telephone number must of 10 digits!", "Less Telephone num Msg - Test Failed");
		logger.info("Validating Error Message after entering less digit Telephone Number");
		
		mpp.txtTelephoneNumber.clear();
		logger.info("Validating Clear Telephone Number field after Entering Less Digit Telephone Number");
		
		mpp.txtTelephoneNumber.sendKeys(randomeNumber());
		logger.info("Validatin enting valid Telephone Number");
		
		softAssert.assertEquals(mpp.msgMobileNumber.getText(), "Mobile Number", "Mobile Number label - Test Failed");
		logger.info("Validating Mobile Number Label MSG");
		
		// Need to ask to get dynamic Data For Mobile Number entered during signup
		softAssert.assertEquals(mpp.btnEditandVerifyMobNo.getText(), "Edit and Verify", "Edit and Verify Mobile label - Test Failed");
		logger.info("Validating Edit and Verify Lable MSG");
		
		mpp.btnEditandVerifyMobNo.click();
		logger.info("Validating clicking on Edit and Verify button");
		
		action.fluentWait(driver, mpp.msgVerifyMobileNumber);
		softAssert.assertEquals(mpp.msgVerifyMobileNumber.getText(), "Verify Phone Number", "Label Verify Phone No.- Test Failed");
		logger.info("Validating Title MSG Edit and Verify Mob No. PopUp");
		
		mpp.btnbEditandVerifyMobNoPopupClose.click();
		logger.info("Validating clicking on the Edit and Verify Pop up Close button");
		
		mpp.btnEditandVerifyMobNo.click();
		logger.info("Validating clicking on Edit and Verify button after Popup Close");
		
		action.fluentWait(driver, mpp.btnCancel);
		softAssert.assertEquals(mpp.btnCancel.getText(), "Cancel", "Cancel Button label MSG - Test Failed");
		logger.info("Validating Cancel Button Label Msg");
		
		mpp.btnCancel.click();
		logger.info("Validating Clicking Cancel Button");
		
		mpp.btnEditandVerifyMobNo.click();
		logger.info("Validating clicking on Edit and Verify button after clicking on the Cancel Button");
		
		action.fluentWait(driver, mpp.labelMobileNumberEdit);
		softAssert.assertEquals(mpp.labelMobileNumberEdit.getText(), "Mobile Number", "Mobile Number Label in Edit Pop Up - Test Failed");
		logger.info("Validating Mobile Label msg in Edit and Verify Pop up");
		
		mpp.btnSendCode.click();
		logger.info("Clicking on The Send Code Button");
		
		softAssert.assertEquals(mpp.lblVerificationCode.getText(), "Verification Code", "Verification Code Label MSG - Test Failed");
		logger.info("Validating Verification Code Label");
		
		softAssert.assertEquals(mpp.btnResendCode.getText(), "Resend Code", "Resend Code Label - Test Failed");
		logger.info("Validating Resend Code Label");
		
		softAssert.assertEquals(mpp.btnVerifyEditMobile.getText(), "VERIFY", "Verify button Label - Test Failed");
		logger.info("Validating Verify button Label MSG in Edit Mob");
		
		mpp.btnResendCode.click();
		logger.info("Validating Clicking on Resend Button");
		
		mpp.txtEnterVerificationCode.click();
		logger.info("Validating Clicking on the Enter Verification Code field");
		
		mpp.btnVerifyEditMobile.click();
		logger.info("Vliadting clicking on the Verify button without entering Code");
		
		softAssert.assertEquals(mpp.lblErrorVerCodeReq.getText(), "Verification code is required!", "Code Req MSG - Test Failed");
		logger.info("Validating error message after clicking on Verify button without entering Code");
		
		mpp.btnVerifyMobPopupClose.click();
		logger.info("Validating Verification code Pop up close");
		
		action.fluentWait(driver, mpp.btnEditandVerifyMobNo);
		mpp.btnEditandVerifyMobNo.click();
		logger.info("Validating clicking on Edit and Verify button after clicking on Resend");
		
		mpp.btnCountryCode.click();
		logger.info("Validating Country Code List Button");
		
		//WebElement txtEditMobileNumber;
		//Need to ask to get dynamic Data For Mobile Number entered during Sign up
		
		action.fluentWait(driver, mpp.txtCountrySearchBox);
		softAssert.assertEquals(mpp.txtCountrySearchBox.getAttribute("placeholder"), "Search Country", "Search Country Label MSG - Test Failed");
		logger.info("Validating Search Country label Msg");

		mpp.getListCountryName();
		logger.info("Validating Country List");
		
		mpp.getListCountryName().get(2).click();
		logger.info("Validating clicking on the Country code");
		
		mpp.txtEditMobileNumber.clear();
		logger.info("Validating Removing Mobile Number");
		
		mpp.txtEditMobileNumber.sendKeys("8266828984");
		logger.info("Validating editing Mobile Number");
		
//		Thread.sleep(7000);
		mpp.btnSendCode.click();
		logger.info("Clicking on The Send Code Button");
		
		mpp.btnbEditandVerifyMobNoPopupClose.click();
		logger.info("Validating clicking on the Edit and Verify Pop up Close button");
		
//		Thread.sleep(7000);
//		mpp.txtEnterVerificationCode.click();
//		logger.info("Validating Clicking on the Enter Verification Code field");
//		
//		Thread.sleep(7000);
//		mpp.btnVerifyEditMobile.click();
//		logger.info("Validating clicking on the Verify button After entering valid Code");
		
		action.fluentWait(driver, mpp.msgAddress);
		softAssert.assertEquals(mpp.msgAddress.getText(), "ADDRESS", "Address Label MSG - Test Failed");
		logger.info("Validating Label MSG Address");
		
		action.fluentWait(driver, mpp.msgStreet);
		softAssert.assertEquals(mpp.msgStreet.getText(), "Street", "label MSG - Street - Test Failed");
		logger.info("Validating Label MSG Street");
		
		mpp.txtStreet.sendKeys(randomeString().toUpperCase());
		logger.info("Entering Street Name");
		
		softAssert.assertEquals(mpp.msgCity.getText(), "City", "Validating label MSG - City - Test Failed");
		logger.info("Validating Label City");
		
		mpp.txtCity.sendKeys(randomeString().toUpperCase());
		logger.info("Entering City Name");
		
		softAssert.assertEquals(mpp.msgProvinceState.getText(), "Province/State", "label MSG - Province/State - Test Failed");
		logger.info("Validating label MSG Province/State Name");
		
		mpp.txtProvinceState.sendKeys(randomeString().toUpperCase());
		logger.info("Entering Province/State Name");
		
		softAssert.assertEquals(mpp.msgPostalZipCode.getText(), "Postal/Zip Code", "label MSG - Postal/Zip Code - Test Failed");
		logger.info("Validating label MSG Postal/Zip Code Name");
		
		mpp.txtPostalZipCode.sendKeys(randomeString().toUpperCase());
		logger.info("Entering Postal/Zip Code Name");
		
		softAssert.assertEquals(mpp.msgCountry.getText(), "Country", "label MSG Country - Test Failed");
		logger.info("Validating label MSG Country");
		
		mpp.txtCountry.sendKeys(randomeString().toUpperCase());
		logger.info("Entering Country Name");
		
		mpp.btnUpdate.click();
		logger.info("Validating clicking on the Update button");
		
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		Alert alertwindow=mywait.until(ExpectedConditions.alertIsPresent());
		softAssert.assertEquals(alertwindow.getText(), "Are you sure, you want to update your profile?", "POPUP Text MSG- Test Failed");
		logger.info("Validating Update Popup MSG");
		
//		alertwindow.accept();	
//		logger.info("Accepting Popup");
		
//		alertwindow.dismiss();
		
		softAssert.assertAll();
		
		}
	
	catch(Exception e)
			{
				Assert.fail();
			}
	logger.info("----------Finished TC_005_MyProfilePage-------");
	}
}
