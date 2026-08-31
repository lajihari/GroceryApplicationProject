package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test(priority=1,description="Validating User Login with Valid Credentials")
	public void verifyUserLoginWithValidCredentials() throws IOException
	{
		String UserName=ExcelUtility.getStringData(0, 0,"Login");
		String Password=ExcelUtility.getStringData(0, 1,"Login");
		LoginPage login=new LoginPage(driver);
		login.enterUsername(UserName);
		login.enterPassword(Password);
		login.clickOnSubmitButton();
		
	}
	@Test(priority=2,description="Validating User Login with Valid Username and Invalid Password")
	public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException
	{
		String UserName=ExcelUtility.getStringData(1, 0,"Login");
		String Password=ExcelUtility.getStringData(1, 1,"Login");
		LoginPage login=new LoginPage(driver);
		login.enterUsername(UserName);
		login.enterPassword(Password);
		login.clickOnSubmitButton();
	}
	@Test(priority=3,description="Validating User Login with InValid Username and valid Password")
	public void verifyUserLoginWithValidPasswordAndInvalidUsername() throws IOException
	{
		String UserName=ExcelUtility.getStringData(2, 0,"Login");
		String Password=ExcelUtility.getStringData(2, 1,"Login");
		LoginPage login=new LoginPage(driver);
		login.enterUsername(UserName);
		login.enterPassword(Password);
		login.clickOnSubmitButton();
	}
	@Test(priority=4,description="Validating User Login with Invalid credentials")
	public void verifyUserLoginWithInvalidCredentials() throws IOException
	{
		String UserName=ExcelUtility.getStringData(3, 0,"Login");
		String Password=ExcelUtility.getStringData(3, 1,"Login");
		LoginPage login=new LoginPage(driver);
		login.enterUsername(UserName);
		login.enterPassword(Password);
		login.clickOnSubmitButton();
	}

}
