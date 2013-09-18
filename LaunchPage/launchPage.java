import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class launchPage 
{
	public static WebElement element;
	public static void verify_BlogName(WebDriver wd,WebDriverWait wd_wait,Properties prop)
	{
		element=wd.findElement(By.xpath(prop.getProperty("BLOG_NAME")));
		System.out.println(element.getText());
		
	}
	public static void verify_Sections (WebDriver wd,WebDriverWait wd_wait,Properties prop)
	{
		System.out.println("Sections are - ");
		List<WebElement> lists = wd.findElements(By.xpath("//div[contains(@class, 'sidebarItemTitle')]/span"));
		for(WebElement element: lists)  
		{
			String var = element.getText();
			System.out.println(var);
		}
	}
	public static void verify_Login (WebDriver wd,WebDriverWait wd_wait,Properties prop)
	{
		element=wd.findElement(By.xpath(prop.getProperty("TXT_UNAME")));
		element.sendKeys("username");
		element=wd.findElement(By.xpath(prop.getProperty("TXT_PWD")));
		element.sendKeys("password");
		element=wd.findElement(By.xpath(prop.getProperty("BTN_Login")));
		element.click();
		element=wd.findElement(By.xpath(prop.getProperty("LNK_Home")));
		element.click();
		CommonFunctions.wait(100);
	}

}
