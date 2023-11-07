package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility
{
	//Declaration
	@FindBy(name="lastname")
	private WebElement lastnameEdt;

	@FindBy(xpath="//button[text()=\"Save\"]")
	private WebElement saveBtn;

	@FindBy(xpath="//i[@id='Contacts_editView_fieldName_account_id_select']")
	private WebElement orgLookupImg;

	@FindBy(name="accountname")
	private WebElement accountName;

	@FindBy(xpath="//button[text()=\"Search\"]")
	private WebElement searchOrgbtn;
	//Initialization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getorgLookupImg()
	{
		return orgLookupImg;
	}

	public WebElement getAccountName() {
		return accountName;
	}

	public WebElement getSearchOrgbtn() {
		return searchOrgbtn;
	}

	//Business library
	public void createNewContact(String LASTNAME)
	{
		lastnameEdt.sendKeys(LASTNAME);
		saveBtn.click();
	}

	public void createNewContact(WebDriver driver,String LASTNAME,String ORGNAME)
	{
		lastnameEdt.sendKeys(LASTNAME);
		orgLookupImg.click();
		switchToWindow(driver, "Organizations");
		accountName.sendKeys(ORGNAME);
		searchOrgbtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
		cancelAlert(driver);

	}


}