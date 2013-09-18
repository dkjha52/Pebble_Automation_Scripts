import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MainScript 
{
	WebDriver driver = null;
	public static WebElement element;
	public static WebDriverWait wait;
	public static Properties prop = new Properties();
	
	@Parameters({ "platform","browser","version", "url" })
	@BeforeTest(alwaysRun=true)
	public void setup(String platform, String browser, String version, String url) throws MalformedURLException
	{
		try {
             prop.load(new FileInputStream("pebble.properties"));
             }
        catch (IOException ex) {
              ex.printStackTrace();
         }
		DesiredCapabilities caps = new DesiredCapabilities();
		//Platforms
		if(platform.equalsIgnoreCase("Windows"))
			caps.setPlatform(org.openqa.selenium.Platform.WINDOWS);
		if(platform.equalsIgnoreCase("MAC"))
			caps.setPlatform(org.openqa.selenium.Platform.MAC);
		if(platform.equalsIgnoreCase("Andorid"))
			caps.setPlatform(org.openqa.selenium.Platform.ANDROID);
		//Browsers
		if(browser.equalsIgnoreCase("Internet Explorer"))
			caps = DesiredCapabilities.internetExplorer();
		if(browser.equalsIgnoreCase("Firefox"))
			caps = DesiredCapabilities.firefox();
		if(browser.equalsIgnoreCase("iPad"))
			caps = DesiredCapabilities.ipad();
		if(browser.equalsIgnoreCase("Android"))
			caps = DesiredCapabilities.android();
		//Version
		caps.setVersion(version);
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
		driver.manage().window().maximize();
		CommonFunctions.turnOnImplicitWait(driver, 20);
		wait = new WebDriverWait(driver, 10);
		driver.get(url);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("TXT_UNAME"))));
		launchPage.verify_Login(driver, wait, prop);
	}
	
	@Test(description="Blog Name")
	public void testBlogName() throws InterruptedException 
	{
		launchPage.verify_BlogName(driver, wait, prop);
	}
	@Test(description="Sections Name")
	public void testSectionsName() throws InterruptedException 
	{
		launchPage.verify_Sections(driver, wait, prop);
	}
	@Test(description="Menu Options Name")
	public void testMenuOptions() throws InterruptedException 
	{
		homePage.verify_MenuOptions(driver, wait, prop);
	}
	@Test(description="Sub Menu Options Name-Contents")
	public void testSubMenuOptions1() throws InterruptedException 
	{
		homePage.verify_SubMenuOptions_Contents(driver, wait, prop);
	}
	@Test(description="Sub Menu Options Name-Comments")
	public void testSubMenuOptions2() throws InterruptedException 
	{
		homePage.verify_SubMenuOptions_Comments(driver, wait, prop);
	}
	@Test(description="Sub Menu Options Name-Configuration")
	public void testSubMenuOptions3() throws InterruptedException 
	{
		homePage.verify_SubMenuOptions_Configuration(driver, wait, prop);
	}
	@Test(description="Sub Menu Options Name-Logs")
	public void testSubMenuOptions4() throws InterruptedException 
	{
		homePage.verify_SubMenuOptions_Logs(driver, wait, prop);
	}
	@Test(description="Sub Menu Options Name-Administration")
	public void testSubMenuOptions5() throws InterruptedException 
	{
		homePage.verify_SubMenuOptions_Administration(driver, wait, prop);
	}
	@Test(description="Sub Menu Options Name-User")
	public void testSubMenuOptions6() throws InterruptedException 
	{
		homePage.verify_SubMenuOptions_User(driver, wait, prop);
	}
	
	@AfterTest
	public void afterTest() 
	{
		element=driver.findElement(By.xpath(prop.getProperty("BTN_Logout")));
		element.click();
		System.out.println("Successfully logged out");
		driver.quit();
	}

}
