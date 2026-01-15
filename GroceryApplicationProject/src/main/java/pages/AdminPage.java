package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminPage {
	
	public WebDriver driver;
	PageUtility pu = new PageUtility();

	public AdminPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this); //to initialise elements initElements is used
	}
	
	@FindBy(linkText = "New") WebElement newLink;
	@FindBy(linkText = "Search") WebElement searchLink;
	@FindBy(linkText = "Reset") WebElement resetLink;
	@FindBy(id = "username") WebElement new_UsernameTextBox;
	@FindBy(id = "password") WebElement new_PasswordTextBox;
	@FindBy(id = "user_type") WebElement new_UserTypeDropdown;
	@FindBy(name = "Create") WebElement saveButton;
	@FindBy(id = "un") WebElement search_UsernameTextBox;
	@FindBy(id = "ut") WebElement search_UserTypeDropdown;
	@FindBy(name = "Search") WebElement searchButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successMessage;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]") WebElement usernameField;
	@FindBy(xpath="//h1[@class='m-0 text-dark']") WebElement adminUsersText;
	
	public AdminPage clickOnNewLinkOnTop()
	{
		newLink.click();
		return this;
	}
	
	public AdminPage enterUsernameInNewSection(String newUsernameValue)
	{
		new_UsernameTextBox.sendKeys(newUsernameValue);
		return this;
	}
	
	public AdminPage enterPasswordInNewSection(String newPasswordValue)
	{
		new_PasswordTextBox.sendKeys(newPasswordValue);
		return this;
	}
	
	public AdminPage selectUserTypeValueInNewSection(int index1)
	{
		/*Select s1 = new Select(new_UserTypeDropdown);
		s1.selectByIndex(index1);*/
		pu.selectDragDropWithIndex(new_UserTypeDropdown, index1);
		return this;
	}
	
	public AdminPage clickOnSaveButton()
	{
		saveButton.click();
		return this;
	}
	
	public AdminPage clickOnSearchLinkOnTop()
	{
		searchLink.click();
		return this;
	}
	
	public AdminPage enterUsernameInSearchSection(String searchUsernameValue)
	{
		search_UsernameTextBox.sendKeys(searchUsernameValue);
		return this;
	}
	
	public AdminPage selectUserTypeValueInSearchSection(int index2)
	{
		/*Select s2 = new Select(search_UserTypeDropdown);
		s2.selectByIndex(index2);*/
		pu.selectDragDropWithIndex(search_UserTypeDropdown, index2);
		return this;
	}
	
	public AdminPage clickOnSearchButton()
	{
		searchButton.click();
		return this;
	}
	
	public AdminPage clickOnResetLink()
	{
		resetLink.click();
		return this;
	}
	
	public boolean verifySuccessMessageOnAdminPage()
	{
		return successMessage.isDisplayed();
	}
	
	public String getUsernameValue()
	{
		return usernameField.getText();
	}
	
	public boolean verifyAdminUsersTextOnAdminPage()
	{
		return adminUsersText.isDisplayed();
	}
}
