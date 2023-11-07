package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage
{
	@FindBy(xpath="//span[@class=\"accountname\"]")
	private WebElement orgHeaderText;

	//initialization
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getOrgHeaderText() {
		return orgHeaderText;
	}

	//Business library
	/**
	 * This method will capture header text and return it to caller
	 */
	public void getHeaderText()
	{
		orgHeaderText.getText();
	}


}
