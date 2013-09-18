import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainScript 
{
	WebDriver driver = null;
	public static WebElement element;
	public static WebDriverWait wait;
	public static Properties prop = new Properties();
	
	@BeforeTest(alwaysRun=true)
	public void setup()
	{
		try {
             prop.load(new FileInputStream("pebble.properties"));
             }
        catch (IOException ex) {
              ex.printStackTrace();
         }
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		CommonFunctions.turnOnImplicitWait(driver, 20);
		wait = new WebDriverWait(driver, 10);
		driver.get("http://localhost:8080/pebble");
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
