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

public class LandingPageGreenkartStepDefinition {

	WebDriver driver;
	String HomePageproductName;
	String ChildPageproductName;
	TextcontextSetup textcontextSetup;
	
	public LandingPageGreenkartStepDefinition(TextcontextSetup textcontextSetup)
	{
		this.textcontextSetup= textcontextSetup;
	}
	
	@Given("user is on the Greenkart login page")
	public void user_is_on_the_greenkart_login_page() {
	    // Write code here that turns the phrase above into concrete actions\
		System.out.println("inside user is on the Greenkart login page");
		WebDriverManager.chromedriver().setup();
		textcontextSetup.driver = new ChromeDriver();
		textcontextSetup.driver.manage().window().maximize();
		textcontextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");	
	 
	}
	
	@When("user searched with the keyword {string} in the home page and extracted the actual product")
	public void user_searched_with_the_keyword_in_the_home_page_and_extracted_the_actual_product(String string) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Inside user is searching with the keyword on the homepage");
		textcontextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(string);
		Thread.sleep(4000);
		textcontextSetup.HomePageproductName = textcontextSetup.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		System.out.println(textcontextSetup.HomePageproductName + " is the extracted product name from the Homepage ---HP");
	}
	

	

}
