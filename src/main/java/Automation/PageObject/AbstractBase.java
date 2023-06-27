package Automation.PageObject;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AbstractBase {

	public WebDriver driver;	
	
	public String url = "https://www.amazon.in/";
	public String id ="";
	public String pass ="";


	public void switchToChildTab(WebDriver driver)
	{
		Set<String> win = driver.getWindowHandles();
		Iterator<String> it = win.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
	}
	
	@BeforeMethod(alwaysRun = true)
	public void startingBrowser()
	{
		//System.setProperty("webdriver.chrome.driver", "D:\\CODES\\JAVA\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser()
	{
		driver.quit();
	}
	
}
