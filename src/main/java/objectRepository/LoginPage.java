package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	//Rule 2 : declare
	@FindBy(id="username")
	private WebElement userNameTF;

	@FindBy(id="password")
	private WebElement passwordTF;

	@FindBy(xpath="//button[text()=\"Sign in\"]")
	private WebElement loginBtn;

	//Rule 3 : Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//Rule 4 : Utilization

	public WebElement getUserNameTF() {
		return userNameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	//Rule 5 : Business library

	public void loginToApp(String userName,String password)
	{
		userNameTF.clear();
		userNameTF.sendKeys(userName);
		passwordTF.clear();
		passwordTF.sendKeys(password);
		loginBtn.click();


	}

}
