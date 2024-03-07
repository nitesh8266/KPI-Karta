package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProfilePage extends BasePage
{
	public MyProfilePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//a[text()=' My Profile ' and @class='dropdown-item']")
	WebElement btnMyProfile;
	
	@FindBy (xpath = "//div//div[2]//h3")
	WebElement msgUserName;
	
	@FindBy(xpath = "//p//span")
	WebElement msgStateCountryName;
	
	@FindBy(xpath= "//a[@class='nav-link nav-link-cus active']")
	WebElement btnPersonalDetails;
	
	@FindBy(xpath = "(//button[@type='button'][normalize-space()='Upload'])[1]")
	WebElement btnImageUpload;
	
	@FindBy(xpath  = "(//button[@type='button' and @class='close'])[2]")
	WebElement btnUploadImgPopupClose;
	
	@FindBy(xpath = "(//h5[@id='passwordModalLabel'])[2]")
	WebElement msgUploadImage;
	
	@FindBy (xpath = "//input[@id='company_logo' and @name='company_logo']")
	WebElement btnUploadYourProfile;
	
	@FindBy(xpath = "//span[@class='upload-text-msg']")
	WebElement msgUploadYourPicture;
	
	@FindBy(xpath = "//span[text()='Recommended Dimensions: 300 x 300 pixels.']")
	WebElement msgRecommendedDimensions;
	
	@FindBy(xpath = "//h5[text()='Crop Image']")
	WebElement msgCropImage;
	
	@FindBy(xpath = "//img[@class='ngx-ic-source-image']")
	WebElement imgProfile;
	
	@FindBy(xpath="//div[@class='ngx-ic-cropper']")
	WebElement sldImageCropper;
	
	@FindBy(xpath="//input[@type='range']")
	WebElement btnRange;
	
	@FindBy(xpath = "//div[@class='modal-footer']//button")
	WebElement btnUpload;

	@FindBy(xpath = "//img[@class='profile_logo']")
	WebElement imgProfileLogo;
	
	@FindBy(xpath = "//label[text()='Full Name']")
	WebElement msgProfileName;
	
	@FindBy(xpath = "//input[@id='fullName']")
	WebElement txtProfileName;
	
	@FindBy(xpath="//label[text()='Email']")
	WebElement msgEmailId;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement textEmailId;
	
	@FindBy(xpath = "//label[text()='Telephone Number']")
	WebElement msgTelephoneNumber;
	
	@FindBy(id="telephone")
	WebElement txtTelephoneNumber;
	
	@FindBy(xpath="//label[text()='Mobile Number']")
	WebElement msgMobileNumber;
	
	@FindBy(id="phone")
	WebElement textMobileNumber;
	
	@FindBy(xpath="//span[@title='Verify mobile number']")
	WebElement btnEditandVerifyMobNo;
	
	@FindBy(xpath = "(//button[@type='button' and @class='close']/span)[1]")
	WebElement btnbEditandVerifyMobNoPopupClose;
	
	@FindBy(xpath="//button[@class='btn btn-outline-danger btn-sm mr-2']")
	WebElement btnCancel;
	
	@FindBy(xpath="(//label[text()='Mobile Number'])[2]")
	WebElement msgMobileNumberEdit;
	
	@FindBy(id="country-search-box")
	WebElement txtCountrySearchBoax;
	
	@FindBy(xpath="//ul[@class='iti__country-list']//li")
	WebElement listCountryName;
	
	@FindBy(xpath="(//input[@id='phone' and @type='tel'])[2]")
	WebElement txtEditMobileNumber;
	
	@FindBy(xpath="//button[text()='Send Code']")
	WebElement btnSendCode;
	
	@FindBy(xpath="//div//h4")
	WebElement msgAddress;
	
	@FindBy(xpath="//label[text()='Street']")
	WebElement msgStreet;
	
	@FindBy(id="street")
	WebElement txtStreet;
	
	@FindBy(xpath="//label[text()='City']")
	WebElement msgCity;
	
	@FindBy(id="city")
	WebElement txtCity;
	
	@FindBy(xpath="//label[text()='Province/State']")
	WebElement msgProvinceState;
	
	@FindBy(id="state")
	WebElement txtProvinceState;
	
	@FindBy(xpath="//label[text()='Postal/Zip Code']")
	WebElement msgPostalZipCode;
	
	@FindBy(id="postal_code")
	WebElement txtPostalZipCode;
	
	@FindBy(xpath="//label[text()='Country']")
	WebElement msgCountry;
	
	@FindBy(id="country")
	WebElement txtCountry;
	
	@FindBy(xpath="(//button[text()='Update'])[1]")
	WebElement btnUpdate;
	
	public void clkOnMyProfile()
	{
		btnMyProfile.click();
	}
	
	public String getUserName()
	{
		return msgUserName.getText();
	}
	
	public String getUserCountryName()
	{
		return msgStateCountryName.getText();
	}
	
	public String getMsgPersonalDetails()
	{
		return btnPersonalDetails.getText();
	}
	
	public void clkOnProfileImgUpload()
	{
		btnImageUpload.click();
	}
	
	public void clkOnProfileImgPopupClose()
	{
		btnUploadImgPopupClose.click();
	}
}
