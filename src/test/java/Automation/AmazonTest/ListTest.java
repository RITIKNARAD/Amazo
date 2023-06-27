package Automation.AmazonTest;

import org.testng.annotations.Test;

import Automation.PageObject.AbstractBase;
import Automation.PageObject.Cart;
import Automation.PageObject.Login;
import Automation.PageObject.Wishlist;

public class ListTest extends AbstractBase{
	
	@Test
	public void fromCart()
	{
    	Login login = new Login(driver);
        login.loggingIn(id, pass, url);
        Cart crt =  new Cart(driver);
        crt.getList();
	}
	
//	@Test
//	public void fromWishlist() throws InterruptedException
//	{
//    	Login login = new Login(driver);
//        login.loggingIn(id, pass, url);
//        Wishlist wl =  new Wishlist(driver);
//        wl.getList();
//	}

}
