/**
	 * Core Framework
 * Author : Deepak Tiwari
 * Creation Date : 27 Apr 2018
 * Modified Date : 
 * Modified By : 
 */
package com.gluecode;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.main.test.ExecuteTest;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {
	
	private static Logger logger = LoggerFactory.getLogger(CucumberHooks.class);
	String featureName="";
	
	/*
	 * @Before("@Feature") public void BeforeStartOfFeature(Scenario scenario) {
	 * String rawFeatureName = scenario.getName().split(";")[0].replace("-"," ");
	 * featureName = featureName + rawFeatureName.substring(0, 1).toUpperCase() +
	 * rawFeatureName.substring(1); logger.info("Start running Feature ##########  "
	 * + featureName + "   ##########"); }
	 * 
	 * @Before public void BeforeStartOfScenarioHook(Scenario scenario) throws
	 * ClassNotFoundException {
	 * logger.info("Starting execution of Scenario ##########" + scenario.getName()
	 * + "   ##########"); }
	 * 
	 * @After public void AfterEndOfScenarioHook(Scenario scenario) throws
	 * IOException{
	 * 
	 * if(scenario.isFailed()) { ExecuteTest.TestStatus=false;
	 * //Reporter.addScreenCaptureFromPath(ReportingImpl.CaptureScreenShot(
	 * DriverManager.getDriver()));
	 * logger.info("Scenario execution done, Scenario status is #####  " +
	 * scenario.getStatus() + "   #####"); } }
	 * 
	 * 
	 * @After("@Feature") public void AfterEndOfFeature(){
	 * logger.info("End running Feature ##########  " + featureName +
	 * "   ##########"); }
	 */
	
	/*
	 * @BeforeStep public void beforeStepExecutionHook(Scenario scenario) {
	 * System.out.println("Running Before Step Hook"); }
	 * 
	 * @AfterStep public void afterStepExecutionHook(Scenario scenario) {
	 * System.out.println("Running After Step Hook"); }
	 */

}
