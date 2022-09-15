package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactTest {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver;
		
		//Generate Random Number to avoid duplicate data
		Random r = new Random();
		int RANDOM = r.nextInt(1000);
		
		//Step 1 : Read The necessary Data
		
		//-----Property File -> Common Data-----
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties pObj = new Properties();
		pObj.load(fisp);
		String BROWSER = pObj.getProperty("browser");
		String URL =pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		//-----Property File -> Common Data-----
		
		//-----Excel File -> Test Data-----
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet("Contact");
		Row row = sh.getRow(1);
		Cell cel = row.getCell(2);
		String LASTNAME = cel.getStringCellValue();
		System.out.println(LASTNAME);
		
		//-----Excel File -> Test Data-----
		
		//Step 1 : Launch the Browser
		if(BROWSER.equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
			System.out.println("----- chrome browser launched successfully-----");
		} else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			System.out.println("-----firefox browser launched successfully----");
		} else {
			System.out.println("browser invalid");
			driver = new ChromeDriver();
			System.out.println("----- chrome browser launched successfully-----");
		}
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		

		// Step 2 : Login to App
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step 3 : Navigate to Contacts Link
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step 4 : Click on create Contacts look up image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//Step 5 : Enter the mandatory fields
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME+RANDOM);
		
		//Step 6 : Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 7 : Logout
		WebElement userIcon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(userIcon);
		actions.perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.close();
		System.out.println("Contact Created");
	}
}
