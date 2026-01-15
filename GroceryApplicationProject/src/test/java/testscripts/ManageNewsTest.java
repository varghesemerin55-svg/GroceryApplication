package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import core.Base;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{
	HomePage hp;
	ManageNewsPage mnp;
	
	@Test(priority = 1, description="User is trying to add a News")
	public void validateAddNews() throws IOException
	{
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		hp = lp.clickOnSignInButton();
		
		mnp = hp.clickOnManageNewsMoreInfoLink();
		
		String news = ExcelUtility.getStringData(0, 0, "AdminPage");
		mnp.clickOnNewLinkOnTop().enterNewsInNewSection(news).clickOnSaveButton();
		
		Boolean successMessageDisplay = mnp.verifySuccessMessageOnManageNewsPage();
		Assert.assertTrue(successMessageDisplay, Constant.ADDNEWSERROR);
	}
	
	@Test(priority = 2, description="User is trying to search a News")
	public void validateSearchNews() throws IOException
	{
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		hp = lp.clickOnSignInButton();
		
		mnp = hp.clickOnManageNewsMoreInfoLink();
		
		String news = ExcelUtility.getStringData(0, 0, "AdminPage");
		mnp.clickOnSearchLinkOnTop().enterNewsInSearchSection(news).clickOnSearchButton();
		
		String actualNews = mnp.getNewsValue();
		Assert.assertEquals(actualNews, news, Constant.SEARCHNEWSERROR);
	}

}
