package testScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	@Test
	public void verifyUserIsAbleToLogout() throws Exception
	{
		
		String UserName = ExcelUtility.getStringData(0, 0, "Login");
		String Password = ExcelUtility.getStringData(0, 1, "Login");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsername(UserName);
		login.enterPassword(Password);
		login.clickOnSubmitButton();
		
		
		HomePage home = new HomePage(driver);
		home.adminButton();
		//home.adminUsersClick();
		home.logoutButton();
	}
	@Test
	public void clickOnAdminUsers() throws IOException
	{
		String UserName = ExcelUtility.getStringData(0, 0, "Login");
		String Password = ExcelUtility.getStringData(0, 1, "Login");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsername(UserName);
		login.enterPassword(Password);
		login.clickOnSubmitButton();
		
		
		HomePage home = new HomePage(driver);
		home.adminUsersClick();
		
	}
	
}
