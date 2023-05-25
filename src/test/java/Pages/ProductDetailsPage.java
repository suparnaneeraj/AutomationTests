package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utility.GetWebElements;


public class ProductDetailsPage extends GetWebElements
{
	private WebDriver driver;
	String addToCartButton="//button[text()='Add to cart']",backToProducts="back-to-products",getProductName="div[class='inventory_details_name large_size']";
//	private By addToCartButton=By.xpath("//button[text()='Add to cart']");
//	private By backToProducts=By.id("back-to-products");
//	private By getProductName =By.cssSelector("div[class='inventory_details_name large_size']");
	
	public ProductDetailsPage(WebDriver driver)
	{
		super(driver);
	}
	
	public void addToCart()
	{
		getXpathElement(addToCartButton).click();
	}
	public void backToProducts()
	{
		getIdElement(backToProducts).click();
	}
	public String getProductDetails()
	{
		return getCSSSelectorElement(getProductName).getText();
	}


	
}
