package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	HomePage home;
	@Test(priority=1,description="Validating User Login with Valid Credentials",groups= {"smoke"})
	public void verifyUserLoginWithValidCredentials() throws IOException
	{
		String UserName=ExcelUtility.getStringData(0, 0,"LoginPage");
		String Password=ExcelUtility.getStringData(0, 1,"LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUserNameField(UserName).enterPasswordOnPasswordField(Password);
		home=login.clickOnSubmitButton();
		boolean dashBoardDisplay=login.isDashboardDisplayed();
		Assert.assertTrue(dashBoardDisplay,Constants.VALIDCREDENTIALERROR);
		
	}
	@Test(priority=2,description="Validating User Login with Valid Username and Invalid Password")
	public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException
	{
		String UserName=ExcelUtility.getStringData(1, 0,"LoginPage");
		String Password=ExcelUtility.getStringData(1, 1,"LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUserNameField(UserName).enterPasswordOnPasswordField(Password).clickOnSubmitButton();
		String expected="7rmart supermarket";
		String actual=login.getLoginText();
		Assert.assertEquals(actual, expected,Constants.INVALIDPASSWORDERROR);
	}
	@Test(priority=3,description="Validating User Login with InValid Username and valid Password")
	public void verifyUserLoginWithValidPasswordAndInvalidUsername() throws IOException
	{
		String UserName=ExcelUtility.getStringData(2, 0,"LoginPage");
		String Password=ExcelUtility.getStringData(2, 1,"LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUserNameField(UserName).enterPasswordOnPasswordField(Password).clickOnSubmitButton();
		boolean dashboardVisible = login.isDashboardDisplayed();
	    Assert.assertFalse(dashboardVisible,Constants.INVALIDPASSWORDERROR);
		
	}
	@Test(priority=4,description="Validating User Login with Invalid credentials",groups= {"smoke"},dataProvider = "loginProvider")
	public void verifyUserLoginWithInvalidCredentials(String UserName,String Password) throws IOException
	{
		//String UserName=ExcelUtility.getStringData(3, 0,"LoginPage");
		//String Password=ExcelUtility.getStringData(3, 1,"LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUserNameField(UserName).enterPasswordOnPasswordField(Password).clickOnSubmitButton();
		boolean dashboardVisible = login.isDashboardDisplayed();
	    Assert.assertFalse(dashboardVisible,Constants.INVALIDCREDENTIALERROR);
	}
	 @DataProvider(name = "loginProvider") 
	 	public Object[][] getDataFromDataProvider() throws IOException { 
	  
	 		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" }, 
	 				// new Object[] {ExcelUtility.getStringData(3, 
	 				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")} 
	 		}; 
	 	}

}
