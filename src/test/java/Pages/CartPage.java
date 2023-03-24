package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
	
	private By pageTitle=By.className("title");
	private By productsInCart=By.className("inventory_item_name");
	List<String> actualProductsInCart=new ArrayList<String>();
	List<String> productsAdded=new ArrayList<String>();
	private By continueShoppingButton=By.id("continue-shopping");
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public String getCartPageTitle()
	{
		return driver.findElement(pageTitle).getText();
	}
	
	public boolean productsInCart(List<String> products)
	{
		System.out.println(products);
		List<WebElement> productslist = driver.findElements(productsInCart);
		for (WebElement e : productslist)
		{
			actualProductsInCart.add(e.getText());
		}
		System.out.println(actualProductsInCart);
		return  actualProductsInCart.equals(products);
	}
	public void continueShopping()
	{
		driver.findElement(continueShoppingButton).click();
	}

}
