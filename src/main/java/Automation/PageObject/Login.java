package Automation.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login
{
    WebDriver driver;
    
    public Login(WebDriver driver)
    {
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }


	@FindBy(xpath = "//a[contains(text(), 'Sign in securely')]")
    WebElement signIn;
    
    @FindBy(id = "ap_email")
    WebElement email;
    
    @FindBy(id = "ap_password")
    WebElement password;
    
    @FindBy(id = "continue")
    WebElement continu;
    
    @FindBy(id = "signInSubmit")
    WebElement submit;
    
    @FindBy(id = "nav-link-accountList")
    WebElement accounts;
    
    
    public void loggingIn(String id, String pass, String url)
    {
    	driver.get(url);
    	accounts.click();
    	email.sendKeys(id);
    	continu.click();
    	password.sendKeys(pass);
    	submit.click();
    }

}
