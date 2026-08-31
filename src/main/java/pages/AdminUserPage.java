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
	
	@FindBy(xpath="//a[@onclick=\"click_button(1)\"]")WebElement newButton;
	@FindBy(xpath="//a[@onclick=\"click_button(2)\"]")WebElement searchButton;
	@FindBy(xpath="//a[@class=\"btn btn-rounded btn-warning\"]")WebElement refreshButton;
	
	//new users add
	@FindBy(id="username")WebElement userNameValue;
	@FindBy(id="password")WebElement passwordValue;
	@FindBy(id="user_type")WebElement userTypeValue;
	@FindBy(xpath = "//button[@type='submit' and @name='Create']")WebElement saveUser;
	
	//Search
	@FindBy(id="un")WebElement searchValue;
	@FindBy(id="ut")WebElement searchType;
	@FindBy(xpath="//button[@name='Search']")WebElement searchButton1;
	
	public void newButtonClick()
	{
		newButton.click();
	}
	public void searchButtonClick()
	{
		searchButton.click();
	}
	public void refreshButtonClick()
	{
		refreshButton.click();
	}
	public void addNewUserUserName(String newUserName)
	{
		userNameValue.sendKeys(newUserName);
	}
	public void addNewUserPassword(String newPassword)
	{
		passwordValue.sendKeys(newPassword);
	}
	public void addNewUserSubmit()
	{
		Select select=new Select(userTypeValue);
		select.selectByValue("admin");
		saveUser.click();
	}
	public void searchByUsername(String searchUserName)
	{
		searchValue.sendKeys(searchUserName);
	}
	public void searchByUserType()
	{
		Select select=new Select(searchType);
		select.selectByValue("admin");
		searchType.click();
	}
	public void searchByUsernameAndUserType()
	{
		searchButton1.click();
	}
}
