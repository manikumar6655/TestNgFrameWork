package TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import Utilities.ExcelFileUtility;
import Utilities.Logutilities;
import Utilities.ScreenShotsUtilities;
import Utilities.validations;
import Utilities.webDriverUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {


	public  WebDriver driver;
	public Properties prop=new Properties();
	public FileInputStream fis;
	public ExcelFileUtility eUtil=new ExcelFileUtility();
	public Logutilities logger=new Logutilities();
	public ScreenShotsUtilities screenShot=new ScreenShotsUtilities();
	

	

	

	@BeforeClass
	public void setUp() 
	{
		logger.info("Test Environment setUp");
		try {
			fis=new FileInputStream("./src/test/resources/prop.Properties");
			logger.warn("---Getting file---");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		

		try {
			prop.load(fis);
			logger.warn("---File loaded Successfully----");
		} catch (IOException e) {
			e.printStackTrace();
		}


		if(prop.getProperty("Browser").equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
			logger.error("---Edge Opened Successfully---");
			System.out.println(prop.getProperty("Browser"));

		}

		else if(prop.getProperty("Browser").equalsIgnoreCase("chrome"))
		{
			
			ChromeOptions opt=new ChromeOptions();
	        opt.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(opt);
		}

		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		logger.fatal("---Url laaunched Successfully---");


	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}


