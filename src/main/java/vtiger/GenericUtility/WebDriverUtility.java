package vtiger.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class Contains all the generic methods related to web driver actions
 * @author Rahul
 *
 */

public class WebDriverUtility {

	/**
	 * This method is used to maximise the window
	 * @param driver
	 */
	public void maximiseWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will wait for 20 seconds for the entire DOM structure to load
	 * @param driver
	 */
	public void WaitForElementToLoadInDom(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/**
	 * This method will wait for perticular ekemt to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToLoad(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will wait for perticular element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will wait for the perticular element to perform click operation
	 * if the element is not interactive tit will wait for 1 second
	 * @param element
	 * @throws InterruptedException
	 */
	public void customWaitAndClickOnElement(WebElement element) throws InterruptedException
	{
		int count =0;
		while (count<10) {
			try {
				element.click();
			} catch (Exception e) {
				// TODO: handle exception
				Thread.sleep(1000);
				count++;
			}
		}
	}
	
	/**
	 * This method will handle the dropdown by select class using index
	 * @param element
	 * @param vsisibleText
	 */
	public void handleDropdown(WebElement element, int index)
	{
		Select s= new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * This method will handle dropdown by select class using visible text
	 * @param element
	 * @param visibleTest
	 */
	public void handleDropDown(WebElement element, String visibleTest)
	{
		Select s = new Select(element);
		s.selectByVisibleText(visibleTest);
	}
	
	/**
	 * This method will handle dropdown by slect class by using value
	 * @param value
	 * @param element
	 */
	public void handleDropdown(String value, WebElement element)
	{
		Select s=  new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * This method will perform double click over a page
	 * @param driver
	 * @param element
	 */
	public void doubleClickOn(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * This method will perform double click on a perticular element
	 * @param driver
	 * @param element
	 */
	public void doubleClickOn(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method will perform mouse hover action on a perticular element 
	 * @param driver
	 * @param element
	 */
	public void mouseHoverOn(WebDriver driver,  WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method will perform mouse Hover action over the offset (x,y)
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void mouseHoverOn(WebDriver driver, int x, int y)
	{
		Actions act = new Actions(driver);
		act.moveByOffset(x, y);		
	}
	
	/**
	 * This method will perform right click on the perticular page
	 * @param driver
	 */
	public void rightClickOn(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick();
	}
	
	/**
	 * This method will perform right click on the perticular element
	 * @param driver
	 * @param element
	 */
	public void rightClickOn(WebDriver driver,  WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element);
	}
	
	/**
	 * This method will perform drag and drop action from source element to target element
	 * @param driver
	 * @param srcElement
	 * @param targetElement
	 */
	public void dragAndDropOn(WebDriver driver, WebElement srcElement, WebElement targetElement)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(srcElement, targetElement);
	}
	
	/**
	 * This method will accept the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) 
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will dismiss the alert popup
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();		
	}
	
	/**
	 * This method will get the text of alert popup and returnit to caller
	 * @param driver
	 * @return 
	 */
	public String getTextInAlert(WebDriver driver )
	{
		String alertText = driver.switchTo().alert().getText();
		return alertText;
	}
	
	/**
	 * This method will switch to the window with respect to the window title
	 * @param driver
	 * @param partialText
	 */
	public void switchToWindow(WebDriver driver, String partialText)
	{
		//Step 1 : get all window handles
		Set<String> windowIds = driver.getWindowHandles();
		
		//Step 2 : iterate thru all the windowIds
		Iterator<String> it = windowIds.iterator();
		
		//Step 3 : navigate inside the window
		while (it.hasNext()) { // loop until windowIds exist
			//capture all the windows ids
			//String string = (String) it.next();
			String winId = it.next();
			
			//switch to the window and capture the title
			String currentTittle = driver.switchTo().window(winId).getTitle();
			if(currentTittle.contains(partialText))
			{
				break;
			}
			
		}
	}
	
	/**
	 * Switch to frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * Switch to frame based on id or name
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, String idOrName)
	{
		driver.switchTo().frame(idOrName);
	}
	
	/**
	 * Switch to frame based on frame element
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method will take screenshot and return the destination path
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShoot(WebDriver driver,  String screenShotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = ".\\ScreenShots\\"+screenShotName+".png";
		File dst = new File(path);
		FileUtils.copyFile(src, dst);
		
		return dst.getAbsolutePath();
	}
	
	/**
	 * This method will perform random scroll
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("window.scrollBy(0,500)", "");
	}
	
	/**
	 * This method will scroll until the perticular element
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("argument[0].scrollIntoView()", null);
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	
	
	
	
	
	
	
	
}
