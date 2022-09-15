package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class ContactsPage extends WebDriverUtility{

	//declaration
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createNewContactLookUpImage;
	
	//initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getCreateCOntactLookUpImg()
	{
		return createNewContactLookUpImage;
	}
	
	/**
	 * This method will click on create new Contact look up image
	 */
	//Bussiness Library
	public void clickOnCreateContactImg() {
		createNewContactLookUpImage.click();
	}
}
