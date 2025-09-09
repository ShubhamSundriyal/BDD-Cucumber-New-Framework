package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {
	
	WebDriver lDriver;

	public SearchCustomerPage(WebDriver rDriver) {
		lDriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(id = "SearchEmail")
	WebElement emailAdd;
	
	@FindBy(id = "search-customers")
	WebElement searchBtn;
	
	@FindBy(xpath = "//table[@role='grid']")
	WebElement searchResult;
	
	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;
	
	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr[1]/td")
	List<WebElement> tableColumns;
	
	@FindBy(id = "SearchFirstName")
	WebElement firstName;
	
	@FindBy(id = "SearchLastName")
	WebElement lastName;
	
	//action method to enter email address
	public void enterEmailAdd(String email) {
		emailAdd.sendKeys(email);
	}
	
	//action method to perform click action on
	public void clickOnSearchButton() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		searchBtn.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean searchCustomerByEmail(String email) {
		boolean found = false;
		
		//total number of rows in a grid
		int totalRows = tableRows.size();
		
		//total number of columns
		int totalColumns = tableColumns.size();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 1; i <= totalRows; i++) {
		    WebElement webElementEmail = lDriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i + "]/td[2]"));
		    String actualEmailAdd = webElementEmail.getText();
		    
		    if (actualEmailAdd.equals(email)) {
		        found = true;
		    }
		}
		
		return found;
	}
	
	    //action method to enter first name
		public void enterFirstName(String firstNameText) {
			firstName.sendKeys(firstNameText);
		}
		
		//action method to enter first name
		public void enterLastName(String lastNameText) {
			lastName.sendKeys(lastNameText);
		}
	
		public boolean searchCustomerByName(String name) {
			
			boolean found = false;
			
			//total number of rows in a grid
			int totalRows = tableRows.size();
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for (int i = 1; i <= totalRows; i++) //to iterate all the rows of the grid
			{
				WebElement webElementName = lDriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[\" + i + \"]/td[3]"));
				String actualName = webElementName.getText();
				
				if (actualName.equals(name)) {
					found = true;
					break;
				}
			}
			
			return found;
		}
}
