package vtiger.ObjectRepository;

import org.openqa.selenium.By;
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
public class CreateNewContactPage extends WebDriverUtility{
	
	//Declaration
	@FindBy(name = "lastname")
	private WebElement ContactNameEdt;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement OrgLookUpImg;
	
	@FindBy(name = "search_text")
	private WebElement searchBoxEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy(name = "leadsource")
	private WebElement leadsourceDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Initialization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getContactNameEdt() {
		return ContactNameEdt;
	}
	
	public WebElement getOrgLookUpImg() {
		return OrgLookUpImg;
	}
	
	public WebElement getSearchBoxEdt() {
		return searchBoxEdt;
	}
	
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public WebElement getLeadSourceDropDown() {
		return leadsourceDropDown;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Library
	/**
	 * This method will create a contact using mandatory fields and save
	 * @param lastname
	 */
	public void createNewContact(String lastname)
	{
		ContactNameEdt.sendKeys(lastname);
		saveBtn.click();
	}
	
	/**
	 * This method will create a contact with cotact name and lead source drop down  and save
	 * @param lastname
	 * @param leadsourceType
	 */
	public void createNewContact(String lastname, String leadsourceType)
	{
		ContactNameEdt.sendKeys(lastname);
		handleDropdown(leadsourceType, leadsourceDropDown);
	}
	
	/**
	 * This method will create a contact with lastname and organization name
	 * @param lastname
	 * @param orgName
	 * @param driver
	 */
	public void createNewCOntact(String lastname, String orgName, WebDriver driver)
	{
		ContactNameEdt.sendKeys(lastname);
		OrgLookUpImg.click();
		switchToWindow(driver, "Accounts");
		searchBoxEdt.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click(); //dynamic Xpath
		switchToWindow(driver, "Contancts");
		saveBtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
}
