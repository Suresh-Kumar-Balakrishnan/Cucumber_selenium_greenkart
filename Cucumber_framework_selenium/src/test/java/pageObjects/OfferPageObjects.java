package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPageObjects {
	
	public WebDriver driver;
	
	public OfferPageObjects(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By searchItem = By.xpath("//input[@type='search']");
	By childProductName = By.cssSelector("tr td:nth-child(1)");
	
	public void searchItem(String name)
	{
		driver.findElement(searchItem).sendKeys(name);
	}
	
	public String getChildProductName()
	{
		return driver.findElement(childProductName).getText();
	}
	
	

}
