package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.Base;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageNewsTest extends Base {
	@Test
	
	public void createNewNewsItem() throws IOException
	{
		String UserName = ExcelUtility.getStringData(0, 0, "LoginPage");
		String Password = ExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsername(UserName);
		login.enterPassword(Password);
		login.clickOnSubmitButton();
		
		HomePage home=new HomePage(driver);
		home.manageNewsButton();
		
		ManageNewsPage news=new ManageNewsPage(driver);
		news.clickOnAddNewNews();
		FakerUtility faker=new FakerUtility();
	    String newsContent=faker.createRandomContent();
		news.addNewNewsContent(newsContent);
		news.saveNewNews();
	}
	@Test
	
	public void searchForExistingNewsItems() throws IOException
	{
		String UserName = ExcelUtility.getStringData(0, 0, "LoginPage");
		String Password = ExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsername(UserName);
		login.enterPassword(Password);
		login.clickOnSubmitButton();
		
		HomePage home=new HomePage(driver);
		home.manageNewsButton();
		
		ManageNewsPage news=new ManageNewsPage(driver);
		news.clickOnSearchNews();
		news.enterSearchContent();
		news.clickOnSeachButton();
	}
	@Test
	public void refreshTheNewsListingPage() throws IOException
	{
		String UserName = ExcelUtility.getStringData(0, 0, "LoginPage");
		String Password = ExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsername(UserName);
		login.enterPassword(Password);
		login.clickOnSubmitButton();
		
		HomePage home=new HomePage(driver);
		home.manageNewsButton();
		
		ManageNewsPage news=new ManageNewsPage(driver);
		news.clickOnRefreshNews();
	}

}
