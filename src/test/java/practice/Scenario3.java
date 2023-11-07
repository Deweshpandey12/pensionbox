package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario3
{
	public static void main(String[] args)
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
		Actions ac = new Actions(driver);
		ac.moveToElement(dropdownmenu).perform();
		driver.findElement(By.xpath("(//span[text()=\" Contacts\"])[1]")).click();
		driver.findElement(By.xpath("//button[@id=\"Contacts_listView_basicAction_LBL_ADD_RECORD\"]")).click();
		driver.findElement(By.xpath("//input[@id=\"Contacts_editView_fieldName_lastname\"]")).sendKeys("Dewesh pandey");
		driver.findElement(By.xpath("//button[text()=\"Save\"]")).click();
	}
}
