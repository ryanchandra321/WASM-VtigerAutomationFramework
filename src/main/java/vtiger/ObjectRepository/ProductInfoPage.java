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
public class ProductInfoPage extends WebDriverUtility{

	//declaration
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	WebElement productHeaderText;
	
	//Initialization
	public ProductInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getProductHeader()
	{
		return productHeaderText;
	}
	
	//Bussiness Library
	/**
	 * This method will get the header text for organization
	 * @return
	 */
	public String getOrgHeaderText()
	{
		String productHeader = productHeaderText.getText();
		return productHeader;
	}
}
