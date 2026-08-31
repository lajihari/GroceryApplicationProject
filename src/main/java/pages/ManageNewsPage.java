package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
public WebDriver driver;
	
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
	
	//search-news
	@FindBy(xpath="//input[@name='un']")WebElement searchByNews;
	@FindBy(xpath="//button[@name='Search']")WebElement searchButton;
	
	public void clickOnAddNewNews()
	{
		addNewNews.click();
	}
	public void clickOnSearchNews()
	{
		searchNews.click();
	}
	public void clickOnRefreshNews()
	{
		refreshNews.click();
	}
	public void addNewNewsContent()
	{
		addNewsContent.sendKeys("New News Added");
	}
	public void saveNewNews()
	{
		saveNews.click();
	}
	public void enterSearchContent()
	{
		searchByNews.sendKeys("New News Added");
	}
	public void clickOnSeachButton()
	{
		searchButton.click();
	}
	

}
