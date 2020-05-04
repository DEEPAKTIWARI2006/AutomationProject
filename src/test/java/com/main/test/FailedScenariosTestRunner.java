/**
 * Core Framework
 * Author : Deepak Tiwari
 * Creation Date : 27 Apr 2018
 * Modified Date : 
 * Modified By : 
 */
package com.main.test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import frameworkcore.frameworkutils.GenericFunctions;
import frameworkcore.webdriverfactory.DriverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(features = {"@target/rerun.txt"},
glue = {"com.gluecode"}, 
tags = {}, 
strict = true, 
monochrome = true,
//dryRun = true,
plugin = { "rerun:target/rerun.txt", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class FailedScenariosTestRunner extends AbstractTestNGCucumberTests {

	private static Logger logger = LoggerFactory.getLogger(FailedScenariosTestRunner.class);
	private static HashMap<String, String> ParamMap = new HashMap<String, String>();
	private static WebDriver driver = null;

	@BeforeClass(alwaysRun = true)
	@Parameters({"BrowserName", "PlatformName", "PlatformVersion", "DeviceName", "AppPath" })
	public static void InitializeTest(@Optional String BrowserName, @Optional("OptionalValue") String PlatformName,
			@Optional("OptionalValue") String PlatformVersion, @Optional("OptionalValue") String DeviceName,
			@Optional("OptionalValue") String AppPath) throws InvocationTargetException, IllegalAccessException {

		logger.info("Inside Runner Before method class. Thread id = " + Thread.currentThread().getId());
		ParamMap.put("BrowserName", BrowserName);

		if (PlatformName.equalsIgnoreCase("OptionalValue"))
			ParamMap.put("PlatformName", "Windows");
		else
			ParamMap.put("PlatformName", PlatformName);

		if (PlatformVersion.equalsIgnoreCase("OptionalValue"))
			ParamMap.put("PlatformVersion", "");
		else
			ParamMap.put("PlatformVersion", PlatformVersion);

		if (DeviceName.equalsIgnoreCase("OptionalValue"))
			ParamMap.put("DeviceName", "");
		else
			ParamMap.put("DeviceName", DeviceName);

		if (AppPath.equalsIgnoreCase("OptionalValue"))
			ParamMap.put("AppPath", "");
		else
			ParamMap.put("AppPath", AppPath);

		try {
			DriverManager.setDriver(ParamMap);
			driver = DriverManager.getDriver();
		} catch (Exception e) {
			logger.error("Not able to initialize Webdriver. Please check the logs");
			logger.error(e.toString());
		}
	}
	
	@AfterClass
	public void driverTearDown() {
		if (null != driver) {
			GenericFunctions.LogAndReportInfo("Closing and quitting WebDriver");
			GenericFunctions.WaitForSeconds(1);
			driver.close();
			GenericFunctions.WaitForSeconds(1);
			driver.quit();
		}
	}
	
	
	
}
