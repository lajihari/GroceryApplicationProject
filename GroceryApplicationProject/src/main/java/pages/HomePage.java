package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//log-out functionality
	
	@FindBy(xpath = "//a[@class='nav-link' and @data-toggle='dropdown']")
	WebElement adminButton;
	@FindBy(xpath = "//a[@class='dropdown-item'][2]")
	WebElement logoutButton;
	
	//admin-user tile
	@FindBy(xpath = " //p[text()='Admin Users']/ancestor::div[@class='small-box bg-info']//i[@class='fas fa-arrow-circle-right']")
	WebElement adminUsers;
	
	//manage-news tile
	@FindBy(xpath="//p[text()='Manage News']/ancestor::div[@class='small-box bg-info']/a[text()='More info ']/i[@class=\"fas fa-arrow-circle-right\"]")
	WebElement manageNews;
	
	public HomePage openUserProfileMenu()//for -logout
	{
		adminButton.click();
		return this;
	}
	
	public LoginPage clickOnLogoutOption()
	{
		logoutButton.click();
		return new LoginPage(driver);
	}
	public AdminUserPage navigateToAdminUsersPage()
	{
		adminUsers.click();
		return new AdminUserPage(driver);
	}
	public ManageNewsPage navigateToManageNewsPage()
	{
		manageNews.click();
		return new ManageNewsPage(driver);
	}
	
}