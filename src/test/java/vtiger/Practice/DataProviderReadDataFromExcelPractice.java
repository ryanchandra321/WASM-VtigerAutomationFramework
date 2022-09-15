package vtiger.Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vtiger.GenericUtility.ExcelFileUtility;

public class DataProviderReadDataFromExcelPractice {

	@Test(dataProvider = "OrgName")
	public void addProductToCartTest(String OrgName, String IndustryType)
	{
		System.out.println(OrgName+"-"+IndustryType);
	}
	
//	@DataProvider(name = "product")
//	public Object[][] data()
//	{
//		Object[][] d = new Object[4][5];
//		
//		d[0][0] = "samsung";
//		d[0][1] = "A80";
//		d[0][2] = 3000;
//		d[0][3] = "Display";
//		d[0][4] = 12;
//		
//		d[1][0] = "Vivo";
//		d[1][1] = "A8";
//		d[1][2] = 4000;
//		d[1][3] = "selfie camera";
//		d[1][4] = 10;
//		
//		d[2][0] = "Oppo";
//		d[2][1] = "Reno 5";
//		d[2][2] = 10000;
//		d[2][3] = "selfie camera";
//		d[2][4] = 12;
//		
//		d[3][0] = "iPhone";
//		d[3][1] = "13 pro";
//		d[3][2] = 50000;
//		d[3][3] = "Security";
//		d[3][4] = 15;
//		
//		return d;
//	}
	
	@DataProvider(name = "OrgName")
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		ExcelFileUtility eUtility = new ExcelFileUtility();
		Object[][] data = eUtility.readMultipleDataFromExcel("MultipleOrg");
		return data;
		
	}
	
	
	
}
