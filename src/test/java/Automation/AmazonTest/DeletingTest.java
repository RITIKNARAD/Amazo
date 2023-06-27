package Automation.AmazonTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import Automation.PageObject.AbstractBase;
import Automation.PageObject.Cart;
import Automation.PageObject.Login;
import Automation.PageObject.Wishlist;


public class DeletingTest extends AbstractBase{

	@Test
	public void deleteCartItems()
	{		
		Login login = new Login(driver);
		login.loggingIn(id, pass, url);
		Cart del = new Cart(driver);
		String message = del.deleteItem();
		Assert.assertEquals("Your Amazon Cart is empty.", message);
	}
	
	@Test
	public void deleteWishListItems() throws InterruptedException
	{		
		Login login = new Login(driver);
		login.loggingIn(id, pass, url);
		Wishlist del = new Wishlist(driver);
		del.deleteItm();
	}
	
}
