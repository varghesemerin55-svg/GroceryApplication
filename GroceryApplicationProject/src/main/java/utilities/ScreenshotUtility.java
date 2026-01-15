package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {
	
	public void getScreenshot(WebDriver driver, String failedTestCase) throws IOException { //failedTestcase variable to store the failed test case name

		TakesScreenshot scrShot = (TakesScreenshot) driver; //TakesScreenshot is an interface used to take the screenshot...reference creation for the interface
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE); //store the screenshot

		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date()); //store the current time and date

		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");// create file in directory...folder creation named OutputScreenShot
		if (!f1.exists()) {

		f1.mkdirs(); //folder creation
		}
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp
		+ ".png";
		// String destination = f1.getPath() + "//" + failedTestCase + timeStamp +
		// ".png";

		File finalDestination = new File(destination);
		FileHandler.copy(screenShot, finalDestination);
		}

}
