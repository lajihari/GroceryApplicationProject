package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageNewsTest extends Base {
	HomePage home;
	ManageNewsPage news;
	@Test(description="Verifying user can add new news")
	
	public void createNewNewsItem() throws IOException
	{
		String UserName = ExcelUtility.getStringData(0, 0, "LoginPage");
		String Password = ExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUserNameField(UserName).enterPasswordOnPasswordField(Password);
		home=login.clickOnSubmitButton();
		boolean dashBoardDisplay=login.isDashboardDisplayed();
		Assert.assertTrue(dashBoardDisplay,Constants.VALIDCREDENTIALERROR);
		
		//HomePage home=new HomePage(driver);
		news=home.navigateToManageNewsPage();
		
		//ManageNewsPage news=new ManageNewsPage(driver);
		news.clickOnAddNewNews();
		FakerUtility faker=new FakerUtility();
	    String newsContent=faker.createRandomContent();
		news.addNewNewsContent(newsContent);
		news.saveNewNews();
		
		boolean alertMessageDisplay=news.isAlertMessageDisplayed();
		Assert.assertTrue(alertMessageDisplay,Constants.NEWSADDEDERRORMESSAGE);
	}
	@Test(description="Verifying user can search the news list")
	
	public void searchForExistingNewsItems() throws IOException
	{
		String UserName = ExcelUtility.getStringData(0, 0, "LoginPage");
		String Password = ExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUserNameField(UserName).enterPasswordOnPasswordField(Password);
		home=login.clickOnSubmitButton();
		boolean dashBoardDisplay=login.isDashboardDisplayed();
		Assert.assertTrue(dashBoardDisplay,Constants.VALIDCREDENTIALERROR);
		
		//HomePage home=new HomePage(driver);
		news=home.navigateToManageNewsPage();
		
		//ManageNewsPage news=new ManageNewsPage(driver);
		news.clickOnSearchNews();
		news.enterSearchContentToBeSearched();
		news.clickOnSeachButtonAfterEnteringSearchContent();
	}
	@Test(description="Verifying user can refresh the news list")
	public void refreshTheNewsListingPage() throws IOException
	{
		String UserName = ExcelUtility.getStringData(0, 0, "LoginPage");
		String Password = ExcelUtility.getStringData(0, 1, "LoginPage");
		
		
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUserNameField(UserName).enterPasswordOnPasswordField(Password);
		home=login.clickOnSubmitButton();
		boolean dashBoardDisplay=login.isDashboardDisplayed();
		Assert.assertTrue(dashBoardDisplay,Constants.VALIDCREDENTIALERROR);
		
		//HomePage home=new HomePage(driver);
		news=home.navigateToManageNewsPage();
		
		//ManageNewsPage news=new ManageNewsPage(driver);
		news.refreshNewsList();
	}

}
