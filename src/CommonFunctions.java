import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;
public class CommonFunctions
{
	public static WebDriver wd_driver;
	public static void wait(int n)
	{
		long t0,t1;
		t0=System.currentTimeMillis();
		do{
			t1=System.currentTimeMillis();
		}
		while(t1-t0<n);
	}
	public static WebDriver getWebDriver(Properties prop) throws IOException
	{
		WebDriver wd;
		File directory = new File (".");
		String browser_name=prop.getProperty("BROWSER");
		switch (BrowserType.valueOf(browser_name))
		{
		case FIREFOX:
			wd=new FirefoxDriver();
			wd.manage().window().maximize();
			return wd;
		case IE:
			String iepath=directory.getCanonicalPath() + "/lib/" + "IEDriverServer.exe";
			//System.out.println(iepath);
			System.setProperty("webdriver.ie.driver",iepath);
			wd = new InternetExplorerDriver();
			wd.manage().window().maximize();
			return wd;
		case CHROME:
			String chromepath=directory.getCanonicalPath() + "/lib/" + "chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromepath);
			wd = new ChromeDriver();
			CommonFunctions.wait(5000);
			wd.manage().window().maximize();
			return wd;
		case HTMLUNIT:
			wd = new HtmlUnitDriver();
			return wd;
		case ANDROID:
			wd = new AndroidDriver();
			return wd;
		case SAFARI:
			wd = new SafariDriver();
			wd.manage().window().maximize();
			return wd;
		default:
			throw new RuntimeException("Browser type unsupported");
		}
	}

	public static enum BrowserType
	{
		FIREFOX, IE, CHROME, HTMLUNIT, ANDROID, SAFARI
	}
	public static void turnOnImplicitWait (WebDriver wd,int timeout)
    {
          wd.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
     }
    public static void turnOffImplicitWait (WebDriver wd)
    {
          wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }
    public static WebElement fluentWait(final By locator){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(wd_driver)
                .withTimeout(50, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>()
        {
            public WebElement apply(WebDriver driver)
            {
                return driver.findElement(locator);
            }
         }
                );
        return  foo;
        };
}
