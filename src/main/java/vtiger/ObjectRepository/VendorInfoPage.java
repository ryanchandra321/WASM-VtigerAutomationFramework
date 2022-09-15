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
public class VendorInfoPage extends WebDriverUtility{

	//declaration
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	WebElement VendorHeaderText;
	
	//Initialization
	public VendorInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getVendorHeader()
	{
		return VendorHeaderText;
	}
	
	//Bussiness Library
	/**
	 * This method will get the header text for organization
	 * @return
	 */
	public String getVendorHeaderText()
	{
		String vendorHeader = VendorHeaderText.getText();
		return vendorHeader;
	}
}
