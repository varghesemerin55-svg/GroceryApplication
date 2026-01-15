package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	public WebDriver driver;
	WaitUtility wu = new WaitUtility();
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this); //to initialise elements initElements is used
		
	}
	@FindBy(xpath="//input[@name='username']") WebElement username;
	@FindBy(xpath="//input[@name='password']") WebElement password;
	@FindBy(xpath="//button[@class='btn btn-dark btn-block']") WebElement signin;
	@FindBy(xpath="//b[text()='7rmart supermarket']") WebElement pageTitle;
	@FindBy(xpath="//p[text()='Dashboard']") WebElement dashboardTile;


	public LoginPage enterUserNameOnUserNameField(String usernamevalue) {
		username.sendKeys(usernamevalue);
		return this;
	}
	
	public LoginPage enterPasswordOnPasswordField(String passwordvalue) {
		password.sendKeys(passwordvalue);
		return this;
	}
	
	public HomePage clickOnSignInButton() {
		wu.waitUntilElementToBeClickable(driver, signin); //Applying wait utility method
		signin.click();
		return new HomePage(driver);//to pass the control of driver from Login Page to Homepage
	}
	
	public String getPageTitle()
	{
		return pageTitle.getText();
	}
	
	public boolean verifyDashBoardTileOnHomePage()
	{
		return dashboardTile.isDisplayed();
	}

}
