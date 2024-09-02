package utils;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TextcontextSetup {
	
	public WebDriver driver;
	public String HomePageproductName;
	
	public PageObjectManager pageobjectmanager;
	
	public TextcontextSetup()
	{
		pageobjectmanager = new PageObjectManager(driver);
	}

}
