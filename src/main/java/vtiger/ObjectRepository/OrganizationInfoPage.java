package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class OrganizationInfoPage extends WebDriverUtility{

	//declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	WebElement OrgHeaderText;
	
	//Initialization
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getOrgHeader()
	{
		return OrgHeaderText;
	}
	
	//Bussiness Library
	/**
	 * This method will get the header text for organization
	 * @return
	 */
	public String getOrgHeaderText()
	{
		String orgHeader = OrgHeaderText.getText();
		return orgHeader;
	}
}
