package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage
{
	//Declaration
	@FindBy(xpath="//button[@id='Contacts_listView_basicAction_LBL_ADD_RECORD']")
	private WebElement AddContactBtn;

	//Initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getAddContactBtn() {
		return AddContactBtn;
	}

	/**
	 * This method will click on create contact lookup img
	 */
	//Business library
	public void clickOnCreateCnctlookupImg()
	{
		AddContactBtn.click();
	}


}
