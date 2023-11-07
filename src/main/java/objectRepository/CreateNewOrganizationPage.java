package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganizationPage
{
	//Declaration
	@FindBy(name="accountname")
	private WebElement orgnamedit;

	@FindBy(xpath="(//span[text()=\"Select an Option\"])[1]")
	private WebElement industryDropDown;

	@FindBy(xpath="//button[contains(text(),\"Save\")]")
	private WebElement saveBtn;

	@FindBy(xpath="//td[contains(text(),\"Type\")]/..//span[@id=\"select2-chosen-6\"]")
	private WebElement typeDropdown;

	@FindBy(xpath="//li[@role=\"presentation\"]")
	private List<WebElement> elementList;

	//initialization
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getTypeDropdown() {
		return typeDropdown;
	}

	public WebElement getOrgnamedit() {
		return orgnamedit;
	}

	public List<WebElement> getElementList() {
		return elementList;
	}

	//Business library

	/**
	 * This method will create new organization with mandatory field
	 * @param ORGNAME
	 */
	public void createNewOrganization(String ORGNAME)
	{
		orgnamedit.sendKeys(ORGNAME);
		saveBtn.click();
	}
	/**
	 * This method will create new organization with Industry drop down
	 * @param ORGNAME
	 * @param INDSUTRY
	 */
	public void createNewOrganization(String ORGNAME,String INDSUTRY)
	{
		orgnamedit.sendKeys(ORGNAME);
		industryDropDown.click();
		for(WebElement ele:elementList)
		{
			if(ele.getText().equals(INDSUTRY))
			{
				ele.click();
				break;
			}
		}

		saveBtn.click();
	}

	/**
	 * This method will create new organization with Industry and Type drop down
	 * @param ORGNAME
	 * @param INDSUTRY
	 * @param TYPE
	 */
	public void reateNewOrganization(String ORGNAME,String INDSUTRY,String TYPE)
	{
		orgnamedit.sendKeys(ORGNAME);
		industryDropDown.click();
		for(WebElement ele:elementList)
		{
			if(ele.getText().equals(INDSUTRY))
			{
				ele.click();
				break;
			}
		}
		typeDropdown.click();
		for(WebElement ele:elementList)
		{
			if(ele.getText().equals(TYPE))
			{
				ele.click();
				break;
			}
		}

		saveBtn.click();

	}

}
