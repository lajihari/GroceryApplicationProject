package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class ManageNewsPage {
public WebDriver driver;
WaitUtility wait=new WaitUtility();

	
	public ManageNewsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement addNewNews;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement searchNews;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']")WebElement refreshNews;
	
	//managenews-add
	@FindBy(id="news")WebElement addNewsContent;
	@FindBy(xpath="//button[@type='submit']")WebElement saveNews;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertMessage;
	
	//search-news
	@FindBy(xpath="//input[@name='un']")WebElement searchByNews;
	@FindBy(xpath="//button[@name='Search']")WebElement searchButton;
	
	public ManageNewsPage clickOnAddNewNews()
	{
		
		addNewNews.click();
		return this;
	}
	public ManageNewsPage clickOnSearchNews()
	{
		
		searchNews.click();
		return this;
	}
	public ManageNewsPage refreshNewsList()
	{
		
		refreshNews.click();
		return this;
	}
	public ManageNewsPage addNewNewsContent(String newNewsContent)
	{
		addNewsContent.sendKeys(newNewsContent);
		return this;
	}
	public ManageNewsPage saveNewNews()
	{
		saveNews.click();
		return this;
	}
	public ManageNewsPage enterSearchContentToBeSearched()
	{
		searchByNews.sendKeys("New News Added");
		return this;
	}
	public ManageNewsPage clickOnSeachButtonAfterEnteringSearchContent()
	{
		searchButton.click();
		return this;
	}
	public boolean isAlertMessageDisplayed()
	{
		return alertMessage.isDisplayed();
	}
	

}
