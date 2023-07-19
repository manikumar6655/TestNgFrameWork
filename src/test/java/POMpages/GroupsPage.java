package POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.BaseClass;
import Utilities.webDriverUtilities;

public class GroupsPage extends BaseClass{

	
	webDriverUtilities u=new webDriverUtilities();
	
	public GroupsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	
	}
	
	
	@FindBy(xpath = "//a[@aria-label=\"Groups\"]")WebElement groups;
	@FindBy(xpath = "//span[text()='Create New Group']")WebElement createGroup;
	@FindBy(xpath = "//label[@aria-label=\"Group name\"]")WebElement groupName;
	@FindBy(xpath = "//span[text()='Choose privacy']")WebElement choosePrivacy;
	@FindBy(xpath = "//span[text()='Public']")WebElement publicGroup;
	@FindBy(xpath = "//span[text()='Create']")WebElement CreateBtn;
	
	
	
	
	public void groupCreation() throws InterruptedException
	{
		
		groups.click();
		driver.navigate().refresh();
		createGroup.click();
		Thread.sleep(2000);
		groupName.sendKeys("Kairos");
		Thread.sleep(2000);
		u.javascripExecutorClick(driver, choosePrivacy);
		u.javascripExecutorClick(driver, publicGroup);
		u.javascripExecutorClick(driver, CreateBtn);
	

		

		
		
	}
	
	
	
	
	
}
