package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	
	//declaration
	@FindBy(linkText = "Organizations")
	private WebElement organizationsLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLnk;
	
	@FindBy(linkText = "Products")
	private WebElement productsLnk;
	
	@FindBy(linkText = "Leads")
	private WebElement leadsLnk;
	
	@FindBy(xpath = "//a[contains(text(),'More')]")
	private WebElement moreLnk;
	
	@FindBy(linkText = "Vendors")
	private WebElement vendorsLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	//@FindAll(@FindBy(linkText = "Sign Out"), @FindBy(xpath = "//a[@href='index.php?module=Users&action=Logout']"))
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLnk;

	//Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getOrganizationsLnk() {
		return organizationsLnk;
	}
	
	public WebElement getContactsLnk() {
		return contactsLnk;
	}
	
	public WebElement getOppertunitiesLink() {
		return opportunitiesLnk;
	}
	
	public WebElement getProductsLink() {
		return productsLnk;
	}
	
	public WebElement getLeadsLnk() {
		return leadsLnk;
	}
	
	public WebElement getMoreLnk() {
		return moreLnk;
	}
	
	public WebElement getVendorsLnk() {
		return vendorsLnk;
	}
	
	public WebElement getAdministratorImg() {
		return administratorImg;
	}
	
	public WebElement getSignOutLnk() {
		return signOutLnk;
	}
	
	//Bussiness Library
	
	/**
	 * This method will perform sign out operation
	 * @param driver
	 */
	public void signOutOfApp(WebDriver driver)
	{
		mouseHoverOn(driver, administratorImg);
		signOutLnk.click();
	}
	
	/**
	 * This method will click on organizations
	 */
	public void clickOnOrgLink()
	{
		organizationsLnk.click();
	}
	
	public void clickOnContactsLink()
	{
		contactsLnk.click();
	}
	
	public void clickOnVendorsLink(WebDriver driver)
	{
		mouseHoverOn(driver, moreLnk);
		vendorsLnk.click();
	}
	
	public void clickOnProductsLink()
	{
		productsLnk.click();
	}
	
	
}
