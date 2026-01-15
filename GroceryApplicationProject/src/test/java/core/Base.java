package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.constant.Constable;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenshotUtility;

public class Base {
	
	Properties prop; //pre-defined class and prop is the reference variable
	FileInputStream file; //pre-defined class and file is the reference variable
	
	public WebDriver driver; //web driver is an interface
	
	@BeforeMethod(alwaysRun=true) //alwaysRun for grouping to copy base class properties while running grouped test cases
	@Parameters("browsers")
	public void initialiseBrowser(String browsers) throws IOException
	{ 
		 prop = new Properties(); 
		 file = new FileInputStream(Constant.CONFIGFILE);
		 prop.load(file);
		 
		if(browsers.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver(); // it is a constructor to open chrome browser
		}
		else if(browsers.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();  //constructor to open firefox browser
		}
		else if(browsers.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver();
			driver = new EdgeDriver();
		}
		//driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.get(prop.getProperty("URL")); //web site link
		driver.manage().window().maximize();//maximize the web site=maximize()
	}
	
	@AfterMethod(alwaysRun=true)
	
	
	 public void driverQuit(ITestResult iTestResult) throws IOException //ITestResult - predefined interface to manage the lifecycle of a testcase 
	 {
	 if (iTestResult.getStatus() == ITestResult.FAILURE) { ScreenshotUtility
	 screenShot = new ScreenshotUtility(); screenShot.getScreenshot(driver,
	 iTestResult.getName()); } //driver.quit(); 
	}
	 
	
	/*public void closeBrowser() //method to close or quit the browser
	{  
		//driver.close(); //to close the current browser page
		//driver.quit(); //to close the entire web pages.
	}*/

}

