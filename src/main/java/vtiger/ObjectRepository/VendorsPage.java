package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Rahul
 *
 */
public class VendorsPage {

	//declaration
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createNewVendorLookUpImage;
	
	//initialization
	public VendorsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getCreateVendorLookUpImg()
	{
		return createNewVendorLookUpImage;
	}
	
	/**
	 * This method will click on create new Vendor look up image
	 */
	//Bussiness Library
	public void clickOnCreateVendorImg() {
		createNewVendorLookUpImage.click();
	}
}
