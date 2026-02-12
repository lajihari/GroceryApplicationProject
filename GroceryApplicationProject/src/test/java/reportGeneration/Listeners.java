package reportGeneration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import automationCore.Base;
import utilities.ExtentReportUtility;

public class Listeners extends Base implements ITestListener {//ITestListener-interface-gives properties of listener
	ExtentTest test; 
 	ExtentReports extent = ExtentReportUtility.createExtentReports(); 
 	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); 
  
 	public void onTestStart(ITestResult result) { //all methods are automatically executed before each test method
  
 		ITestListener.super.onTestStart(result); 
 		test = extent.createTest(result.getMethod().getMethodName()); //fetch the method name and attach to the report
 		extentTest.set(test); 
  
 	} 
  
 	public void onTestSuccess(ITestResult result) { //on test case pass time
  
 		ITestListener.super.onTestSuccess(result); 
 		extentTest.get().log(Status.PASS, "Test Passed"); 
  
 	} 
  
 	public void onTestFailure(ITestResult result) { //on test case fail time
  
 		ITestListener.super.onTestFailure(result); 
 		 
 		extentTest.get().log(Status.FAIL, "Test Failed"); 
 		extentTest.get().fail(result.getThrowable()); 
 		 
 		WebDriver driver = null; 
 		 
 		String testMethodName = result.getMethod().getMethodName(); 
 		 
 		try { 
 			 
 			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver") 
 					.get(result.getInstance()); 
 		} catch (IllegalArgumentException e) { 
  
 			e.printStackTrace(); //failed reason to be available in report
 		} catch (IllegalAccessException e) { 
  
 			e.printStackTrace(); 
 		} catch (NoSuchFieldException e) { 
  
 			e.printStackTrace(); 
 		} catch (SecurityException e) { 
  
 			e.printStackTrace(); 
 		} 
  
 		try { 
 			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver") 
 					.get(result.getInstance()); 
 		} catch (Exception e) { 
 		} 
 	} 
  
 	public void onTestSkipped(ITestResult result) { //on test case skip
 		 
 		ITestListener.super.onTestSkipped(result); 
 		extentTest.get().log(Status.SKIP, "Test Skipped"); 
 		String testMethodName = result.getMethod().getMethodName(); 
  
 	} 
  
 	public void onTestFailedButWithinSuccessPercentage(ITestResult result) { 
  
 		ITestListener.super.onTestFailedButWithinSuccessPercentage(result); 
 	} 
  
 	public void onTestFailedWithTimeout(ITestResult result) { 
  
 		ITestListener.super.onTestFailedWithTimeout(result); 
 	} 
  
 	public void onStart(ITestContext context) { 
  
 		ITestListener.super.onStart(context); 
 	} 
  
 	public void onFinish(ITestContext context) { 
  
 		ITestListener.super.onFinish(context); 
 		extent.flush(); //flush-to generate report in correct format
 	}
	

}
