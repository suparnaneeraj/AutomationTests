package Products;

import org.junit.Assert;

import Pages.LoginPage;
import Pages.ProductsPage;
import Utility.WebDriverClass;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductsStepDefinition {

	LoginPage loginPage;
	ProductsPage productPage;
	String productdetails;
	WebDriverClass webDriverClass=new WebDriverClass()	;
	@Before
	    public void setUp()
	    {
	        webDriverClass.CreateWebDriver();

	    }
	
	@Given("^the user is in products page$")
	public void the_user_is_in_products_page() {
		loginPage=new LoginPage(webDriverClass.getDriver());
		loginPage.EnterCredentials("standard_user", "secret_sauce");
		loginPage.Login();
	}
	
	@When("^user clicks on product \"([^\"]*)\" $")
	public void user_clicks_on_product(String product)
	{
		Assert.assertTrue(productPage.productpagetitle.equals("Products"));
		productPage=new ProductsPage(webDriverClass.getDriver());
		productPage.GoToProductDetailsPage(product);
		productdetails=product;
	}
	
	@Then("^user is navigated to product details page$")
	public void user_is_navigated_to_product_details_page()
	{
		Assert.assertTrue(productPage.getProductDetailsPage().equals(productdetails));
	}
	

}
