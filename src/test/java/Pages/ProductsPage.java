package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    protected WebDriver driver;
    public String productpagetitle;
    public ProductDetailsPage productDetailspage;
   private String productsArray[]= new String[10];
    private By productPage = By.className("title");
   // private By productlist=By.xpath("//div[@class='inventory_item_name' and text()='"+product+"'");
    
    public  ProductsPage(WebDriver driver)
    {
        this.driver=driver;
    	

    }
    public String getProductPageTitle()
    {
        productpagetitle=driver.findElement(productPage).getText();
        return productpagetitle;
    }
    
    public void addProductsToCart(String product)
   
    {
    	
    	if(product.contains(","))
    	{
    		productsArray=product.split(",");
    		for(int i=0;i< productsArray.length;i++)
    		{
    			driver.findElement(By.xpath("//div[@class='inventory_item_name' and text()='"+productsArray[i]+"']")).click();
    			productDetailspage.addToCart();
    			productDetailspage.backToProducts();
    		}
    	}
    	else
    	{
    		driver.findElement(By.xpath("//div[@class='inventory_item_name' and text()='"+product+"']")).click();
    		productDetailspage.addToCart();
			productDetailspage.backToProducts();
    	}
    }
    	
    	public void GoToProductDetailsPage(String product)
    	{
    		driver.findElement(By.xpath("//div[@class='inventory_item_name' and text()='"+product+"']")).click();
    		
    	}
    	public String getProductDetailsPage()
    	{
    		productDetailspage=new ProductDetailsPage(this.driver);
    		return productDetailspage.getProductDetails();
    	}
   
}
