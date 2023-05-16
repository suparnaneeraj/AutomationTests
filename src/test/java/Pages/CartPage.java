package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.GetWebElements;

public class CartPage extends GetWebElements
{
	
	//private By pageTitle=By.className("title");
	String pageTitle="title",productsInCart="inventory_item_name",continueShoppingButton="continue-shopping";
	//private By productsInCart=By.className("inventory_item_name");
	List<String> actualProductsInCart=new ArrayList<String>();
	List<String> productsAdded=new ArrayList<String>();
	//private By continueShoppingButton=By.id("continue-shopping");
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
	}
	public String getCartPageTitle()
	{
		return getClassNameElement(pageTitle).getText();
	}
	
	public boolean productsInCart(List<String> products)
	{
		System.out.println(products);
		List<WebElement> productslist = getClassNameElements(productsInCart);
		for (WebElement e : productslist)
		{
			actualProductsInCart.add(e.getText());
		}
		System.out.println(actualProductsInCart);
		return  actualProductsInCart.equals(products);
	}
	public void continueShopping()
	{
		getIdElement(continueShoppingButton).click();
	}

}
