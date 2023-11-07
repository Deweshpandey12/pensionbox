package contactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;

public class CreateContactTest extends BaseClass
{
	@Test
	public void CreateContactNewTest() throws EncryptedDocumentException, IOException
	{
		String LASTNAME = eUtlile.readDataFromExcel("Contacts", 1, 2)+jUtile.getRandomNumber();

		//Step 1: click on contacts
		HomePage hp = new HomePage(driver);
		hp.clickOnContactslink();

		//Step 2:click on add contact link
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateCnctlookupImg();

		//Step 3:create new contact with mandatory field
		CreateNewContactPage cnc = new CreateNewContactPage(driver);
		cnc.createNewContact(LASTNAME);

		//Step 4: validate for contact
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.getHeaderText();
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		System.out.println(contactHeader);


	}
}
