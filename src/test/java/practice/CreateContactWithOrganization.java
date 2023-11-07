package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtilies;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrganization
{
	public static void main(String[] args) throws IOException, InterruptedException
	{
		//Step 1:create all the required object
		JavaUtilies jUtile = new JavaUtilies();
		PropertyFileUtility pUtile = new PropertyFileUtility();
		ExcelFileUtility eUtile = new ExcelFileUtility();
		WebDriverUtility wUtile = new WebDriverUtility();
		WebDriver driver=null;

		//Step 2 :Read all the required data
		String BROWSER = pUtile.readDataFromPropertyFile("browser");
		String URL = pUtile.readDataFromPropertyFile("url");
		String USERNAME = pUtile.readDataFromPropertyFile("username");
		String PASSWORD = pUtile.readDataFromPropertyFile("password");
		String ORGNAME = eUtile.readDataFromExcel("Contacts", 7, 3)+jUtile.getRandomNumber();
		String LASTNAME = eUtile.readDataFromExcel("Contacts", 7, 2);

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

		//Step 4:Load the url
		driver.get(URL);

		//Step 5:login to application
		WebElement usernametextfield = driver.findElement(By.name("username"));
		usernametextfield.clear();
		usernametextfield.sendKeys(USERNAME);
		WebElement passwordtextfield = driver.findElement(By.name("password"));
		passwordtextfield.clear();
		passwordtextfield.sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()=\"Sign in\"]")).click();

		//Step 6: Navigate to Organization LInk
		driver.findElement(By.xpath("//div[@class=\"row app-navigator\"]")).click();
		WebElement marketinghover = driver.findElement(By.xpath("//span[text()=\" MARKETING\"]"));
		wUtile.mouseHoverAction(driver, marketinghover);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[contains(text(),\"Organizations\")])[2]")).click();

		//Step 7: Click on Create Organization look Up Image
		driver.findElement(By.xpath("//button[contains(text(),\" Add Organization\")]")).click();

		//Step 8: Create Organization with mandatory information
		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(ORGNAME);

		//Step 9:Save
		driver.findElement(By.xpath("//button[text()=\"Save\"]")).click();

		//Step 10:Validate
		String orgHeader = driver.findElement(By.xpath("//span[@class=\"accountname\"]")).getText();

		if(orgHeader.contains(ORGNAME))
		{
			System.out.println(orgHeader);
			System.out.println("Organization is created successfully");
		}
		else
		{
			System.out.println("Fail");
		}

		//Step 11 :Navigate to contact
		driver.findElement(By.xpath("(//div[@class=\"row app-navigator\"])[1]")).click();
		WebElement marketinghover1 = driver.findElement(By.xpath("//span[text()=\" MARKETING\"]"));
		wUtile.mouseHoverAction(driver, marketinghover1);
		driver.findElement(By.xpath("(//a[@title=\"Contacts\"])[1]")).click();

		//Step 12:Create on contact lookup image
		driver.findElement(By.xpath(" //button[contains(text(),\" Add Contact\")]")).click();

		//Step 13:Create contact with mandatory field
		driver.findElement(By.cssSelector("input[name=\"lastname\"]")).sendKeys(LASTNAME);

		driver.findElement(By.xpath("(//span[@title=\"Select\"])[1]")).click();










	}
}
