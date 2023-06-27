package Automation.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOut extends AbstractBase{
	
	WebDriver driver;
	
	public CheckOut(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class= 'a-fixed-left-grid-inner']/span[contains(text(),'Cash on Delivery')]")
	WebElement COD;
	
	@FindBy(id = "orderSummaryPrimaryActionBtn")
	WebElement next;
	
	public void checkOut()
	{
		COD.click();
		next.click();
	}
}
