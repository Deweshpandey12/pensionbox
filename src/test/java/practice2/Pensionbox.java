package practice2;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtilies;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Pensionbox
{
	public static void main(String[] args) throws IOException
	{
		//Step 1 : create all the required objects

				JavaUtilies jUtile = new JavaUtilies();
				ExcelFileUtility eUtile = new ExcelFileUtility();
				PropertyFileUtility pUtile = new PropertyFileUtility();
				WebDriverUtility wUtile = new WebDriverUtility();
				WebDriver driver=null;

				String BROWSER = pUtile.readDataFromPropertyFile("browser");
				String URL = pUtile.readDataFromPropertyFile("url11");
				String USERNAME = pUtile.readDataFromPropertyFile("username11");
				String MOBILENO = pUtile.readDataFromPropertyFile("mobileno");
				String EMAIL = pUtile.readDataFromPropertyFile("email");

				//Step 3 :Launch the browser
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
				wUtile.maximizeWindow(driver);
				wUtile.waitForPageLoad(driver);

				driver.get(URL);
				driver.findElement(By.xpath("//span[text()=\"Log in\"]")).click();
				driver.findElement(By.name("mobileno")).sendKeys(MOBILENO);
				driver.findElement(By.xpath("//span[text()=\"Login\"]")).click();
				driver.findElement(By.name("char1")).sendKeys("3");
				driver.findElement(By.name("char2")).sendKeys("9");
				driver.findElement(By.name("char3")).sendKeys("9");
				driver.findElement(By.name("char4")).sendKeys("1");



	}
}
