package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.TextcontextSetup;

public class OfferPageGreenkartStepDefinition {

	String ChildPageproductName;
	TextcontextSetup textcontextSetup;
	
	public OfferPageGreenkartStepDefinition(TextcontextSetup textcontextSetup)
	{
		this.textcontextSetup= textcontextSetup;
	}
	
	//To making this method as loosely coupled we are going to separate this method into 2 as opening the landing page into the separate method other one to validate 
	@Then("user searched the {string} keyword in the offers page to check the same product is available")
	public void user_searched_the_same_keyword_in_the_offers_page_to_check_the_same_product_is_available(String stringname) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		switchToOfferPage();
		textcontextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(stringname);
		Thread.sleep(2000);
		ChildPageproductName = textcontextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
		System.out.println(ChildPageproductName + " is the extracted product name from the Childpage ----CP");
	}
	
	
	public void switchToOfferPage()
	{
		System.out.println("Inside the method of switch to offer page");
		if(textcontextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
		{
			System.out.println("The driver is already on the offer page");
		}
		else
		{
			System.out.println("The driver is switching to the offer page");
			textcontextSetup.driver.findElement(By.linkText("Top Deals")).click();
			//To handle two different tabs on the same window ( home page - window 1 and offer page - window 2 )
			Set<String> s1 =  textcontextSetup.driver.getWindowHandles();
			Iterator<String> i1 = s1.iterator();
			String parentwindow = i1.next();
			String childWindow = i1.next();
			textcontextSetup.driver.switchTo().window(childWindow);
			
		}
	}
	
	@And("Compare both product name from home and offer page")
	public void Compare_both_product_name_from_home_and_offer_page()
	{
		Assert.assertEquals(textcontextSetup.HomePageproductName, ChildPageproductName);
	}
}
