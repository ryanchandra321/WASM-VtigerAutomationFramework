package vtiger.ProductsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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
 * 
 * @author RAhul
 *
 */
public class CreateMultiProductWithVendorUsingDataProvider extends BaseClass{
	
	@Test(dataProvider = "ProdData")
	public void createMultiProduct(String prodName, String prodCategory, String vendor) throws IOException
	{
		System.out.println(prodName+"-"+prodCategory+"-"+vendor);
		//read all necessary data
		
		
		String vendName = vendor+jUtil.getRandomNumber();
		String proName = prodName+jUtil.getRandomNumber();
		
		
		
		//Navigate to Vendor link
		HomePage hp = new HomePage(driver);
		hp.clickOnVendorsLink(driver);
		
		//Navigate to Create vender image
		VendorsPage vp = new VendorsPage(driver);
		vp.clickOnCreateVendorImg();
		
		//create new vendor with mandatory field
		CreateNewVendorPage cvp = new CreateNewVendorPage(driver);
		cvp.createNewVendor(vendName);
		
		// Validate vander created
		VendorInfoPage vip = new VendorInfoPage(driver);
		String vendorHeader = vip.getVendorHeaderText();
		System.out.println(vendorHeader);
		if(vendorHeader.contains(vendName))
		{
			System.out.println("Vendor Created");
		}
		else {
			System.out.println("Vendor not Created");
		}
		
		//Navigate to Product Link
		hp.clickOnProductsLink();
		
		//Navigate to create product page
		ProductsPage pp = new ProductsPage(driver);
		pp.clickOnCreateProductImg();
		
		//Create product with product name, category and vendor
		CreateNewProductPage cpp = new CreateNewProductPage(driver);
		cpp.createNewProduct(proName, prodCategory, vendName, driver);
		
		//validate product created
		ProductInfoPage pip = new ProductInfoPage(driver);
		String productHeader = pip.getOrgHeaderText();
		System.out.println(productHeader);
		Assert.assertEquals(productHeader.contains(proName), true);
		
		System.out.println("---Product Created.---");
//		if(productHeader.contains(proName))
//		{
//			System.out.println("PASS");
//		}
//		else
//		{
//			System.out.println("FAIL");
//		}
		
	}
	
	@DataProvider(name = "ProdData")
	public Object[][] getProdData() throws EncryptedDocumentException, IOException
	{
		Object[][] data = eUtil.readMultipleDataFromExcel("MultiProduct");
		return data;
	}
	
	
}
