package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import constant.Constants;
import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUserPage {
public WebDriver driver;
PageUtility page= new PageUtility();
	
	public AdminUserPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@onclick=\"click_button(1)\"]")WebElement addnewButton;
	@FindBy(xpath="//a[@onclick=\"click_button(2)\"]")WebElement searchButton;
	@FindBy(xpath="//a[@class=\"btn btn-rounded btn-warning\"]")WebElement refreshButton;
	
	//new users add
	@FindBy(id="username")WebElement newuserName;
	@FindBy(id="password")WebElement newpassword;
	@FindBy(id="user_type")WebElement userTypeValue;
	@FindBy(xpath = "//button[@type='submit' and @name='Create']")WebElement saveUser;
	@FindBy(xpath="//div[contains(@class,'alert-success')]")WebElement alertMessage;
	
	//Search
	@FindBy(id="un")WebElement valueTosearch;
	@FindBy(id="ut")WebElement searchType;
	@FindBy(xpath="//button[@name='Search']")WebElement clickOnsearchButton;
	
	public AdminUserPage clickOnNewUserInAdminUserpage()
	{
		addnewButton.click();
		return this;
	}
	public AdminUserPage searchForUser()
	{
		searchButton.click();
		return this;
	}
	public AdminUserPage refreshUserList()
	{
		refreshButton.click();
		return this;
	}
	public AdminUserPage addNewUserNameInUserNameField(String newUserName)
	{
		newuserName.sendKeys(newUserName);
		return this;
	}
	public AdminUserPage addNewPasswordInPasswordField(String newPassword)
	{
		newpassword.sendKeys(newPassword);
		return this;
	}
	public AdminUserPage saveNewUserByUsingNewUserNameAndPassword()
	{
		page.selectDropdownWithValue(userTypeValue, Constants.DROPDOWNVALUE1);
		saveUser.click();
		return this;
	}
	public boolean isAlertMessageDisplayed()
	{
	    return alertMessage.isDisplayed();
	}
	public AdminUserPage enterUsernameInSearchUserNameField(String searchUserName)
	{
		valueTosearch.sendKeys(searchUserName);
		return this;
	}
	public AdminUserPage selectUserTypeFromUserTypeDropDown()
	{
		page.selectDropdownWithValue(searchType,Constants.DROPDOWNVALUE1 );
		return this;
	}
	public AdminUserPage searchUsingExistingUsernameAndUserType()
	{
		clickOnsearchButton.click();
		return this;
	}
	
}
