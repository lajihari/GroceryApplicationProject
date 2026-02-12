package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotUtility {
	public void getScreenshot(WebDriver driver, String failedTestCase) throws IOException { 
		  
 		TakesScreenshot scrShot = (TakesScreenshot) driver; //pre-defined interface
 		File screenShot = scrShot.getScreenshotAs(OutputType.FILE); //store screenshots as file
  
 		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date()); //to differentiate the screenshot
  
 		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");// create file in directory 
 		if (!f1.exists()) { //folder name-outputscreenshot
  
 			f1.mkdirs(); 
 		} 
 		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp 
 				+ ".png"; //images are in png format
 		// String destination = f1.getPath() + "//" + failedTestCase + timeStamp + 
 		// ".png"; 
  
 		File finalDestination = new File(destination); //paste the screenshot in the folder
 		FileHandler.copy(screenShot, finalDestination); 
 	}

}
