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
import objectRepository.LoginPage;
public class CreateOrganization
{
	public static void main(String[] args) throws IOException
	{
		//Step 1 : create all the required objects

		JavaUtilies jUtile = new JavaUtilies();
		ExcelFileUtility eUtlile = new ExcelFileUtility();
		PropertyFileUtility pUtilile = new PropertyFileUtility();
		WebDriverUtility wUtilile = new WebDriverUtility();
		WebDriver driver=null;

		//Step 2 : Read the required data

		String BROWSER = pUtilile.readDataFromPropertyFile("browser");//browser
		String URL = pUtilile.readDataFromPropertyFile("url");
		String USERNAME = pUtilile.readDataFromPropertyFile("username");
		String PASSWORD = pUtilile.readDataFromPropertyFile("password");
		String ORGNAME = eUtlile.readDataFromExcel("Organization", 1, 2)+jUtile.getRandomNumber();
		//Step 3: Launch the browser

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

		//Step 4 : Load the url
		driver.get(URL);

		//Step 5 : Login to application
		//First Changes done
//		WebElement usernametextfield = driver.findElement(By.name("username"));
//		usernametextfield.clear();
//		usernametextfield.sendKeys(USERNAME);
//		WebElement passwordtextfield = driver.findElement(By.name("password"));
//		passwordtextfield.clear();
//		passwordtextfield.sendKeys(PASSWORD);
//		driver.findElement(By.xpath("//button[text()=\"Sign in\"]")).click();

		LoginPage lp = new LoginPage(driver);
//		lp.getUserNameTF().clear();
//		lp.getUserNameTF().sendKeys(USERNAME);
//		lp.getPasswordTF().clear();
//		lp.getPasswordTF().sendKeys(PASSWORD);
//		lp.getLoginBtn().click();

		lp.loginToApp(USERNAME, PASSWORD);

		//Step 6: Navigate to Organization LInk
		driver.findElement(By.xpath("(//div[@class=\"row app-navigator\"])[1]")).click();
		WebElement marketinghover = driver.findElement(By.xpath("//span[text()=\" MARKETING\"]"));
		wUtilile.mouseHoverAction(driver, marketinghover);
		driver.findElement(By.xpath("(//span[text()=\" Organizations\"])[1]")).click();

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
			System.out.println("pass");
		}
		else
		{
			System.out.println("Fail");
		}



	}
}
