package com.main.test;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import corepackage.InitializeExecutionImpl;

public class ExecuteTest {
	
	public static boolean TestStatus = true;
	
	@Test
	public void StartTest() throws IOException {

		InitializeExecutionImpl init = new InitializeExecutionImpl();
		init.InitializeTestExecution();
		
		if(TestStatus)
			Assert.assertTrue("The Test Passed", true);
		else
			Assert.assertTrue("The Test Failed", false);
	}
}
