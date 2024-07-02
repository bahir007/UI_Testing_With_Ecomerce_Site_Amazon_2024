package StepsDefinitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSearch {
	
	ChromeDriver driver=new ChromeDriver();
	
	

	@Given("I am on amazon.com home page")
	public void i_am_on_amazon_com_home_page() throws InterruptedException {
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
	}
	
	@When("I input {string} as a product in the search box")
	public void i_input_as_a_product_in_the_search_box(String string) {
		WebElement inputSearch=driver.findElement(By.id("twotabsearchtextbox"));
			inputSearch.sendKeys(string);
	}
	
	

	@When("click on the search button")
	public void click_on_the_search_button() throws InterruptedException {
		WebElement searchButton=driver.findElement(By.id("nav-search-submit-button"));
		searchButton.click();
		Thread.sleep(3000);
	}
	@Then("search result page is displayed as {string}")
	public void search_result_page_is_displayed_as(String producName) {
		String pageTitle=driver.getTitle();
		System.out.println(pageTitle);
		assertEquals(pageTitle, "Amazon.com : "+ producName);
	}

	@And("search result total is {string}")
	public void search_result_total_is(String string) {
		String searchResultText=driver.findElement(By.xpath("//*[@id=\"search\"]/span[2]/div/h1/div/div[1]/div/div/span[1]")).getText();
		String searchResultForTheProduct=driver.findElement(By.xpath("//*[@id=\"search\"]/span[2]/div/h1/div/div[1]/div/div/span[3]")).getText();
		String searchResultFullText=searchResultText+" "+searchResultForTheProduct;
		System.out.println(searchResultFullText);
		assertEquals(searchResultFullText, string);
		driver.quit();
	}

	@When("click on Add to cart button")
	public void click_on_add_to_cart_button() throws InterruptedException {
		WebElement addToCardButton=driver.findElement(By.id("a-autoid-1"));
		addToCardButton.click();
		Thread.sleep(5000);
	}

	@Then("Number of items in cart changes to one")
	public void number_of_items_in_cart_changes_to_one() {
		String cartCountText=driver.findElement(By.id("nav-cart-count")).getText();
		System.out.println(cartCountText);
		assertEquals(cartCountText, "1");
		driver.quit();
	}
	



	
}
