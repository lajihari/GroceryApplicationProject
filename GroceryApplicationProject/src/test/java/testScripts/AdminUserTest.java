package testScripts;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constant.Constants;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;
import utilities.WaitUtility;

public class AdminUserTest extends Base {
	HomePage home;
	AdminUserPage admin;
	@Test(description="Verify that user can create a new admin user using new username and password")
	public void verifyUserCanAddNewAdminUser() throws IOException
	{
		String userName = ExcelUtility.getStringData(0, 0,"LoginPage");
		String password = ExcelUtility.getStringData(0, 1,"LoginPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUserNameField(userName).enterPasswordOnPasswordField(password);
		home=login.clickOnSubmitButton();
		boolean dashBoardDisplay=login.isDashboardDisplayed();
		Assert.assertTrue(dashBoardDisplay,Constants.VALIDCREDENTIALERROR);
		
		//AdminUserPage admin=new AdminUserPage(driver);
		//HomePage home=new HomePage(driver);
		admin=home.navigateToAdminUsersPage();
		admin.clickOnNewUserInAdminUserpage();
		FakerUtility faker=new FakerUtility();
		String newUserName=faker.createRandomUserName();
		String newUserPassword=faker.createRandomPassword();
		
		admin.addNewUserNameInUserNameField(newUserName).addNewPasswordInPasswordField(newUserPassword).saveNewUserByUsingNewUserNameAndPassword();
		
		boolean alertMessage=admin.isAlertMessageDisplayed();
		Assert.assertTrue(alertMessage,Constants.ADMINUSERADDEDERRORMESSAGE);
				
	}
	@Test(description="Verify that user can search admin user using username and user type")
	public void verifyUserCanSearchAdminUserByUsernameAndUserType() throws IOException
	{
		String userName = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUserNameField(userName).enterPasswordOnPasswordField(password);
		home=login.clickOnSubmitButton();
		boolean dashBoardDisplay=login.isDashboardDisplayed();
		Assert.assertTrue(dashBoardDisplay,Constants.VALIDCREDENTIALERROR);
		
		//AdminUserPage admin=new AdminUserPage(driver);
		//HomePage home=new HomePage(driver);
		admin=home.navigateToAdminUsersPage();
		admin.searchForUser();
		
		String existingUserName=ExcelUtility.getStringData(0, 0,"AdminSearch");
		admin.enterUsernameInSearchUserNameField(existingUserName).selectUserTypeFromUserTypeDropDown().searchUsingExistingUsernameAndUserType();
				
	}
	@Test(description="Verify that user can refresh the admin user list")
	public void verifyUserCanRefreshAdminUserList() throws IOException
	{
		String userName = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUserNameField(userName).enterPasswordOnPasswordField(password);
		home=login.clickOnSubmitButton();
		
		//AdminUserPage admin=new AdminUserPage(driver);
		//HomePage home=new HomePage(driver);
		admin=home.navigateToAdminUsersPage();
		admin.refreshUserList();
		
		
	}
}
