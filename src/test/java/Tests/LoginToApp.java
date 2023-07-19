package Tests;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import POMpages.GroupsPage;
import POMpages.LoginPage;
import POMpages.MessengerPage;
import TestBase.BaseClass;
import Utilities.ExcelFileUtility;
import Utilities.validations;
import Utilities.webDriverUtilities;




public class LoginToApp extends BaseClass{

	public webDriverUtilities ut=new webDriverUtilities();
	public validations validate=new validations();

	@Test(priority = 1)
	public void LoginTest() throws EncryptedDocumentException, IOException, InterruptedException {


		String USERNAME = eUtil.readDataFromExcel("Sheet1", 1, 0);
		String PASSWORD = eUtil.readDataFromExcel("Sheet1", 1, 1);
		LoginPage lp=new LoginPage(driver);
		lp.getUsername().sendKeys(USERNAME);
		lp.getPassword().sendKeys(PASSWORD);
		lp.getSubmitbtn().click();
		logger.debug("Test 1 is passed");
		


	}
	
	
	@Test(priority = 2)
	public void verifyLogin() throws InterruptedException
	{
		WebElement element=driver.findElement(By.xpath("//a[@aria-label=\"Facebook\"]"));
		validate.Displayed(element, driver);
		logger.debug("Test 2 is passed");


	}

	@Test(priority = 3)
	public void MessengerTest() throws InterruptedException
	{
		
		MessengerPage msg=new MessengerPage(driver);
		msg.messageData();
		logger.debug("Test 3 is passed");

		
	}

	
	@Test(priority = 4)
	public void verifyMessengerIcon() throws InterruptedException
	{
		WebElement Inbox=driver.findElement(By.xpath("//div[@class='x1ey2m1c x9f619 xds687c x10l6tqk x17qophe x13vifvy']//span[text()='Inbox']"));
		validate.Displayed(Inbox, driver);
		System.out.println("Inbox is displayed");
      	screenShot.CaptureScreenshot(driver, "img2");

		logger.debug("Test 4 is passed");


	}
	
	

	@Test(priority = 5)
	public void GroupsTest() throws InterruptedException
	{
		
		GroupsPage g=new GroupsPage(driver);
      	g.groupCreation();
      	screenShot.CaptureScreenshot(driver, "img1");
      	logger.debug("Test 5 is passed");

	}


	
}
