package automationCore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constants;
import utilities.ScreenShotUtility;

public class Base {
	public WebDriver driver;
	Properties prop;
	FileInputStream fs;
	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void browserLaunch(String browser) throws Exception
	{
		prop=new Properties();
		fs=new FileInputStream(Constants.CONFIGFILE);
		prop.load(fs);
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			throw new Exception("Invalid Browser");
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	@AfterMethod(alwaysRun=true)
	 public void driverQuit(ITestResult iTestResult) throws IOException { //ITestResult-predefined interface-to pass the status and manage the life cycle 
		  
 		if (iTestResult.getStatus() == ITestResult.FAILURE) { 
  
 			ScreenShotUtility screenShot = new ScreenShotUtility(); 
 			screenShot.getScreenshot(driver, iTestResult.getName()); 
 		} 
 	driver.quit(); 
  
 	}
}
