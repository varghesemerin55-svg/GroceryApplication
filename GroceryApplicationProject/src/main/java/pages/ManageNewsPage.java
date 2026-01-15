package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this); //to initialise elements initElements is used
	}
	
	@FindBy(linkText = "New") WebElement newLink;
	@FindBy(linkText = "Search") WebElement searchLink;
	@FindBy(id = "news") WebElement new_NewsTextBox;
	@FindBy(name = "create") WebElement saveButton;
	@FindBy(name = "un") WebElement search_NewsTextBox;
	@FindBy(name = "Search") WebElement searchButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successMessage;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]") WebElement newsField;
	
	public ManageNewsPage clickOnNewLinkOnTop()
	{
		newLink.click();
		return this;
	}
	public ManageNewsPage enterNewsInNewSection(String news)
	{
		new_NewsTextBox.sendKeys(news);
		return this;
	}
	public ManageNewsPage clickOnSaveButton()
	{
		saveButton.click();
		return this;
	}
	public ManageNewsPage clickOnSearchLinkOnTop()
	{
		searchLink.click();
		return this;
	}
	public ManageNewsPage enterNewsInSearchSection(String news)
	{
		search_NewsTextBox.sendKeys(news);
		return this;
	}
	public ManageNewsPage clickOnSearchButton()
	{
		searchButton.click();
		return this;
	}
	
	public boolean verifySuccessMessageOnManageNewsPage()
	{
		return successMessage.isDisplayed();
	}
	
	public String getNewsValue()
	{
		return newsField.getText();
	}
}
