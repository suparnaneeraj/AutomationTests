package Utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetWebElements  {
	WebDriver driver;
	WebElement element;
	public GetWebElements(WebDriver driver)
	{
		this.driver=driver;
	}
	public WebElement getXpathElement(String xpath)
	{
		element=driver.findElement(By.xpath(xpath));
		return element;
		
	}
	public WebElement getIdElement(String id)
	{
		element=driver.findElement(By.id(id));
		return element;
	}
	public WebElement getNameElement(String name)
	{
		element=driver.findElement(By.id(name));
		return element;
	}
	public WebElement getCSSSelectorElement(String css)
	{
		element=driver.findElement(By.cssSelector(css));
		return element;
		
	}
	public WebElement getClassNameElement(String className)
	{
		element=driver.findElement(By.className(className));
		return element;
		
	}
	public List<WebElement> getClassNameElements(String className)
	{
		List<WebElement> elements=driver.findElements(By.className(className));
		return elements;
		
	}
	
}
