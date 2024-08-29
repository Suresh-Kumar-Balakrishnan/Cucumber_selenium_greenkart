package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPagePageObjects {
	
	public WebDriver driver;
	
	public LandingPagePageObjects(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By Search = By.xpath("//input[@type='search']");
	By productName = By.cssSelector("h4.product-name");
	
	public void searchitem(String name)
	{
		driver.findElement(Search).sendKeys(name);
	}
	
	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}

}
