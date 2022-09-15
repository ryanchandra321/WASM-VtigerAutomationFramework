package vtiger.GenericUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

/**
 * This class contains basic configuration annotations for common functionalities 
 * like connection to database, launch the browser etc
 * @author pc
 *
 */
public class BaseClass {

	public DatabaseUtility dUtil = new DatabaseUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	
	@BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void bsConfig() throws SQLException
	{
		//dUtil.connectToDB();
		Reporter.log("--Database Connection Successfull.--",true);
		
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"SmokeSuite","RegressionSuite"})
	//@BeforeTest	
	public void bcConfig() throws IOException 
	//public void bcConfig(String BROWSER) throws IOException 
	{
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("CHROME"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			Reporter.log("--Browser "+BROWSER+" Launched Successfully--",true);
		}
		else if(BROWSER.equalsIgnoreCase("FIREFOX"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			Reporter.log("--Browser "+BROWSER+" Launched Successfully--",true);
		}
		else 
		{
			System.out.println("--Invalid Browser.--");
		}
		sdriver = driver;
		wUtil.maximiseWindow(driver);
		wUtil.WaitForElementToLoadInDom(driver);
		driver.get(URL);		
	}
	
	@BeforeMethod(groups = {"SmokeSuite","RegressionSuite"})
	public void bmCOnfig() throws IOException
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		Reporter.log("--Login Succesfully--");
	}
	
	@AfterMethod(groups = {"SmokeSuite","RegressionSuite"})
	public void amConfig()
	{
		HomePage hp = new HomePage(driver);
		hp.signOutOfApp(driver);
		Reporter.log("--SignOut Successfully.--", true);
	}
	
	//@AfterTest
	@AfterClass(groups = {"SmokeSuite","RegressionSuite"})
	public void acConfig()
	{
		driver.close();
		Reporter.log("--Browser Closed Successfully.--");
	}
	
	@AfterSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void asConfig()
	{
		//dUtil.closeDB();
		Reporter.log("--Database Close successfully.--",true);
	}
	
	
	
}
