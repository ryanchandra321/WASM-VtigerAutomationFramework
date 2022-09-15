package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

/**
 * 
 * @author Rahul
 *
 */
public class CreateNewVendorPage extends WebDriverUtility{

	//Declaration
	@FindBy(name = "vendorname")
	private WebElement vendorNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Initialization
	public CreateNewVendorPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getVendorName() {
		return vendorNameEdt;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Bussiness Library
	/**
	 * This method will create vendor with mendatory fields
	 * @param vendorName
	 */
	public void createNewVendor(String vendorName)
	{
		vendorNameEdt.sendKeys(vendorName);
		saveBtn.click();
	}
	
	
	
	
}
