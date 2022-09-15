package vtiger.Practice;

import java.io.IOException;

import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws IOException {
		
		JavaUtility jLib = new JavaUtility();
		int ran = jLib.getRandomNumber();
		System.out.println(ran);
		String date = jLib.getSystemDate();
		System.out.println(date);
		String formatDate = jLib.getSystemDateInFormat();
		System.out.println(formatDate);
		
		PropertyFileUtility pLib = new PropertyFileUtility();
		String b = pLib.readDataFromPropertyFile("browser");
		System.out.println(b);
		
		ExcelFileUtility eLib = new ExcelFileUtility();
		String data = eLib.readDataFromExcel("Organization", 1, 2);
		eLib.writeDataIntoExcel("Organization", 2, 7, "Rahul");
		System.out.println(data);
	}

}
