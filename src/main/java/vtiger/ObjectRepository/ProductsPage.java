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
public class ProductsPage extends WebDriverUtility{
	//declaration
		@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
		private WebElement createNewProductLookUpImage;
		
		//initialization
		public ProductsPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//Utilization
		public WebElement getCreateProductLookUpImg()
		{
			return createNewProductLookUpImage;
		}
		
		/**
		 * This method will click on create new Product look up image
		 */
		//Bussiness Library
		public void clickOnCreateProductImg() {
			createNewProductLookUpImage.click();
		}
}
