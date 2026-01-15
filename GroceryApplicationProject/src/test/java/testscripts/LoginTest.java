package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constant;
import core.Base;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	HomePage hp;
	
	@Test(priority=1, description="User is trying to login with valid credentials", groups={"Smoke"})
	public void validateUserLoginWithValidCredentials() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);//since driver will be on same page
		hp = lp.clickOnSignInButton(); //since we need to navigate to homepage here
		Boolean dashboardDisplay = lp.verifyDashBoardTileOnHomePage();
		Assert.assertTrue(dashboardDisplay, Constant.VALIDCREDENTIALERROR);
		//Assert.assertTrue(dashboardDisplay, "User was unable to login with valid credentials");
	}

	@Test(priority=2, description="User is trying to login with invalid user name and valid password", retryAnalyzer=retry.Retry.class)
	public void validateUserWithInvalidUserNameValidPassword() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue).clickOnSignInButton();
		String expectedPageTitle = "7rmart supermarket";
		String actualPageTitle = lp.getPageTitle();
		//Assert.assertEquals(actualPageTitle, expectedPageTitle,"User was able to login even with invalid username");
		Assert.assertEquals(actualPageTitle, expectedPageTitle,Constant.INVALIDUSERNAMEERROR);

	}

	@Test(priority=3, description="User is trying to login with valid user name and invalid password")
	public void validateUserWithvalidUserNameInValidPassword() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(2, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue).clickOnSignInButton();
		String expectedPageTitle = "7rmart supermarket";
		String actualPageTitle = lp.getPageTitle();
		Assert.assertEquals(actualPageTitle, expectedPageTitle,Constant.INVALIDPASSWORDERROR);
	}

	@Test(priority=4, description="User is trying to login with invalid credentials", groups={"Smoke"}, dataProvider = "loginProvider")
	public void validateUserWithInvalidUserNameAndInValidPassword(String usernamevalue,String passwordvalue) throws IOException {
		//String usernamevalue = ExcelUtility.getStringData(3, 0, "LoginPage");
		//String passwordvalue = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue).clickOnSignInButton();
		String expectedPageTitle = "7rmart supermarket";
		String actualPageTitle = lp.getPageTitle();
		Assert.assertEquals(actualPageTitle, expectedPageTitle,Constant.INVALIDCREDENTIALERROR);
	}
	
	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {//returns Object type

	return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
	// new Object[] {ExcelUtility.getStringData(3,0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
	};
	}

}

