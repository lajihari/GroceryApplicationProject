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

public class AdminUserPage {
public WebDriver driver;
	
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
	
	//Search
	@FindBy(id="un")WebElement valueTosearch;
	@FindBy(id="ut")WebElement searchType;
	@FindBy(xpath="//button[@name='Search']")WebElement clickOnsearchButton;
	
	public void addnewUserButtonClick()
	{
		addnewButton.click();
	}
	public void searchUserButtonClick()
	{
		searchButton.click();
	}
	public void refreshButtonClick()
	{
		refreshButton.click();
	}
	public void addNewUserUserNameInUserNameField(String newUserName)
	{
		newuserName.sendKeys(newUserName);
	}
	public void addNewUserPasswordInPasswordField(String newPassword)
	{
		newpassword.sendKeys(newPassword);
	}
	public void saveNewUserByUsingNewUserNameAndPassword()
	{
		Select select=new Select(userTypeValue);
		select.selectByValue("admin");
		saveUser.click();
	}
	public void enterUsernameInSearchUserNameField(String searchUserName)
	{
		valueTosearch.sendKeys(searchUserName);
	}
	public void selectUserTypeFromUserTypeDropDown()
	{
		Select select=new Select(searchType);
		select.selectByValue("admin");
		searchType.click();
	}
	public void searchUsingExistingUsernameAndUserType()
	{
		clickOnsearchButton.click();
	}
}
