package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario2
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.vtiger.com/vtigercrm/index.php");
		WebElement username = driver.findElement(By.id("username"));
		username.clear();
		username.sendKeys("admin");
		WebElement passwordtextfield = driver.findElement(By.id("password"));
		passwordtextfield.clear();
		passwordtextfield.sendKeys("admin");
		driver.findElement(By.xpath("//button[text()=\"Sign in\"]")).click();
		driver.findElement(By.xpath("(//div[@class=\"row app-navigator\"])[1]")).click();
		WebElement dropdownmenu = driver.findElement(By.xpath("//div[@id=\"MARKETING_modules_dropdownMenu\"]"));
		Thread.sleep(5000);
		Actions ac = new Actions(driver);
		ac.moveToElement(dropdownmenu).perform();
		driver.findElement(By.xpath("(//span[text()=\" Organizations\"])[1]")).click();
		driver.findElement(By.cssSelector("button[id=\"Accounts_listView_basicAction_LBL_ADD_RECORD\"]")).click();
		driver.findElement(By.cssSelector("input[id=\"Accounts_editView_fieldName_accountname\"]")).sendKeys("Dewesh pandey");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//span[text()=\"Vtiger Demo Administrator\"])[2]")).click();
		driver.findElement(By.xpath("//div[text()=\"Marketing Group\"]")).click();
		driver.findElement(By.xpath("//button[text()=\"Save\"]")).click();
	}
}
