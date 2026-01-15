package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import core.Base;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminTest extends Base{
	HomePage hp;
	AdminPage ap;
	
	@Test(priority = 1, description="User is trying to add a new Admin User")
	public void validateAddNewUsers() throws IOException
	{
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		hp = lp.clickOnSignInButton();
		
		ap= hp.clickOnAdminUsersMoreInfoLink();
		
		RandomDataUtility rdata = new RandomDataUtility();
		String newUsernameValue = rdata.randomusername();
		String newPasswordValue = rdata.randomPassword();
		//String newUsernameValue = ExcelUtility.getStringData(0, 0, "AdminPage");
		//String newPasswordValue = ExcelUtility.getStringData(0, 1, "AdminPage");
		ap.clickOnNewLinkOnTop().enterUsernameInNewSection(newUsernameValue).enterPasswordInNewSection(newPasswordValue).selectUserTypeValueInNewSection(2).clickOnSaveButton();
		Boolean successMessageDisplay = ap.verifySuccessMessageOnAdminPage();
		Assert.assertTrue(successMessageDisplay, Constant.NEWADMINUSERERROR);
	}
	
	@Test(priority = 2, description="User is trying to search an Admin User")
	public void validateSearchUsers() throws IOException
	{
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		hp = lp.clickOnSignInButton();
		
		hp.clickOnAdminUsersMoreInfoLink();
		
		String searchUsernameValue = ExcelUtility.getStringData(0, 0, "AdminPage");
		
		ap.clickOnSearchLinkOnTop().enterUsernameInSearchSection(searchUsernameValue).selectUserTypeValueInSearchSection(2).clickOnSearchButton();
		
		String actualUsernameValue = ap.getUsernameValue();
		Assert.assertEquals(actualUsernameValue, searchUsernameValue, Constant.SEARCHADMINUSERERROR);
		
	}

	@Test(priority = 3, description="User is trying to click on Reset Link")
	public void validateResetLink() throws IOException
	{
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage lp = new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		hp = lp.clickOnSignInButton();
		
		hp.clickOnAdminUsersMoreInfoLink();
		
		ap.clickOnResetLink();
		
		Boolean adminUsersText = ap.verifyAdminUsersTextOnAdminPage();
		Assert.assertTrue(adminUsersText, Constant.RESETPAGEERROR);
	}

}
