package Products;

import org.junit.Assert;

import Pages.LoginPage;
import Pages.ProductsPage;
import Utility.WebDriverClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class ProductsStepDefinition {

	LoginPage loginPage;
	ProductsPage productPage;
	String productdetails;
	WebDriverClass webDriverClass=new WebDriverClass()	;
	@Before
	    public void setUp()
	    {
	        webDriverClass.CreateWebDriver();
	        loginPage=new LoginPage(webDriverClass.getDriver());
	        productPage=new ProductsPage(webDriverClass.getDriver());

	    }
	
	@Given("^the user is in products page$")
	public void the_user_is_in_products_page() throws Throwable{
		try {
		
		loginPage.EnterCredentials("standard_user", "secret_sauce");
		loginPage.Login();
		Assert.assertTrue((productPage.getProductPageTitle()).equals("Products"));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	@When("^user clicks on product \"([^\"]*)\"$")
	public void user_clicks_on_product(String product) throws Throwable
	{
		try
		{
		productPage.GoToProductDetailsPage(product);
		productdetails=product;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	@Then("^user is navigated to product details page$")
	public void user_is_navigated_to_product_details_page() throws Throwable
	{
	try {	
		Assert.assertTrue(productPage.getProductDetailsPage().equals(productdetails));
	}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	@After
    public void tearDown(){

        webDriverClass.getDriver().close();
    }
	

}
