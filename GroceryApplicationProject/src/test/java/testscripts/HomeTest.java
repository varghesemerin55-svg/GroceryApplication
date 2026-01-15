package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import core.Base;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base{
	HomePage hp;
	
	@Test(description="User is trying to logout from the website")
	public void validateUserLogout() throws IOException
	{
		LoginPage lp = new LoginPage(driver);
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		hp = lp.clickOnSignInButton();
		hp.clickOnAdminLink();
		lp = hp.clickOnLogoutLink();
		String expectedPageTitle = "7rmart supermarket";
		String actualPageTitle = lp.getPageTitle();
		Assert.assertEquals(actualPageTitle, expectedPageTitle, Constant.LOGOUTFAILUREERROR);
	}

}
