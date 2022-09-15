package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility{

	//declaration 
	@FindBy(name = "accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Initialization
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}
	
	public WebElement getIndistryDropDown() {
		return industryDropDown;
	}
	
	public WebElement getTypeDropDown() {
		return typeDropDown;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Bussiness Library
	/**
	 * This method will create organization with org name
	 * @param Orgname
	 */
	public void createNewOrg(String Orgname)
	{
		OrgNameEdt.sendKeys(Orgname);
		saveBtn.click();
	}
	
	/**
	 * This method will create organization with industry drop down
	 * @param OrgName
	 * @param IndustryType
	 */
	public void createNewOrg(String OrgName, String IndustryType)
	{
		OrgNameEdt.sendKeys(OrgName);
		handleDropdown(IndustryType, industryDropDown);
		saveBtn.click();
	}
	
	public void createNewOrg(String OrgName, String IndustryType, String type)
	{
		OrgNameEdt.sendKeys(OrgName);
		handleDropdown(IndustryType, industryDropDown);
		handleDropdown(type, typeDropDown);
		saveBtn.click();
	}
	
	
	
	
	
	
	
	
}
