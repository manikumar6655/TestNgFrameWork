package Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotsUtilities {

	public void CaptureScreenshot(WebDriver driver,String image)
	{
		TakesScreenshot screenshot=(TakesScreenshot)driver;

		File srcFile=screenshot.getScreenshotAs(OutputType.FILE);
		File destFile=new File("./Screenshots/"+image+".png");
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
