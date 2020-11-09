/**
 * Core Framework Author : Deepak Tiwari Creation Date : 27 Apr 2018 Modified Date : Modified By :
 */
package com.gluecode;

import static frameworkcore.excelreader.ExcelDataReaderImpl.GetDataValue;
import static frameworkcore.frameworkutils.Messages.LAUNCHWEBSITE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gmail.pagecollection.HomePage;
import com.main.test.TestRunner;
import frameworkcore.frameworkutils.GenericFunctions;
import frameworkcore.webdriverfactory.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageValidationStepDefs extends TestRunner{

  WebDriver driver = null;
  HomePage page;

  public LoginPageValidationStepDefs() {
	this.driver = TestRunner.getDriver();
    driver = DriverManager.getDriver();
    page = PageFactory.initElements(driver,HomePage.class);
  }

  @Given("Open ApplicationUrl")
  public void open_ApplicationUrl() {
	String appUrl = GetDataValue("Environment_Config.AppUrl.Value");
    GenericFunctions.LogAndReportInfo(LAUNCHWEBSITE + appUrl);
    driver.manage().deleteAllCookies();
    driver.get(appUrl);
//  driver.navigate().to(appUrl);
  }
  
  @When("This is Step One")
  public void this_is_Step_One() {
	  GenericFunctions.LogAndReportInfo("This is Step One");
  }

  @Then("Validate that website has opened")
  public void validate_that_website_has_opened() {
	  GenericFunctions.LogAndReportInfo("Validate that website has opened");
  }

  @When("^Login to Website with data \"([^\"]*)\"$")
  public void login_to_Website_with_data(String testDataID) {
	  GenericFunctions.LogAndReportInfo("Logging in with credentials");
	  page.Login(testDataID);
  }
  
  @Then("User should be logged in")
  public void user_should_be_logged_in() {
	  GenericFunctions.LogAndReportInfo("User should be logged in");
  }

  @Then("^Logout of the application$")
  public void logout_of_the_application() {
  }

}
