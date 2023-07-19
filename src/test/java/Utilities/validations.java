package Utilities;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import TestBase.BaseClass;

public class validations extends BaseClass{
	
	webDriverUtilities ut=new webDriverUtilities();
	
	public void contains(WebElement element,WebDriver driver,String Expected, String passMessage,String failMessage) throws InterruptedException
	{

		String ActualValue=element.getAttribute("value");

		if(ActualValue.contains(Expected))
		{
			assertTrue(true,passMessage );
			ut.highlightElement(driver,element);

		}
		else
		{
			assertTrue(false, failMessage);
		}
	}


	public void Displayed(WebElement element,WebDriver driver) throws InterruptedException
	{

		if(element.isDisplayed())
		{

			ut.highlightElement(driver, element);
			assertTrue(true);
		}
		else
		{
			assertTrue(false);

		}
	}

	public void containsTittle(WebElement element,WebDriver driver) throws InterruptedException
	{

		String actual=driver.getTitle();
		String Expected=element.getText();
		
		System.out.println(actual+":Actl");
		System.out.println(Expected+":Exp");
		
		ut.waitForElementToLoad(driver, element);
		ut.highlightElement(driver,element);

		if(Expected.contains(actual))
		{
			assertTrue(true);
		}
		else
		{
			assertTrue(false);

		}
	}
	
	public void containsUrl(WebDriver driver) throws InterruptedException
	{

		String actual=driver.getTitle();
		String Expected=driver.getCurrentUrl();
		
		System.out.println(actual+":Actl");
		System.out.println(Expected+":Exp");
		
		

		if(Expected.contains(actual))
		{
			assertTrue(true);
		}
		else
		{
			assertTrue(false);

		}
	}
}
