package testScripts;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.ExcelUtilityAddNewUser;

public class AdminUserTest extends Base {
	@Test
	public void verifyNewUsers() throws IOException
	{
		String UserName = ExcelUtility.getStringData(0, 0, "Login");
		String Password = ExcelUtility.getStringData(0, 1, "Login");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsername(UserName);
		login.enterPassword(Password);
		login.clickOnSubmitButton();
		
		AdminUserPage admin=new AdminUserPage(driver);
		HomePage home=new HomePage(driver);
		home.adminUsersClick();
		admin.newButtonClick();
		
		String newUserName=ExcelUtilityAddNewUser.getStringData(0, 0,"User");
		String newUserPassword=ExcelUtilityAddNewUser.getStringData(0, 1,"User");
		
		admin.addNewUserUserName(newUserName);
		admin.addNewUserPassword(newUserPassword);
		admin.addNewUserSubmit();
				
	}
	@Test
	public void verifySearchUsers() throws IOException
	{
		String UserName = ExcelUtility.getStringData(0, 0, "Login");
		String Password = ExcelUtility.getStringData(0, 1, "Login");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsername(UserName);
		login.enterPassword(Password);
		login.clickOnSubmitButton();
		
		AdminUserPage admin=new AdminUserPage(driver);
		HomePage home=new HomePage(driver);
		home.adminUsersClick();
		admin.searchButtonClick();
		
		String newUserName=ExcelUtilityAddNewUser.getStringData(0, 0,"Search");
		admin.searchByUsername(newUserName);
		admin.searchByUserType();
		admin.searchByUsernameAndUserType();
		
	}
	@Test
	public void verifyadminUsersIsVerifyingUserList() throws IOException
	{
		String UserName = ExcelUtility.getStringData(0, 0, "Login");
		String Password = ExcelUtility.getStringData(0, 1, "Login");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsername(UserName);
		login.enterPassword(Password);
		login.clickOnSubmitButton();
		
		AdminUserPage admin=new AdminUserPage(driver);
		HomePage home=new HomePage(driver);
		home.adminUsersClick();
		admin.refreshButtonClick();
	
		
	}
}
