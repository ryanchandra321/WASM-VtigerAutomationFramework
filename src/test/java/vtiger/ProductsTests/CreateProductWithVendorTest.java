package vtiger.ProductsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.CreateNewProductPage;
import vtiger.ObjectRepository.CreateNewVendorPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.ProductInfoPage;
import vtiger.ObjectRepository.ProductsPage;
import vtiger.ObjectRepository.VendorInfoPage;
import vtiger.ObjectRepository.VendorsPage;

/**
 * THis testcase will create product with vendor
 * @author Rahul
 *
 */
public class CreateProductWithVendorTest extends BaseClass{
	
	@Test
	public void CreateProductWithVendor() throws EncryptedDocumentException, IOException {
		
		
		//Read all required data		
		String VENDORNAME = eUtil.readDataFromExcel("Product", 4, 3)+jUtil.getRandomNumber();
		String PRODUCTNAME = eUtil.readDataFromExcel("Product", 4, 2)+jUtil.getRandomNumber();
		
		//Navigate to Vendor Link
		HomePage hp = new HomePage(driver);
		hp.clickOnVendorsLink(driver);
		
		//Navigate To create Vendor Image
		VendorsPage vp = new VendorsPage(driver);
		vp.clickOnCreateVendorImg();
		
		//Create New Vendor with mandatory fields
		CreateNewVendorPage cvp = new CreateNewVendorPage(driver);
		cvp.createNewVendor(VENDORNAME);
		
		//validation vendor created
		VendorInfoPage vip = new VendorInfoPage(driver);
		String vendorHeader = vip.getVendorHeaderText();
		System.out.println(vendorHeader);
		if(vendorHeader.contains(VENDORNAME))
		{
			System.out.println("Vendor Created");
		}
		else {
			System.out.println("Vendor not Created");
		}
		
		//Navigate to Product Link
		hp.clickOnProductsLink();
		
		//Click on create product Image
		ProductsPage pp = new ProductsPage(driver);
		pp.clickOnCreateProductImg();
		
		//Create new Product with vendor
		CreateNewProductPage cpp = new CreateNewProductPage(driver);
		cpp.createNewProduct(PRODUCTNAME, VENDORNAME, driver);
		
		//validate product created
		ProductInfoPage pip = new ProductInfoPage(driver);
		String productHeader = pip.getOrgHeaderText();
		System.out.println(productHeader);
		Assert.assertEquals(productHeader.contains(PRODUCTNAME), true);
		
		System.out.println("---Product Created.---");
//		if(productHeader.contains(PRODUCTNAME))
//		{
//			System.out.println("PASS");
//		}
//		else
//		{
//			System.out.println("FAIL");
//		}
		
		
	}

}
