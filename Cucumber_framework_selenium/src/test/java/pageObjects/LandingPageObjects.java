package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPageObjects {
	
	public WebDriver driver;
	
	public LandingPageObjects(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By Search = By.xpath("//input[@type='search']");
	By productName = By.cssSelector("h4.product-name");
	By topDeals = By.linkText("Top Deals");
	
	public void searchitem(String name)
	{
		driver.findElement(Search).sendKeys(name);
	}
	
	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}

	public void switchToOffersPage()
	{
		driver.findElement(topDeals).click();
	}
	
}
