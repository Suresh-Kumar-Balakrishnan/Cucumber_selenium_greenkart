package pageObjects;

import org.openqa.selenium.WebDriver;

// Factory Design Pattern 
public class PageObjectManager {
	
	public WebDriver driver;
	public LandingPageObjects landingpageobjects;
    public OfferPageObjects offerpageobjects;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public LandingPageObjects getLandingPage() {	
		landingpageobjects = new LandingPageObjects(driver);
		return landingpageobjects;
	}
	
	public OfferPageObjects getOfferPage()
	{
		offerpageobjects = new OfferPageObjects(driver);
		return offerpageobjects;
	}

}
