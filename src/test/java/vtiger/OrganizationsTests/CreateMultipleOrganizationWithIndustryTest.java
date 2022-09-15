package vtiger.OrganizationsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

/**
 * 
 * @author Rahul
 *
 */
public class CreateMultipleOrganizationWithIndustryTest extends BaseClass{
	
	
	@Test(dataProvider = "OrgData")
	public void createMultipleOrgTest(String OrgName, String industryType) throws IOException
	{
		System.out.println(OrgName+"-"+industryType);
		//read all necessary data
		String Org = OrgName+jUtil.getRandomNumber();
		
		//Navigate to Organization link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
		
		//Navigate to create org look up img
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgImg();
		
		//Create new org with industry type
		CreateNewOrganizationPage cop = new CreateNewOrganizationPage(driver);
		cop.createNewOrg(Org, industryType);
		
		//validate
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrgHeaderText();
		System.out.println(Org);
		Assert.assertEquals(orgHeader.contains(Org), true);
		
		System.out.println("---Organization Created.---");
//		if(orgHeader.contains(Org))
//		{
//			System.out.println("PASS");
//		}
//		else
//		{
//			System.out.println("FAIL");
//		}
	}
	
	@DataProvider(name = "OrgData")
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		return eUtil.readMultipleDataFromExcel("MultipleOrg");
	}
}
