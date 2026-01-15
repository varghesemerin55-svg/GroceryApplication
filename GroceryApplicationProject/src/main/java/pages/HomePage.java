package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this); //to initialise elements initElements is used
	}
	
	@FindBy(linkText = "Admin") WebElement adminLink;
	@FindBy(linkText = "Logout") WebElement logoutLink;
	@FindBy(xpath = "//a[contains(@href,'com/admin/list-admin') and @class='small-box-footer']") WebElement adminUsersMoreInfoLink;
	@FindBy(xpath = "//a[contains(@href,'com/admin/list-news') and @class='small-box-footer']") WebElement manageNewsMoreInfoLink;
	
	public HomePage clickOnAdminLink() 
	{
		adminLink.click();
		return this;
	}
	
	public LoginPage clickOnLogoutLink() 
	{
		logoutLink.click();
		return new LoginPage(driver);
	}
	
	public AdminPage clickOnAdminUsersMoreInfoLink()
	{
		adminUsersMoreInfoLink.click();
		return new AdminPage(driver);
	}
	
	public ManageNewsPage clickOnManageNewsMoreInfoLink()
	{
		manageNewsMoreInfoLink.click();
		return new ManageNewsPage(driver);
	}


}
