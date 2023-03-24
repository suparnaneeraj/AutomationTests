package Pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
    protected WebDriver driver;
    public String productpagetitle;
    public ProductDetailsPage productDetailspage;
    private By productPage = By.className("title");
    private int i=0;
   // private By productlist=By.xpath("//div[@class='inventory_item_name' and text()='"+product+"'");
    private By noOfProductInCart=By.xpath("//span[@class='shopping_cart_badge']");
    
    private By shoppingCart=By.id("shopping_cart_container") ;
    public  ProductsPage(WebDriver driver)
    {
        this.driver=driver;
    	

    }
    public String getProductPageTitle()
    {
        productpagetitle=driver.findElement(productPage).getText();
        return productpagetitle;
    }
    	
    	public void GoToProductDetailsPage(String product)
    	{
//    		WebElement e=driver.findElement(By.xpath("//div[@class='inventory_item_name' and text()='"+product+"']"));
//    		JavascriptExecutor js = (JavascriptExecutor) driver;
//    		js.executeScript("arguments[0].scrollIntoView();", e);
//    		e.click();
    		driver.findElement(By.xpath("//div[@class='inventory_item_name' and text()='"+product+"']")).click();
    		
    	}
    	public String getProductDetailsPage()
    	{
    		productDetailspage=new ProductDetailsPage(this.driver);
    		return productDetailspage.getProductDetails();
    	}
   public void addToCart(List<String> products)
   {
	   for (String item : products)
  		{
		   item=item.replace(" ", "-");
  			driver.findElement(By.id("add-to-cart-"+item.toLowerCase()+"")).click();
  		}

   }
   public String numberOfProductsInCart()
   {
	   return driver.findElement(noOfProductInCart).getText();
	   
   }
   public void goToCart()
   {
	   driver.findElement(shoppingCart).click();
   }
}
