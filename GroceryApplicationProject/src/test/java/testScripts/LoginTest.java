package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test(priority=1,description="Validating User Login with Valid Credentials",groups= {"smoke"})
	public void verifyUserLoginWithValidCredentials() throws IOException
	{
		String UserName=ExcelUtility.getStringData(0, 0,"LoginPage");
		String Password=ExcelUtility.getStringData(0, 1,"LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsername(UserName);
		login.enterPassword(Password);
		login.clickOnSubmitButton();
		boolean dashBoardDisplay=login.isDashboardDisplayed();
		Assert.assertTrue(dashBoardDisplay,"User was unable to Login with valid credentials");
		
	}
	@Test(priority=2,description="Validating User Login with Valid Username and Invalid Password")
	public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException
	{
		String UserName=ExcelUtility.getStringData(1, 0,"LoginPage");
		String Password=ExcelUtility.getStringData(1, 1,"LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsername(UserName);
		login.enterPassword(Password);
		login.clickOnSubmitButton();
		String expected="7rmart supermarket";
		String actual=login.getLoginText();
		Assert.assertEquals(actual, expected,"User was able to Login with Invalid Credentials");
	}
	@Test(priority=3,description="Validating User Login with InValid Username and valid Password")
	public void verifyUserLoginWithValidPasswordAndInvalidUsername() throws IOException
	{
		String UserName=ExcelUtility.getStringData(2, 0,"LoginPage");
		String Password=ExcelUtility.getStringData(2, 1,"LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsername(UserName);
		login.enterPassword(Password);
		login.clickOnSubmitButton();
		boolean dashboardVisible = login.isDashboardDisplayed();
	    Assert.assertFalse(dashboardVisible,"Dashboard is displayed even with invalid password");
		
	}
	@Test(priority=4,description="Validating User Login with Invalid credentials",groups= {"smoke"})
	public void verifyUserLoginWithInvalidCredentials() throws IOException
	{
		String UserName=ExcelUtility.getStringData(3, 0,"LoginPage");
		String Password=ExcelUtility.getStringData(3, 1,"LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsername(UserName);
		login.enterPassword(Password);
		login.clickOnSubmitButton();
	}

}
