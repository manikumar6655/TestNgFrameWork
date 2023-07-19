package Utilities;

import java.io.FileInputStream;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listenersutilities implements ITestListener{

	
	public ExtentSparkReporter spark;

	public static WebDriver driver;
	public FileInputStream file;
	public ExtentReports extent;
	public ExtentTest test;
	
	public ScreenShotsUtilities ss=new ScreenShotsUtilities();
	//public BaseClass ss=new BaseClass();





	public void onTestStart(ITestResult result) {
		test.log(Status.INFO,"Test is starting");

	}

	public void onTestSuccess(ITestResult result) {

		test.log(Status.PASS,MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN));
		//ss.CaptureScreenshot(driver,"image1");
		


	}

	public void onTestFailure(ITestResult result) {

		test.log(Status.FAIL,MarkupHelper.createLabel(result.getName(),ExtentColor.RED));

	}

	public void onTestSkipped(ITestResult result) {

		test.log(Status.SKIP,MarkupHelper.createLabel(result.getName(),ExtentColor.YELLOW));

	}

	public void onStart(ITestContext context) {

		spark=new ExtentSparkReporter(".\\ExtentReports\\Reports.html");
		extent=new ExtentReports();
		extent.attachReporter(spark);
		test=extent.createTest("Search Functionality");
		test.log(Status.INFO,"Test is starting");
		spark.config().setTheme(Theme.DARK);




	}

	public void onFinish(ITestContext context) {


		test.log(Status.INFO,"Test is completed");
		extent.flush();
	}

}
