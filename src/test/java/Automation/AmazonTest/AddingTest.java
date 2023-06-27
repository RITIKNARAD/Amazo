package Automation.AmazonTest;

import org.testng.annotations.Test;

import Automation.PageObject.AbstractBase;
import Automation.PageObject.Cart;
import Automation.PageObject.CheckOut;
import Automation.PageObject.Login;
import Automation.PageObject.Wishlist;

public class AddingTest extends AbstractBase{

	String item = "Shoe";
	
    @Test
    public void PlacingOrder()
    {        
    	String item = "watch";
    	Login login = new Login(driver);
        login.loggingIn(id, pass, url);
        Cart ad =  new Cart(driver);
        CheckOut co = ad.searchAndBuy(item);
        co.checkOut();       
    }
    
    @Test
    public void placeOrderWithLink()
    {    	
    	 String url = "https://www.amazon.in/ZEBRONICS-Plus-Supporting-Ice-Camo/dp/B09MWHPQNS/ref=sr_1_5?crid=2HJPS0NPWA84S&keywords=zeb+vita+plus&qid=1683257572&sprefix=%2Caps%2C189&sr=8-5";
    	 Login login = new Login(driver);
         login.loggingIn(id, pass, url);
         Cart ad =  new Cart(driver);
         CheckOut co = ad.buy();
         co.checkOut();
    	 
    }
	
    @Test
	public void toCart()
	{
		String item = "Pen";
    	Login log = new Login(driver);
		log.loggingIn(id, pass, url);
		Cart ad =  new Cart(driver);
		ad.searchAndAddtocart(item);
	}
	
	@Test
	public void toWishlist()
	{
		//String item = "Book";
		Login log = new Login(driver);
		log.loggingIn(id, pass, url);
		Wishlist ad = new Wishlist(driver);
		ad.searchAndWishlist(item);
	}
	
	 @Test
	    public void addToWishlistWithLink()
	    {    	
	    	 String url = "https://www.amazon.in/12Pcs-Premium-Microfiber-Cleaning-Cloths/dp/B08B13G5B4/?_encoding=UTF8&pd_rd_w=nV4OD&content-id=amzn1.sym.1ad0dd8e-e519-4e43-8668-d70bf10aa368&pf_rd_p=1ad0dd8e-e519-4e43-8668-d70bf10aa368&pf_rd_r=Y0HTYYWGDSZ2VFY7A2DG&pd_rd_wg=Pv6jN&pd_rd_r=d471d6ff-4be9-49ce-9c9c-831630767234&ref_=pd_gw_trq_ed_sj9137ho";
	    	 Login login = new Login(driver);
	         login.loggingIn(id, pass, url);
	         Wishlist ad = new Wishlist(driver);
	         ad.add();         
	    }
	
	
}
