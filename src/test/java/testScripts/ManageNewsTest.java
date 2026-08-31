package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.Base;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	@Test
	
	public void manageNewsAdd() throws IOException
	{
		String UserName = ExcelUtility.getStringData(0, 0, "Login");
		String Password = ExcelUtility.getStringData(0, 1, "Login");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsername(UserName);
		login.enterPassword(Password);
		login.clickOnSubmitButton();
		
		HomePage home=new HomePage(driver);
		home.manageNewsButton();
		
		ManageNewsPage news=new ManageNewsPage(driver);
		news.clickOnAddNewNews();
		news.addNewNewsContent();
		news.saveNewNews();
	}
	@Test
	
	public void searchNews() throws IOException
	{
		String UserName = ExcelUtility.getStringData(0, 0, "Login");
		String Password = ExcelUtility.getStringData(0, 1, "Login");
		
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
	public void refreshNews() throws IOException
	{
		String UserName = ExcelUtility.getStringData(0, 0, "Login");
		String Password = ExcelUtility.getStringData(0, 1, "Login");
		
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
