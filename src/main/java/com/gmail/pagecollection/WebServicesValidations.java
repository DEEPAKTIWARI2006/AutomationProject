package com.gmail.pagecollection;

import static frameworkcore.excelreader.ExcelDataReaderImpl.GetDataValue;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;
import frameworkcore.frameworkutils.GenericFunctions;
import frameworkcore.frameworkutils.UserActions;
import frameworkcore.webservices.ApiAssertions;
import frameworkcore.webservices.RequestBuilderImpl;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class WebServicesValidations {


  private static org.slf4j.Logger logger = LoggerFactory.getLogger(WebServicesValidations.class);

  private String dataSheetName = null;
  private WebDriver driver;
  UserActions useractions;



  public WebServicesValidations(WebDriver driver) {
    this.driver = driver;
    useractions = new UserActions(driver);
    // this.dataSheetName = this.getClass().getSimpleName().toString() + ".";
  }

  public static JsonPath jsonpath;

  /**
   * @return the jsonpath
   */
  private static JsonPath getJsonpath() {
    return jsonpath;
  }

  /**
   * @param jsonpath the jsonpath to set
   */
  private static void setJsonpath(JsonPath jsonpath) {
    WebServicesValidations.jsonpath = jsonpath;
  }



  private RequestBuilderImpl reqBuilder = null;
  private ApiAssertions apiAssertions = null;
  private String webservicesDataSheet = "WebServicesInputData.";

  private String webservicesConfigDataSheet = "WebServicesConfigData.";
  private String webservicesInputDataSheet = "WebServicesInputData.";

  private static String token;
  private static String strResponse;
  private static String requestType;
  private static String serviceURI;

  public static List<String> listOfProdFromResponse;


  /**
   * @return the productName
   */
  private static List<String> getProductList() {
    return listOfProdFromResponse;
  }

  /**
   * @param productName the productName to set
   */
  private static void setProductList(List<String> productName) {
    WebServicesValidations.listOfProdFromResponse = productName;
  }

  /**
   * @return the requestType
   */
  private static String getRequestType() {
    return requestType;
  }

  /**
   * @return the serviceURI
   */
  private static String getServiceURI() {
    return serviceURI;
  }

  /**
   * @param requestType the requestType to set
   */
  private static void setRequestType(String requestType) {
    WebServicesValidations.requestType = requestType;
  }

  /**
   * @param serviceURI the serviceURI to set
   */
  private static void setServiceURI(String serviceURI) {
    WebServicesValidations.serviceURI = serviceURI;
  }

  /**
   * @return the strResponse
   */
  private static String getStrResponse() {
    return strResponse;
  }

  /**
   * @param strResponse the strResponse to set
   */
  private static void setStrResponse(String strResponse) {
    WebServicesValidations.strResponse = strResponse;
  }

  /**
   * @return the token
   */
  private static String getToken() {
    return token;
  }

  /**
   * @param token the token to set
   */
  private static void setToken(String token) {
    WebServicesValidations.token = token;
    System.setProperty("AuthToken", token);
  }

  public WebServicesValidations() {
    reqBuilder = new RequestBuilderImpl();
    apiAssertions = new ApiAssertions();
  }

  public void application_Base_URL() {
    reqBuilder.SetBaseURI(GetDataValue("Environment_Config.QA_API_BaseURL.Value"));
    GenericFunctions.LogAndReportInfo(
        "Base URL is --  " + GetDataValue("Environment_Config.QA_API_BaseURL.Value"));
  }


  public void createToken() {
    // String authToken = reqBuilder.getToken();
    // String authToken =
    // "JWT
    // eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6Imd1ZXN0XzE1NDI4ODI2NjI0MkBleGFtcGxlLmNvbSIsImlzX2d1ZXN0Ijp0cnVlLCJvcmlnX2lhdCI6MTU0Mjg4MjY2MiwidXNlcl9pZCI6bnVsbCwiZXhwIjoxNTQ1NDc0NjYyLCJlbWFpbCI6Imd1ZXN0XzE1NDI4ODI2NjI0MkBleGFtcGxlLmNvbSJ9.FUrTXuukmAQPNgrX_GkbJSPa_Y5etIpLNq32EAgqqgg";
//    String authToken =
//        "JWT eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6Imd1ZXN0XzE1NDI4ODI2NjI0MkBleGFtcGxlLmNvbSIsImlzX2d1ZXN0Ijp0cnVlLCJvcmlnX2lhdCI6MTU0Mjg4MjY2MiwidXNlcl9pZCI6bnVsbCwiZXhwIjoxNTQ1NDc0NjYyLCJlbWFpbCI6Imd1ZXN0XzE1NDI4ODI2NjI0MkBleGFtcGxlLmNvbSJ9.FUrTXuukmAQPNgrX_GkbJSPa_Y5etIpLNq32EAgqqgg";
    String authToken = "JWT eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6Imd1ZXN0XzE1NTQxMDA0NTA1MUBleGFtcGxlLmNvbSIsIm9yaWdfaWF0IjoxNTU0MTAwNDUwLCJpc19ndWVzdCI6dHJ1ZSwiZW1haWwiOiJndWVzdF8xNTU0MTAwNDUwNTFAZXhhbXBsZS5jb20iLCJleHAiOjE1NTY2OTI0NTAsInVzZXJfaWQiOm51bGx9.WCYUhSWrv0-OoXw33en1dXLfXxdmWA3GHwwIKdeJpd8";
    GenericFunctions.LogAndReportInfo("Token is --  " + authToken);
    System.setProperty("AuthToken", authToken);
    // setToken(authToken);
  }


  public void requestSpecificationWithTestData(String specificationType) {
    reqBuilder.RequestSpecificationBuilder();
  }


  public void setHeadersWithTestData(String testDataID) {
    String headers = GetDataValue(webservicesConfigDataSheet + testDataID + ".Headers");
    reqBuilder.SetHeaders(headers);
  }

  public void performTheActionOnWebServiceWithData(String testDataID) {
    String reqType = GetDataValue(webservicesConfigDataSheet + testDataID + ".RequestType");
    System.out.println(reqType);
    // setRequestType(reqType);
    String serviceURI = GetDataValue(webservicesConfigDataSheet + testDataID + ".ServiceURI");
    System.out.println(serviceURI);
    // setServiceURI(serviceURI);
    reqBuilder.SetRequestType(reqType, serviceURI);


  }

  public void validateTheStatusCodeOfTheResponse(String testDataID) {

    int actualStatusCode = reqBuilder.GetStatusCode();
    int expectedStatusCode =
        Integer.parseInt(GetDataValue(webservicesDataSheet + testDataID + ".StatusCode"));
    GenericFunctions.LogAndReportInfo("Expected status code is " + expectedStatusCode
        + " and actual status code is " + actualStatusCode);
    apiAssertions.ValidateStatusCode(expectedStatusCode, actualStatusCode);

  }

  public void extractTheResponse() throws ParseException {
    strResponse = reqBuilder.ExtractResponseAsString();
    setStrResponse(strResponse);
    GenericFunctions.LogAndReportInfo("Response extracted : " + strResponse);

  }


  public void getTheSKUAndStock(String key) {
//    Util.map = (HashMap<Object, Object>) reqBuilder.retrieveKeyValueMap(key);
    GenericFunctions.LogAndReportInfo("The SKU and the Corresponding Stock From API is ");
    for (Entry<Object, Object> mp : Util.map.entrySet()) {
      GenericFunctions.LogAndReportInfo(mp.getKey() + " -- " + mp.getValue());
    }
  }


  public void getProductsFromResponse() {
    
//    setProductList(reqBuilder.getPathFromResponse().getList("data.name"));
    Collections.sort(getProductList());
    GenericFunctions.LogAndReportInfo("Product Names extracted from Response :  ");
    for (String products : getProductList()) {
      GenericFunctions.LogAndReportInfo(products);
    }
  }


  // String productXpath = "//a[@class='ui heading DescriptionTwo']";

  public boolean compareList(List<String> ls1, List<String> ls2) {
    return ls1.containsAll(ls2) && ls1.size() == ls2.size() ? true : false;
  }


  public void getProductsFromUI() {
    try {
//      if (compareList(UserFlow.listOfProducts, listOfProdFromResponse) == true) {
//        GenericFunctions.LogAndReportInfo(
//            "List Of Products in The API Response is same as List Of Products in the UI");
//      } else {
//        GenericFunctions.LogAndReportError(
//            "List Of Products in The API Response is same as List Of Products in the UI");
//        Assert.assertTrue(false);
//      }
    } catch (AssertionError e) {
      // TODO: handle exception
      logger.info(e.getMessage());

    } catch (Exception e) {
      // TODO: handle exception
    }

  }



}
