package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage
{
	//Declaration
	@FindBy(xpath="//button[contains(text(),\" Add Organization\")]")
	private WebElement createOrgLookupImg;

	//Initialization
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getCreateOrgLookupImg() {
		return createOrgLookupImg;
	}

	/**
	 * This method will click on create organization lookup image
	 */
	//Business library
	public void clickonCreateOrgLookupImg()
	{
		createOrgLookupImg.click();
	}


}
