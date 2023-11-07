package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass
{
	public JavaUtilies jUtile = new JavaUtilies();
	public ExcelFileUtility eUtlile = new ExcelFileUtility();
	public PropertyFileUtility pUtilile = new PropertyFileUtility();
	public WebDriverUtility wUtilile = new WebDriverUtility();
	public WebDriver driver=null;
	public static WebDriver Sdriver;

	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("---------DB Connection successfull...............");

	}

	@BeforeClass
	public void bcConfig() throws IOException
	{
		String BROWSER = pUtilile.readDataFromPropertyFile("browser");
		String URL = pUtilile.readDataFromPropertyFile("url");

		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println(BROWSER+"browser is launched");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver() ;
			System.out.println(BROWSER+"browser is launched");
		}
		else if (BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			System.out.println(BROWSER+"browser is launched");
		}
		else
		{
			System.out.println("Invalid browser name");
		}
		wUtilile.maximizeWindow(driver);
		wUtilile.waitForPageLoad(driver);
		Sdriver=driver;
		driver.get(URL);

	}

	@BeforeMethod
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtilile.readDataFromPropertyFile("username");
		String PASSWORD = pUtilile.readDataFromPropertyFile("password");

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("----------Login successfull---------");

	}

	@AfterMethod
	public void amConfig()
	{
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp();
		System.out.println("----------Logout successfull---------");
	}

	@AfterClass
	public void acConfig()
	{
		driver.quit();
		System.out.println("-----------Browser class----------");
	}

	public void asConfig()
	{
		System.out.println("----------DB Connection closed---------");
	}
}
