package testScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	HomePage home;
	@Test(description="Verify that the user can logout successfully",retryAnalyzer = retry.Retry.class)
	public void verifyUserCanLogoutSuccessfully() throws IOException
	{
		
		String userName = ExcelUtility.getStringData(0, 0,"LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUserNameField(userName).enterPasswordOnPasswordField(password);
		home=login.clickOnSubmitButton();
		boolean dashboardDisplay=login.isDashboardDisplayed();
		Assert.assertTrue(dashboardDisplay,Constants.VALIDCREDENTIALERROR);
		
		
		//HomePage home = new HomePage(driver);
		home.openUserProfileMenu();
		login=home.clickOnLogoutOption();
		boolean loginPageDisplayed=login.isLoginPageDisplayed();
		Assert.assertTrue(loginPageDisplayed,Constants.LOGOUTERRORMESSAGE);
	}
	
}
