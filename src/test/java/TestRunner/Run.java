package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(features = {".//Features/LoginFeature.feature", ".//Features/Customers.feature"}, 
		//features = ".//Features",
		glue = "StepDefinition",
//		tags = "@Sanity", //scenarios under @Sanity tag will be executed
        
		dryRun = false, monochrome = true, 
//		plugin = {
//		"pretty", "html:target/cucumber-reports/reporthtml.html"}

plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

//"json:target/cucumber-reports/reportjson.json"
//"junit:target/cucumber-reports/report_xml.xml"


public class Run extends AbstractTestNGCucumberTests {

	/* This class will be empty */

}

