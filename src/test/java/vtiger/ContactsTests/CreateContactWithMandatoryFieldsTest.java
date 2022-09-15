package vtiger.ContactsTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.ContactsInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.HomePage;

/**
 * 
 * @author Rahul
 *
 */
@Listeners(vtiger.GenericUtility.ListnerImplementation.class)
public class CreateContactWithMandatoryFieldsTest extends BaseClass{
	
	@Test(groups = "RegressionSuite")
	public void createContactWithMandatoryFields() throws IOException {
		
				
		//Read all required data
		
		String LASTNAME = eUtil.readDataFromExcel("Contact", 1, 2)+jUtil.getRandomNumber();		
		
		//navigate to contact link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();
		
		//navigate to create contact img
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactImg();		
		
		//create contact with mandatory fields
		CreateNewContactPage cnp = new CreateNewContactPage(driver);
		cnp.createNewContact(LASTNAME);
		
		//validation
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String contactHeader = cip.getContactHeaderText();
		Assert.assertEquals(contactHeader.contains(LASTNAME), true);
		
		System.out.println("--Contact Created.--");
		
	}
}
