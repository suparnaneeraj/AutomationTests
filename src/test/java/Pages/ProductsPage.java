package Pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.GetWebElements;

public class ProductsPage extends GetWebElements{
    protected WebDriver driver;
    public String productpagetitle,noOfProductInCart="//span[@class='shopping_cart_badge']",shoppingCart="shopping_cart_container",productPage="title";
    public ProductDetailsPage productDetailspage;
   // private By productPage = By.className("title");
    private int i=0;
   // private By productlist=By.xpath("//div[@class='inventory_item_name' and text()='"+product+"'");
//    private By noOfProductInCart=By.xpath("//span[@class='shopping_cart_badge']"); 
//    private By shoppingCart=By.id("shopping_cart_container") ;    
    public  ProductsPage(WebDriver driver)
    {
       super(driver);
    
    }
    public String getProductPageTitle()
    {
        productpagetitle=getClassNameElement(productPage).getText();
        return productpagetitle;
    }
    	
    	public void GoToProductDetailsPage(String product)
    	{
    		getXpathElement("//div[@class='inventory_item_name' and text()='"+product+"']").click();
    		
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
  			getIdElement("add-to-cart-"+item.toLowerCase()+"").click();
  		}

   }
   public String numberOfProductsInCart()
   {
	   return getXpathElement(noOfProductInCart).getText();
	   
   }
   public void goToCart()
   {
	  getIdElement(shoppingCart).click();
   }
}
