package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
	//Declaration
	@FindBy(xpath="//div[@id=\"appnavigator\"]")
	private WebElement appnavigatorMenu;

	@FindBy(xpath="//div[@id=\"MARKETING_modules_dropdownMenu\"]")
	private WebElement marketingDropdownMenu;

	@FindBy(xpath="(//a[@title=\"Contacts\"])[1]")
	private WebElement Contactslink;

	@FindBy(xpath="(//span[contains(text(),\" Organizations\")])[1]")
	private WebElement OrganizationsLink;

	@FindBy(xpath="//li[@class=\"dropdown\"]")
	private WebElement signoutLink;

	@FindBy(linkText = "Sign Out")
	private WebElement signoutButton;


	//Rule 3 : Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//Rule 4 : Utilization


	public WebElement getAppnavigatorMenu() {
		return appnavigatorMenu;
	}


	public WebElement getMarketingDropdownMenu() {
		return marketingDropdownMenu;
	}


	public WebElement getContactslink() {
		return Contactslink;
	}


	public WebElement getOrganizationsLink() {
		return OrganizationsLink;
	}


	public WebElement getSignoutLink() {
		return signoutLink;
	}


	public WebElement getSignoutButton() {
		return signoutButton;
	}

	//Business Library
	/**
	 * This method will click on app menu
	 */
	public void clickOnAppnavigatorMenu()
	{
		appnavigatorMenu.click();
	}

	public void clickOnMarketingDropdownMenu()
	{
		marketingDropdownMenu.click();
	}

	/**
	 * This method will click on Contacts link
	 */
	public void clickOnContactslink()
	{
		appnavigatorMenu.click();
		marketingDropdownMenu.click();
		Contactslink.click();
	}
	/**
	 * This method will click on Organization link
	 */
	public void clickOnOrganizationsLink()
	{
		appnavigatorMenu.click();
		marketingDropdownMenu.click();
		OrganizationsLink.click();
	}
	/**
	 * This method will logout from application
	 */
	public void logoutOfApp()
	{
		signoutLink.click();
		signoutButton.click();
	}

}
