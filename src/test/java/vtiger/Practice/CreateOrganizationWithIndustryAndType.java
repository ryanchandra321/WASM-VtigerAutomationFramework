package vtiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationWithIndustryAndType {

	public static void main(String[] args) {
		
		//Step 1 : Launch the Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
		driver.get("http://localhost:8888/");
		
		// Step 2 : Login to App
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Step 3 : Navigate to Organization Link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 4 : Click on create organization look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Step 5 : Enter the mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("Nethues");
		
		//Step 6 : Select Healthcare in Industry ListBox
		WebElement industryListBox = driver.findElement(By.name("industry"));
		
		Select select = new Select(industryListBox);
		select.selectByValue("Healthcare");
		
		//Step 7 : Select Investor in Type ListBox
		WebElement typeListBox = driver.findElement(By.name("accounttype"));
		
		Select selectType = new Select(typeListBox);
		selectType.selectByValue("Investor");		
		
		//Step 8 : Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 9 : Logout
		WebElement userIcon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(userIcon);
		actions.perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.close();
		System.out.println("Organization With Industry Created");

	}

}
