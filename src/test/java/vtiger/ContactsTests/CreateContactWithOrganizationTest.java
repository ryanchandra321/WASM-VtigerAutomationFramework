package vtiger.ContactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;

/**
 * 
 * @author Rahul
 *
 */
public class CreateContactWithOrganizationTest extends BaseClass{
	
	@Test
	public void CreateContactWithOrganization() throws EncryptedDocumentException, IOException {
		
		//Step 2: Read All the required data
		String ORGNAME = eUtil.readDataFromExcel("Contact", 4, 3)+jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcel("Contact", 4, 2);
		
		//Step 5: Navigate to Organization
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 6: Create Organization with Mandatory Field and save
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(orgHeader);
		if(orgHeader.contains(ORGNAME))
		{
			System.out.println("PASS");
			System.out.println("----Organization Created-----");
		}
		else
		{
			System.out.println("FAIL");
			System.out.println("------Organization Not Created-----");
		}
		
		//STep7: Navigate to Contacts
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step 8 : Navigate to Contacts 
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		// Switch the control to child window
		wUtil.switchToWindow(driver, "Accounts");
		driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(ORGNAME)).click();
		
		//Switch the control back to Parent Window
		wUtil.switchToWindow(driver, "Contacts");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(contactHeader);
		if(contactHeader.contains(LASTNAME))
		{
			System.out.println("PASS");
			System.out.println("----Contact Created-----");
		}
		else
		{
			System.out.println("FAIL");
			System.out.println("------Contact Not Created-----");
		}		
		
	}

}
