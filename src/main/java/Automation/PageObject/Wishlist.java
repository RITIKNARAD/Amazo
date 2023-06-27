package Automation.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Wishlist extends AbstractBase{
	
	WebDriver driver;
	int count;
	
	public Wishlist(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBox;
	
	@FindBy(id = "nav-search-submit-button")
    WebElement search;
	
	@FindBy(css = "div[data-component-type= 's-search-result']")
	WebElement firstItem;
	
	@FindBy(id = "add-to-wishlist-button-submit")
	WebElement addWish;
	
	@FindBy(id = "nav-link-accountList")
	WebElement accDetail;
	
	@FindBy(xpath = "//div[@id ='nav-al-your-account']/a[3]/span")
	WebElement wish;
	
	@FindBy(xpath = "//input[@name ='submit.deleteItem']")
	WebElement wl;
	
	@FindBy(xpath = "//a[contains(@id, 'itemName')]")
	List<WebElement> wishItemNames;
	
	
	public int getNumberOfItems() throws InterruptedException
	{
		Actions a = new Actions(driver);
		//because the page only loads 10 items even if there are more, so scrolling down and waiting to fetch all items
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
		return wishItemNames.size();
	}

	public void search(String item)
	{
		searchBox.sendKeys(item);
		search.click();
	}
	
	public void searchAndWishlist(String item)
	{		
		search(item);
		firstItem.click();
		switchToChildTab(driver);
		addWish.click();
	}
	
	public void add()
	{		
		addWish.click();
	}
	
	public void deleteItm() throws InterruptedException
	{
		Actions a = new Actions(driver);
		a.moveToElement(accDetail).build().perform();
		wish.click();
		count = getNumberOfItems();
		for(int i=0; i<count; i++)
		{
			wl.click();
			Thread.sleep(1000);
		}			
	}
	
	public void getList() throws InterruptedException
	{
		Actions a = new Actions(driver);
		a.moveToElement(accDetail).build().perform();
		wish.click();

		count = getNumberOfItems();

		if(count == 0)
		{
			System.out.println("Your Amazon Wishlist is empty!!" + "\n");
			return;
		}
		
		System.out.println(count + " Items" + " in your Amazon Wishlist are-" + "\n");
		
		for(WebElement w : wishItemNames)
		{
			System.out.println(w.getText() + "\n");
		}
	}
	
	
}
