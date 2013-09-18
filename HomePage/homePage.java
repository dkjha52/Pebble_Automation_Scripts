import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class homePage 
{
	public static WebElement element;
	public static void verify_MenuOptions(WebDriver wd,WebDriverWait wd_wait,Properties prop)
	{
		System.out.println("Menu Options are - ");
		List<WebElement> lists = wd.findElements(By.xpath("//span[contains(@class, 'adminGroup')]"));
		for(WebElement element: lists)  
		{
			String var = element.getText();
			System.out.println(var);
		}
		element=wd.findElement(By.xpath(prop.getProperty("LNK_HELP")));
		if(element.isDisplayed())
		{
			System.out.println(element.getText());
		}
	}
	public static void verify_SubMenuOptions_Contents(WebDriver wd,WebDriverWait wd_wait,Properties prop)
	{
		element = wd.findElement(By.xpath(prop.getProperty("LNK_Content")));
        Actions builder = new Actions(wd); 
        builder.moveToElement(element).perform();
        List<WebElement> lists = wd.findElements(By.xpath("//div[contains(@class, 'adminLevel2')]/descendant::span[contains(@id, 'admin-content')]/a[@href]"));
        System.out.println("Sub Menu Options of Contents menu are - ");
        for(WebElement element: lists)  
    	{
    		String var = element.getText();
    		System.out.println(var);
    	}
        //builder.moveToElement(element);
        //builder.click().perform();
		
	}
	public static void verify_SubMenuOptions_Comments(WebDriver wd,WebDriverWait wd_wait,Properties prop)
	{
		element = wd.findElement(By.xpath(prop.getProperty("LNK_Comment")));
        Actions builder = new Actions(wd); 
        builder.moveToElement(element).perform();
        List<WebElement> lists = wd.findElements(By.xpath("//div[contains(@class, 'adminLevel2')]/descendant::span[contains(@id, 'admin-responses')]/a[@href]"));
        System.out.println("Sub Menu Options of Comments menu are - ");
        for(WebElement element: lists)  
    	{
    		String var = element.getText();
    		System.out.println(var);
    	}
      }
	public static void verify_SubMenuOptions_Configuration(WebDriver wd,WebDriverWait wd_wait,Properties prop)
	{
		element = wd.findElement(By.xpath(prop.getProperty("LNK_Configuration")));
        Actions builder = new Actions(wd); 
        builder.moveToElement(element).perform();
        List<WebElement> lists = wd.findElements(By.xpath("//div[contains(@class, 'adminLevel2')]/descendant::span[contains(@id, 'admin-blog')]/a[@href]"));
        System.out.println("Sub Menu Options of Configuration menu are - ");
        for(WebElement element: lists)  
    	{
    		String var = element.getText();
    		System.out.println(var);
    	}
      }
	public static void verify_SubMenuOptions_Logs(WebDriver wd,WebDriverWait wd_wait,Properties prop)
	{
		element = wd.findElement(By.xpath(prop.getProperty("LNK_LOGS")));
        Actions builder = new Actions(wd); 
        builder.moveToElement(element).perform();
        List<WebElement> lists = wd.findElements(By.xpath("//div[contains(@class, 'adminLevel2')]/descendant::span[contains(@id, 'admin-logs')]/a[@href]"));
        System.out.println("Sub Menu Options of Logs menu are - ");
        for(WebElement element: lists)  
    	{
    		String var = element.getText();
    		System.out.println(var);
    	}
      }
	public static void verify_SubMenuOptions_Administration(WebDriver wd,WebDriverWait wd_wait,Properties prop)
	{
		element = wd.findElement(By.xpath(prop.getProperty("LNK_Administration")));
        Actions builder = new Actions(wd); 
        builder.moveToElement(element).perform();
        List<WebElement> lists = wd.findElements(By.xpath("//div[contains(@class, 'adminLevel2')]/descendant::span[contains(@id, 'admin-admin')]/a[@href]"));
        System.out.println("Sub Menu Options of Administration menu are - ");
        for(WebElement element: lists)  
    	{
    		String var = element.getText();
    		System.out.println(var);
    	}
      }
	public static void verify_SubMenuOptions_User(WebDriver wd,WebDriverWait wd_wait,Properties prop)
	{
		element = wd.findElement(By.xpath(prop.getProperty("LNK_User")));
        Actions builder = new Actions(wd); 
        builder.moveToElement(element).perform();
        List<WebElement> lists = wd.findElements(By.xpath("//div[contains(@class, 'adminLevel2')]/descendant::span[contains(@id, 'admin-user')]/a[@href]"));
        System.out.println("Sub Menu Options of User menu are - ");
        for(WebElement element: lists)  
    	{
    		String var = element.getText();
    		System.out.println(var);
    	}
      }
}
