package practice2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Plan
{
	public static void main(String[] args)
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://qa.pensionbox.in/getstarted");
		driver.findElement(By.name("input[name=\"mobileno\"]")).sendKeys("6201940580");
		driver.findElement(By.xpath("//span[text()=\"Login\"]")).click();

	}
}
