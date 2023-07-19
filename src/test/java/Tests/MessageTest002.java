package Tests;

import POMpages.MessengerPage;
import TestBase.BaseClass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class MessageTest002 extends BaseClass{

	



	@Test
	public void Test() throws InterruptedException
	{
		
		MessengerPage msg=new MessengerPage(driver);
		msg.messageData();	
		
	}
	
}
