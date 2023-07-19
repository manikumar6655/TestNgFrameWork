package Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webDriverUtilities {


	WebDriver driver;
	Actions action;



	public void windowHandle() throws AWTException
	{
		String cw=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();

		for (String w : windows) 
		{
			if(!cw.equals(w))
			{
				driver.switchTo().window(w);
			}

		}
	}

	public void moveToElement(WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).build().perform();
	}

	public void scrollBy()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)", "");

	}



	public void selectByVisibleText(WebElement element,String Name)
	{
		Select s=new Select(element);
		s.selectByVisibleText(Name);


	}
	public void highlightElement(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;


		js.executeScript("arguments[0].style.border='4px solid green'", element);

	}
	public void mouseActions(WebElement TargetElement)
	{

		action =new Actions(driver);
		action.moveToElement(TargetElement).build().perform();

	}

	public void sendKeys(WebElement Element,String text)
	{
		Element.sendKeys(text);
	}

	public void robot() throws AWTException, InterruptedException
	{
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("Robot Method");
	}
	public void waitForElementToLoad(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void sleep() throws InterruptedException
	{
		Thread.sleep(3000);
	}
	public void robot1() throws AWTException, InterruptedException
	{

		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("Robot Method1");



	}
	public void keyboard(WebDriver driver,String button) throws AWTException, InterruptedException
	{

		Actions action=new Actions(driver);
		action.sendKeys(Keys.valueOf(button)).build().perform();

	}
	public void javascripExecutorClick( WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);

	}
}









