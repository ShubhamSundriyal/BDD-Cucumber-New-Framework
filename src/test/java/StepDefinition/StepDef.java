package StepDefinition;

import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * Child class of Base Class
 */

public class StepDef extends BaseClass {
	
	@Before("@Sanity")
	public void setUp() {
		
		readConfig = new ReadConfig();
		
		log = LogManager.getLogger("StepDef");
		System.out.println("Set up Sanity executed successfully....");
		
		String browser = readConfig.getBrowser();
		
		switch (browser.toLowerCase()) {
		
		case "chrome": 
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			
		default:
			driver = null;
			break;
		}
			
		log.info("Set up 1 executed........");
	}
	
	/*
	@Before("@regression")
	public void setUp2() {
		
		System.out.println("Set up Regression executed successfully....");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		log.info("Set up 2 executed........");
		
	}
	*/
	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() {
	   
	    loginPg = new LoginPage(driver);
	    addNewCustPg = new AddNewCustomerPage(driver);
	    searchCustomerPage = new SearchCustomerPage(driver);
	    
	    log.info("Chrome Browser Launched........");
	    
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
	    driver.get(url);
	    
	    log.info("URL opened........");
	    
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailAdd, String password) {
	    loginPg.enterEmail(emailAdd);
	    loginPg.enterPassword(password);
	    
	    log.info("email address and password entered");
	}

	@When("click on Login")
	public void click_on_login() throws InterruptedException {
	    Thread.sleep(2000);
	    loginPg.clickOnLoginButton();
	    
	    log.fatal("Clicked on login button>>>>>>");
	    
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedPageTitle) {
	    String actualPageTitle = driver.getTitle();
	    System.out.println(actualPageTitle);

        if (actualPageTitle.equals(expectedPageTitle)) {
        	log.warn("Login feature : Page title matched.");
        	Assert.assertTrue(true);  //pass
        } else {
        	Assert.assertTrue(false); //fail
        	log.warn("Login feature : Page title not matched");
        }
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {
	    loginPg.clickOnLogOutButton();
	    log.info("user clicked on Log out link");
	}

	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
	    String actualTitle = addNewCustPg.getPageTitle();
	    String expectedTitle = "Dashboard / nopCommerce administration";
	    
	    if (actualTitle.equals(expectedTitle)) {
	    	
	    	Assert.assertTrue(true);
	    	log.info("User can view dashboard passed");
	    } else {
	    	
	    	Assert.assertTrue(false);
	    	log.warn("User can view dashboard failed");
	    }
	}

	@When("User click on customers menu")
	public void user_click_on_customers_menu() {
	    addNewCustPg.clickOnCustomersMenu();
	    log.info("Customer menu clicked");
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() {
	    addNewCustPg.clickOnCustomersMenuItem();
	    log.info("Customer menu item clicked");
	}

	@When("click on Add New button")
	public void click_on_add_new_button() {
	    addNewCustPg.clickOnAddnew();
	    log.info("Add New button clicked");
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
	    String actualTitle = addNewCustPg.getPageTitle();
	    String expectedTitle = "Add a new customer / nopCommerce administration";
	    
	    if (actualTitle.equals(expectedTitle)) {
	    	Assert.assertTrue(true); //Pass
	    } else {
	    	Assert.assertFalse(false); //Fail
	    }
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
	    addNewCustPg.enterEmail(generateEmailId() +"@gmail.com");
	    addNewCustPg.enterPassword("test1");
	    addNewCustPg.enterFirstName("Prachi");
	    addNewCustPg.enterLastName("Gupta");
	    addNewCustPg.enterGender("Female");
	//    addNewCustPg.enterDob("6/13/1988");
	    addNewCustPg.enterCompanyName("Code studio");
	    addNewCustPg.enterAdminContent("Admin content");
	    addNewCustPg.enterManagerOfVendor("Vendor 1");
	    
	    log.info("Customer info entered....");
	    
	}

	@When("click on Save button")
	public void click_on_save_button() {
	    addNewCustPg.clickOnSave();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedConfirmationMessage) {
	    String bodyTagText = driver.findElement(By.tagName("Body")).getText();
	    
	    if (bodyTagText.contains(expectedConfirmationMessage)) {
	    	Assert.assertTrue(true);  //pass
	    } else {
	    	Assert.assertTrue(false); //fail
	    }
	}
	
	@When("Enter customer Email")
	public void enter_customer_email() {
	    searchCustomerPage.enterEmailAdd("victoria_victoria@nopCommerce.com");
	}
	
	@When("click on search button")
	public void click_on_search_button() {
	    searchCustomerPage.clickOnSearchButton();
	}
	
	@Then("User should find Email in the Search table")
	public void user_should_find_email_in_the_search_table() {
	    String expectedEmailAddress = "victoria_victoria@nopCommerce.com";
	    
	    Assert.assertTrue(searchCustomerPage.searchCustomerByEmail(expectedEmailAddress));
	    if (searchCustomerPage.searchCustomerByEmail(expectedEmailAddress) == true) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}
	
	@When("Enter customer FirstName")
	public void enter_customer_first_name() {
	    
		searchCustomerPage.enterFirstName("Victoria");
	}

	@When("Enter customer LastName")
	public void enter_customer_last_name() {

		searchCustomerPage.enterLastName("Terces");
	
	}
	
	@Then("User should find Name in the Search table")
	public void user_should_find_name_in_the_search_table() {
	    
		String expectedName = "Victoria Terces";
		
		if (searchCustomerPage.searchCustomerByName(expectedName) == true) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) {
		
		if (scenario.isFailed()) {
		final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		
		//attach image file report(data, media type, name of the attachment)
		scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}
	
	/*
	@After(order = 1)
	public void tearDown1(Scenario sc) throws IOException {
		
		System.out.println("Tear down method executed.....");
		if (sc.isFailed() == true) {
			
			String fileWithPath = "C:\\Users\\Dell\\eclipse-workspace\\BDDUIFramework\\Screenshot\\test1.png";
			
			//Convert web driver to TakesScreenshot
			TakesScreenshot srcShot = ((TakesScreenshot)driver);
			
			//Call getScreenshotAs method to create image file
			File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
			
			//move image file to new destination
			File destFile = new File(fileWithPath);
			
			//copy file at destination
			FileUtils.copyFile(srcFile, destFile);
			
		}
		driver.quit();
	}
	*/
	/*
	@After(order = 2)
	public void tearDown2() {
		
		System.out.println("Tear down method executed.....");
		driver.quit();
	}
	*/
	
	/*
	@BeforeStep
	public void beforeStepMethodDemo() {
		System.out.println("This is before step....");
	}
	
	@AfterStep
	public void afterStepMethodDemo() {
		System.out.println("This is after step....");
	}
	*/
}
