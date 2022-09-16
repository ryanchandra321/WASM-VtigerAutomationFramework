package vtiger.ContactsTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.ContactsInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;


@Listeners(vtiger.GenericUtility.ListnerImplementation.class)
public class CreateContactWithOrgTest extends BaseClass{

	@Test(groups = "SmokeSuite")
	public void createContactWithOrgTest() throws IOException
	{
		//Read all required data
		
		String ORGNAME = eUtil.readDataFromExcel("Contact", 4, 3)+jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcel("Contact", 4, 2)+jUtil.getRandomNumber();
		
		//Navigate to Organization Link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
		Reporter.log("--Organization Link Clicked.---");
		
		//Navigate to create Org img
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgImg();
		Reporter.log("--Create Organization Look Up Image Clicked.--");
		
		//Create organization with mandatory fields
		CreateNewOrganizationPage cop = new CreateNewOrganizationPage(driver);
		cop.createNewOrg(ORGNAME);
		Reporter.log("--New Organization Cretaed.--");
		
		//validation org created
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader = oip.getOrgHeaderText();
		System.out.println(OrgHeader);
		if(OrgHeader.contains(ORGNAME))
		{
			System.out.println("Org Created");
		}
		else {
			System.out.println("Org not Created");
		}
		
		//Navigate to Contacts Link
		hp.clickOnContactsLink();
		Reporter.log("--Contact Link Clicked.--");
		
		//Navigate to create contacts img
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		Reporter.log("--Create New Contact Look Up image Clicked.--");
		
		
		//Create contact with org details
		CreateNewContactPage cnp = new CreateNewContactPage(driver);
		cnp.createNewCOntact(LASTNAME, ORGNAME, driver);
		Reporter.log("--New Contact with Organization created.--");
		
		//validate
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String contactHeader = cip.getContactHeaderText();
		System.out.println(contactHeader);
		Assert.assertEquals(contactHeader.contains(LASTNAME), true);
		
		System.out.println("---Contact Created.---");
//		if(contactHeader.contains(LASTNAME))
//		{
//			System.out.println("PASS");
//		}
//		else
//		{
//			System.out.println("FAIL");
//		}
		
		//Sign Out 
		//hp.signOutOfApp(driver);

	}
	
	@Test(groups = "SmokeSuite" )
	public void jusrPrint()
	{
		System.out.println("Extra Print");
	}

}
