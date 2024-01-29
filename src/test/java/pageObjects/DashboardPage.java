package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage
{

	public DashboardPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(linkText = "Home") // Dashbaord Page heading
	WebElement msgHeading;
	
	@FindBy (id="navbarDropdown")
	WebElement lnkNav;
	
	@FindBy(xpath = "//a[normalize-space()='Log Out']")
	WebElement lnkLogout;
	
	public boolean isDashbaordPageExists()   // Dashbaord Page heading display status
	{
		try 
		{
			return (msgHeading.isDisplayed());
		} 
		catch (Exception e) 
		{
			return (false);
		}
	}
	
	public void clickNavigation()
	{
		lnkNav.click();
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}	
}

