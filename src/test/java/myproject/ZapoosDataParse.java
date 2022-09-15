package myproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ZapoosDataParse {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.zappos.com/p/hoka-bondi-x-blue-glass-billowing-sail/product/9514691/color/939486");
		
		String scriptText = driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).getText();
		System.out.println(scriptText);
	}

}
