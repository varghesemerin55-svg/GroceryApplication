package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	public void selectDragDropWithValue(WebElement element, String value) {
		Select object=new Select(element);
		object.selectByValue(value);
	}
	
	public void selectDragDropWithIndex(WebElement element, int index) {
		Select object=new Select(element);
		object.selectByIndex(index);
	}
	
	public void clickAcceptOnAlert(WebDriver driver)
	{
		Alert a1 = driver.switchTo().alert();
		a1.accept();
	}
	
	public void clickRejectOnAlert(WebDriver driver)
	{
		Alert a2 = driver.switchTo().alert();
		a2.dismiss();
	}
	
	public void inputTextInAlertAndClickOnOk(WebDriver driver, String message)
	{
		Alert a3 = driver.switchTo().alert();
		a3.sendKeys(message);
		a3.accept();
	}
	
	public void performRightClick(WebDriver driver, WebElement element)
	{
		Actions act =new Actions(driver);
		act.contextClick(element).build().perform();
	}
	
	public void performMouseHover(WebDriver driver, WebElement element)
	{
		Actions act1 =new Actions(driver);
		act1.moveToElement(element).build().perform();
	}

}
