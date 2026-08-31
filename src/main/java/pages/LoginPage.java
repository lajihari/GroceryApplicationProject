package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//b[text()='7rmart supermarket']")WebElement loginPageTitleCard;
	@FindBy(name="username")WebElement usernameField;
	@FindBy(name="password")WebElement passwordField;
	@FindBy(xpath="//button[text()='Sign In']")WebElement submit;
	@FindBy(xpath="//p[text()='Dashboard']")WebElement dashboardTile;
	@FindBy(xpath="//b[text()='7rmart supermarket']")WebElement loginText;
	
	public LoginPage enterUsernameOnUserNameField(String UserName)
	{
		usernameField.sendKeys(UserName);
		return this;
	}
	public LoginPage enterPasswordOnPasswordField(String Password)
	{
		passwordField.sendKeys(Password);
		return this;
	}
	public HomePage clickOnSubmitButton()
	{
		submit.click();
		return new HomePage(driver);
	}
	public boolean isDashboardDisplayed() {
	    try {
	        return dashboardTile.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}
	public String getLoginText()
	{
		return loginText.getText();
	}
	public boolean isLoginPageDisplayed()
	{
		return loginPageTitleCard.isDisplayed();
	}
	
}
