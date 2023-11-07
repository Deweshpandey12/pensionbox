package contactsTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtilies;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactInfoPage;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationsPage;

public class CreateContactWithorganizationTest
{
	@Test
	public void createContactWithOrgTest() throws IOException
	{
		//Step 1 : create all the required object
		JavaUtilies jUtile = new JavaUtilies();
		ExcelFileUtility eUtile = new ExcelFileUtility();
		PropertyFileUtility pUtile = new PropertyFileUtility();
		WebDriverUtility wUtile = new WebDriverUtility();
		WebDriver driver=null;

		//Step 2 : Read the required data
		String BROWSER = pUtile.readDataFromPropertyFile("browser");
		String URL = pUtile.readDataFromPropertyFile("url");
		String USERNAME = pUtile.readDataFromPropertyFile("username");
		String PASSWORD = pUtile.readDataFromPropertyFile("password");

		String LASTNAME = eUtile.readDataFromExcel("Contacts", 7, 2);
		String ORGNAME = eUtile.readDataFromExcel("Contacts",7, 3);

		//Step 3 : Launch the browser

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

		// Step 4 : Login to application

		driver.get(URL);

		//Step 5 : Login To Application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

		//Step 6 : click on Organization link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();

		//Step 7 : click on create organization look up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickonCreateOrgLookupImg();

		//Step 8 : create new organization with mandatory field
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);

		//Step 9 : Validate for Organization
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.getHeaderText();
		if(contactHeader.contains(LASTNAME))
		{
			System.out.println(contactHeader);
			System.out.println("pass");
		}
		else
		{
			System.out.println("Fail");
		}

	}

}
