package Products;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;


import Pages.CartPage;
import Pages.LoginPage;
import Pages.ProductDetailsPage;
import Pages.ProductsPage;
import Utility.WebDriverClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ProductsStepDefinition {

	LoginPage loginPage;
	ProductsPage productPage;
	String productdetails;
	CartPage cartPage;
	ProductDetailsPage productDetailsPage;
	List<String> productList = new ArrayList<String>();
	WebDriverClass webDriverClass=new WebDriverClass()	;
	@Before
	    public void setUp()
	    {
	        webDriverClass.CreateWebDriver();
	        webDriverClass.openApplication();
	        loginPage=new LoginPage(webDriverClass.getDriver());
	        productPage=new ProductsPage(webDriverClass.getDriver());
	        cartPage=new CartPage(webDriverClass.getDriver());
	        productDetailsPage=new ProductDetailsPage(webDriverClass.getDriver());
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
	
	@When("^user clicks on add to cart button of product \"([^\"]*)\"$")
	public void user_clicks_on_add_to_cart_button_of_product(String product) throws Throwable
	{
		try
		{
			productPage.addToCart(splitProducts(product));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	@Then("^product \"([^\"]*)\" must be added to cart$")
	public void product_must_be_added_to_cart(String products) throws Throwable
	{
		
		productPage.goToCart();
		
		try
		{
			productList=splitProducts(products);
			Assert.assertTrue("Incorrect number of products in cart", Integer.toString(productList.size()).equals(productPage.numberOfProductsInCart()));
			Assert.assertTrue("Incorrect products in cart",cartPage.productsInCart(productList));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public List<String> splitProducts(String products)
	{
		
   			
			if(products.contains(","))
   			{
				productList=Arrays.asList(products.split(","));
   			}
   			else
   			{
   				productList=Arrays.asList(products);
   			
   			}
		
		return productList;
	}
	
	@Given("^user is on product details page on clicking product \"([^\"]*)\"$")
	public void user_is_on_product_details_page_on_clicking_product(String product) throws Throwable
	{
		try {
		loginPage.EnterCredentials("standard_user", "secret_sauce");
		loginPage.Login();
		productPage.GoToProductDetailsPage(product);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	@And("^user clicks on add to cart button$")
	public void user_clicks_on_add_to_cart_button() throws Throwable
	{
		try
		{
			
			productDetailsPage.addToCart();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	@And("^user navigates to product page$")
	public void user_navigates_to_product_page() throws Throwable
	{
		try
		{
			productDetailsPage.backToProducts();
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
