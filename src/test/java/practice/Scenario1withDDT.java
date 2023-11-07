package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario1withDDT
{
	public static void main(String[] args) throws IOException, InterruptedException
	{
		//Read all the necessary data
		/*read data from property file- common data*/
		FileInputStream fisp = new FileInputStream("./src/test/resources/CommonData.properties");
		Properties p = new Properties();
		p.load(fisp);
		String URL = p.getProperty("url");
		String BROWSER = p.getProperty("browser");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");

		/*read data from excel - test data*/
		FileInputStream fise = new FileInputStream("./src/test/resources/TestData1.xlsx");
		Workbook wb=WorkbookFactory.create(fise);
		String LASTNAME = wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();

		WebDriver driver=null;

		//Step 2 lunch the browser
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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


		//Step 2 : load the application

		driver.get(URL);

		//Step 3 : login to application

		WebElement usernametextfield = driver.findElement(By.name("username"));
		usernametextfield.clear();
		usernametextfield.sendKeys(USERNAME);
		WebElement passwordtextfield = driver.findElement(By.name("password"));
		passwordtextfield.clear();
		passwordtextfield.sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()=\"Sign in\"]")).click();

		//Step 4: Navigate to Contacts LInk
		driver.findElement(By.xpath("(//div[@class=\"row app-navigator\"])[1]")).click();
		WebElement marketinghover = driver.findElement(By.xpath("//span[text()=\" MARKETING\"]"));
		Actions a = new Actions(driver);
		a.moveToElement(marketinghover).perform();

		//Step 5: Click on create conatct look up Image
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@title=\"Contacts\"])[1]")).click();

		driver.findElement(By.xpath("(//button[@type=\"button\"])[4]")).click();

		//Step 6: create conatct
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);

		//Step 7: Save
		driver.findElement(By.xpath("//button[text()=\"Save\"]")).click();

		//Step 8: Validate
		String contactHeader = driver.findElement(By.xpath("(//tr[@class=\"summaryViewEntries\"])[2]")).getText();

		if(contactHeader.contains(LASTNAME))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");

		}

		}
	}
