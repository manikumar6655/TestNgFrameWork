package POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.validations;
import Utilities.webDriverUtilities;

public class LoginPage {
	WebDriver driver;
	
	

	
	@FindBy(id="email")
	private WebElement Username;

	@FindBy(id="pass")
	private WebElement Password;

	@FindBy(name="login")
	private WebElement Submitbtn;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public WebElement getUsername() {
		return Username;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getSubmitbtn() {
		return Submitbtn;
	}



}
