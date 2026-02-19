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
import utilities.FakerUtility;

public class AdminUserTest extends Base {
	@Test
	public void addNewUsersByUsingUsernamAndPassword() throws IOException
	{
		String UserName = ExcelUtility.getStringData(0, 0, "LoginPage");
		String Password = ExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsername(UserName);
		login.enterPassword(Password);
		login.clickOnSubmitButton();
		
		AdminUserPage admin=new AdminUserPage(driver);
		HomePage home=new HomePage(driver);
		home.adminUsersClick();
		admin.addnewUserButtonClick();
		FakerUtility faker=new FakerUtility();
		String newUserName=faker.createRandomUserName();
		String newUserPassword=faker.createRandomPassword();
		
		admin.addNewUserUserNameInUserNameField(newUserName);
		admin.addNewUserPasswordInPasswordField(newUserPassword);
		admin.saveNewUserByUsingNewUserNameAndPassword();
				
	}
	@Test
	public void searchForExistingAdminUsersByUsernameAndUserType() throws IOException
	{
		String UserName = ExcelUtility.getStringData(0, 0, "LoginPage");
		String Password = ExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsername(UserName);
		login.enterPassword(Password);
		login.clickOnSubmitButton();
		
		AdminUserPage admin=new AdminUserPage(driver);
		HomePage home=new HomePage(driver);
		home.adminUsersClick();
		admin.searchUserButtonClick();
		
		String existingUserName=ExcelUtility.getStringData(0, 0,"AdminSearch");
		admin.enterUsernameInSearchUserNameField(existingUserName);
		admin.selectUserTypeFromUserTypeDropDown();
		admin.searchUsingExistingUsernameAndUserType();
		
	}
	@Test
	public void refreshTheUserList() throws IOException
	{
		String UserName = ExcelUtility.getStringData(0, 0, "LoginPage");
		String Password = ExcelUtility.getStringData(0, 1, "LoginPage");
		
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
