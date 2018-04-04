package com.test.automation.uiAutomation.homePage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.HomePage;

public class TC0001_VerifyLogin extends TestBase{
	
	public static final Logger log = Logger.getLogger(TC0001_VerifyLogin.class.getName());
	
	HomePage homepage;

	@BeforeTest
	public void setUp() {
		
		init();
		
	}
	
	@Test
	public void verifyLogin() {
		log.info("Starting the test");
			
		homepage = new HomePage(driver);
		log.info("Logging in to app");
		homepage.loginToApp("test@gmail.com", "password");
		
		Assert.assertEquals(homepage.invalidAuthMsg(), "Authentication failed.");
		log.info("Verification done");
		log.info("Test completed");
	}
	
	@AfterTest
	public void testEnd() {
		
		driver.quit();
		
	}
	
}
