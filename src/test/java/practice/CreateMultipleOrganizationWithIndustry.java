package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtilies;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.LoginPage;

public class CreateMultipleOrganizationWithIndustry
{
	JavaUtilies jUtile = new JavaUtilies();
	ExcelFileUtility eUtlile = new ExcelFileUtility();
	PropertyFileUtility pUtilile = new PropertyFileUtility();
	WebDriverUtility wUtilile = new WebDriverUtility();

	@Test(dataProvider = "getData")
	public void createMultipleOrg(String ORG,String INDUSTRYNAME) throws IOException
	{
WebDriver driver = null;

		// Step 2: Read The Required Data
		String BROWSER = pUtilile.readDataFromPropertyFile("browser");
		String URL = pUtilile.readDataFromPropertyFile("url");
		String USERNAME = pUtilile.readDataFromPropertyFile("username");
		String PASSWORD = pUtilile.readDataFromPropertyFile("password");

		String ORGNAME = ORG+jUtile.getRandomNumber();

		// Step 3: Launch the browser
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER + " launched");
		} else if (BROWSER.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER + " launched");
		} else if (BROWSER.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println(BROWSER + " launched");
		} else {
			System.out.println("Invalid Browser Name");
		}

		wUtilile.maximizeWindow(driver);
		wUtilile.waitForPageLoad(driver);

		// Step 4: Load the URL
		driver.get(URL);

		// Step 5: Login To Application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

		// Step 6: click on Organization
	}
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		return eUtlile.readMultipleData("MultipleOrganizations");
	}
}
