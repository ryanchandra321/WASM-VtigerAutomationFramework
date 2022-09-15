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
public class ContactsInfoPage extends WebDriverUtility{

	//declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactHeaderTxt;
	
	//Initialization
	public ContactsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getContactHeader()
	{
		return contactHeaderTxt;
	}
	
	//Bussiness Library
	/**
	 * This method will get the header text for Contact
	 * @return
	 */
	public String getContactHeaderText()
	{
		return contactHeaderTxt.getText();
	}
	
	
	
}

