package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage
{
	//Declaration
	@FindBy(xpath="//span[@class=\"lastname\"]")
	private WebElement contactHeaderText;

	//Initialization
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getContactHeaderText() {
		return contactHeaderText;
	}

	//Business library
	public String getHeaderText()
	{
		return contactHeaderText.getText();
	}

}