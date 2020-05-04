/**
 * Core Framework Author : Deepak Tiwari Creation Date : 27 Apr 2018 Modified Date : Modified By :
 */
package com.gmail.pagecollection;

import static frameworkcore.excelreader.ExcelDataReaderImpl.GetDataValue;
import static frameworkcore.frameworkutils.Messages.LOGIN_FAILURE;
import static frameworkcore.frameworkutils.Messages.LOGIN_SUCCESS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import frameworkcore.frameworkutils.GenericFunctions;
import frameworkcore.frameworkutils.UserActions;

public class HomePage {

  private static Logger logger = LoggerFactory.getLogger(HomePage.class);
  private String dataSheetName = null;
  private WebDriver driver;
  UserActions useractions;

  public HomePage(WebDriver driver) {
    this.driver = driver;
    useractions = new UserActions(driver);
    this.dataSheetName = this.getClass().getSimpleName().toString() + ".";
  }

  // Elements on Login Page

  @FindBy(name = "username")
  public static WebElement txtBoxuserName;

  @FindBy(name = "password")
  public WebElement txtboxPassword;

  @FindBy(xpath = "//button[text()='Log In']")
  public WebElement btnLogin;

  @FindBy(xpath = "//span[text()='Login / Register']")
  public WebElement linkLogin;

  @FindBy(xpath = "//img[@alt='BMO Equity Logo']")
  public WebElement imgBMOCapLogo;

  @FindBy(xpath = "//button[text()='Forgot credentials?']")
  public WebElement linkForgotPassword;

  @FindBy(xpath = "//button[text()='Register for an account']")
  public WebElement linkRegisterForAccount;

  @FindBy(xpath = "//p[@class='error' and text()='Invalid userName/Password']")
  public WebElement txtInvalidLoginMessage;

  @FindBy(xpath = "//span[@class='name-label ']/span")
  public WebElement lblLoginUser;
  
  String xpathLinkSignInMyAccount = "//a[text()='##PlaceHolder##']";
  String btnSignInLogOut = "//button[text()='##PlaceHolder##']";
  String xpathMyAccountEmail = "//h5[text()='Email']/following-sibling::div";

  // Methods for Sign Page


  public void VerifyLoginPageItems() {
    useractions.IsElementDisplayed(txtboxPassword);
    useractions.IsElementDisplayed(btnLogin);
    useractions.IsElementDisplayed(imgBMOCapLogo);
    useractions.IsElementDisplayed(linkForgotPassword);
  }

  public void Login(String testDataID) {
    String userName;
    String password;
    if (testDataID == "") {
      userName = GetDataValue(dataSheetName + "TestData_1" + ".userName");
      password = GetDataValue(dataSheetName + "TestData_1" + ".Password");
    } else {
      userName = GetDataValue(dataSheetName + testDataID + ".UserName");
      password = GetDataValue(dataSheetName + testDataID + ".Password");
    }

    useractions.highLightElement(driver, useractions.GetElement(xpathLinkSignInMyAccount, "Sign In"));
    useractions.ClickElement(xpathLinkSignInMyAccount, "Sign In");
    useractions.highLightElement(driver, txtBoxuserName);
    useractions.SendText(txtBoxuserName, userName);
    useractions.highLightElement(driver, txtboxPassword);
    useractions.SendText(txtboxPassword, password);
    GenericFunctions.WaitForSeconds(2);
    useractions.highLightElement(driver, useractions.GetElement(btnSignInLogOut,"Sign In"));
    useractions.ClickElement(btnSignInLogOut, "Sign In");
    logger.info("Entering User Name -- " + userName + " and Password  **** ");
    GenericFunctions.LogAndReportError("Entering User Name --  " + userName + " and Password -- **** ");

  }

  public void ValidateLogin(String testDataID) {

    String loginStatus = GetDataValue(dataSheetName + testDataID + ".LoginStatus");
    String actualuserName = GetDataValue(dataSheetName + testDataID + ".UserName");
    useractions.highLightElement(driver, useractions.GetElement(xpathLinkSignInMyAccount, "My Account"));
    useractions.ClickElement(xpathLinkSignInMyAccount, "My Account");   
    if (loginStatus.equalsIgnoreCase("Pass")) {
      if (useractions.GetElement(xpathMyAccountEmail).getText().contains(actualuserName)) {
        GenericFunctions.LogAndReportInfo(LOGIN_SUCCESS);
        Assert.assertTrue(true);
      } else {
        GenericFunctions.LogAndReportInfo(LOGIN_FAILURE);
        Assert.assertTrue(false, LOGIN_FAILURE);
      }
    } else if (GetDataValue(loginStatus).equalsIgnoreCase("Fail")) {
      if (useractions.IsElementDisplayed(txtInvalidLoginMessage)) {
        GenericFunctions.LogAndReportInfo("Pass!!! User should not be allowed to Login");
        Assert.assertTrue(true);
      } else {
        GenericFunctions.LogAndReportInfo("Fail!!! User is not allowed to Login");
        Assert.assertTrue(false,"Fail!!! User is not allowed to Login");
      }
    }
  }
  
  
  public void logOut() {
   useractions.highLightElement(driver, useractions.GetElement(xpathLinkSignInMyAccount, "My Account"));
    useractions.ClickElement(xpathLinkSignInMyAccount, "My Account");
    useractions.highLightElement(driver, useractions.GetElement(btnSignInLogOut, "Log out"));
    useractions.ClickElement(btnSignInLogOut, "Log out");
    if (useractions.IsElementDisplayed(xpathLinkSignInMyAccount, "Sign In")) {
      GenericFunctions.LogAndReportInfo("User Logged Out Successfully");
      Assert.assertTrue(true);
    }else {
      GenericFunctions.LogAndReportInfo("Logged Out NOT Successfull");
      Assert.assertTrue(false,"Logged Out NOT Successfull");
    } 
  }
  
 
}
