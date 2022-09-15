package vtiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.LoginPage;

public class POMPractice {

	public static void main(String[] args) {
		//Launch the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		
		//Login to App
		LoginPage lp = new LoginPage(driver);
//		WebElement username = lp.getUserNameEdt();
//		username.sendKeys("admin");
//		
//		lp.getPasswordEdt().sendKeys("admin");
//		lp.getLoginBtn().click();
		
		lp.loginToApp("admin", "admin");

	}

}
