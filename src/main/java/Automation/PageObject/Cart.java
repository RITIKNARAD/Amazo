package Automation.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart extends AbstractBase{
	
	WebDriver driver;
	
	public Cart(WebDriver driver)
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
	
	@FindBy(id = "buy-now-button")
	WebElement buyNow;
	
	@FindBy(id = "add-to-cart-button")
	WebElement addCart;
	
	@FindBy(id = "nav-cart-count")
	WebElement cart;
	
//	@FindBy(css = "input[name*='submit.delete']")
//	List<WebElement> deleteCart;
	
	@FindBy(css = "input[name*='submit.delete']")
	WebElement deleteCart;
	
	@FindBy(xpath = "//h1[@class = 'a-spacing-mini a-spacing-top-base']")
	WebElement message;
	
	@FindBy(xpath = "//span[contains(@class, 'sc-product-title')]/span/span[2]")
	List<WebElement> itemNames;
	
	public void search(String item)
	{
		searchBox.sendKeys(item);
		search.click();
	}
	
	public CheckOut searchAndBuy(String item)
	{
		search(item);
		firstItem.click();
		switchToChildTab(driver);
		buyNow.click();
		
		CheckOut co = new CheckOut(driver);
		return co;
	}
	
	public CheckOut buy()
	{
		buyNow.click();
		
		CheckOut co = new CheckOut(driver);
		return co;
	}
	
	public void searchAndAddtocart(String item)
	{		
		search(item);
		firstItem.click();
		switchToChildTab(driver);
		addCart.click();
	}
	
	public String deleteItem()
	{
		cart.click();
		if(Integer.parseInt(cart.getText()) != 0)
		{
			while( Integer.parseInt(cart.getText()) != 0)
			{
				deleteCart.click();
				cart.click();
			}
		}		
		return message.getText();			
	}
	
	public void getList()
	{
		cart.click();
		
		if(itemNames.size() == 0)
		{
			System.out.println("Your Amazon Cart is empty!!" + "\n");
			return;
		}
		
		System.out.println(cart.getText() + " Items " + "in your Amazon Cart are-" + "\n");
		
		for(WebElement w : itemNames)
		{
			System.out.println(w.getText() + "\n");
		}
	}

}
