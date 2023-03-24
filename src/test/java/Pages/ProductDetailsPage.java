package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProductDetailsPage {
	private WebDriver driver;
	private By addToCartButton=By.xpath("//button[text()='Add to cart']");
	private By backToProducts=By.id("back-to-products");
	private By getProductName =By.cssSelector("div[class='inventory_details_name large_size']");
	public ProductDetailsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void addToCart()
	{
		driver.findElement(addToCartButton).click();
	}
	public void backToProducts()
	{
		driver.findElement(backToProducts).click();
	}
	public String getProductDetails()
	{
		return driver.findElement(getProductName).getText();
	}
	public void backToProductsPage()
	{
		driver.findElement(backToProducts).click();
	}

	
}
