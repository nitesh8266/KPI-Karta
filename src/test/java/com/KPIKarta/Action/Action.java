package com.KPIKarta.Action;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.BaseClass;

public class Action extends BaseClass
{
	public void fluentWait(WebDriver driver, WebElement element)
	{
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(Exception.class);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch (Exception e)
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			e.printStackTrace();
		}
	}
	
	public void implicitWait(WebDriver driver, int timeOut)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
	}
	
	public void explicitWait(WebDriver driver, WebElement element, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void alertwait()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
	}
	
	
}
