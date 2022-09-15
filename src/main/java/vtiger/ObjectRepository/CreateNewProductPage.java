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
public class CreateNewProductPage extends WebDriverUtility{

	//Declaration
	@FindBy(name = "productname")
	private WebElement productNameEdt;
	
	@FindBy(xpath = "//input[@name='vendor_name']/following-sibling::img[@title='Select']")
	private WebElement vendorLookUpImg;
	
	@FindBy(name = "search_text")
	private WebElement searchBoxEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy(name = "productcategory")
	private WebElement productCategoryDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Initialization
	public CreateNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getProductNameEdt() {
		return productNameEdt;
	}
	
	public WebElement getVendorLookUpImg() {
		return vendorLookUpImg;
	}
	
	public WebElement getSearchBoxEdt() {
		return searchBoxEdt;
	}
	
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public WebElement getProductCategoryDropDown() {
		return productCategoryDropDown;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Library
	/**
	 * This method will create a Product using mandatory fields and save
	 * @param lastname
	 */
	public void createNewProduct(String productname)
	{
		productNameEdt.sendKeys(productname);
		saveBtn.click();
	}
	
	/**
	 * This method will create a product with Product name and product category drop down  and save
	 * @param lastname
	 * @param leadsourceType
	 */
	public void createNewProduct(String productname, String productcategory)
	{
		productNameEdt.sendKeys(productname);
		handleDropdown(productcategory, productCategoryDropDown);
	}
		

	/**
	 * This method will create a Product with product name and vendor name
	 * @param lastname
	 * @param orgName
	 * @param driver
	 */
	public void createNewProduct(String productname, String vendorName, WebDriver driver)
	{
		productNameEdt.sendKeys(productname);
		vendorLookUpImg.click();
		switchToWindow(driver, "Vendors");
		searchBoxEdt.sendKeys(vendorName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+vendorName+"']")).click(); //dynamic Xpath
		switchToWindow(driver, "Products");
		saveBtn.click();
	}
	
	/**
	 * This method will create a Product with product name and vendor name
	 * @param lastname
	 * @param orgName
	 * @param driver
	 */
	public void createNewProduct(String productname, String productcategory, String vendorName, WebDriver driver)
	{
		productNameEdt.sendKeys(productname);
		handleDropdown(productcategory, productCategoryDropDown);
		vendorLookUpImg.click();
		switchToWindow(driver, "Vendors");
		searchBoxEdt.sendKeys(vendorName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+vendorName+"']")).click(); //dynamic Xpath
		switchToWindow(driver, "Products");
		saveBtn.click();
	}
}
