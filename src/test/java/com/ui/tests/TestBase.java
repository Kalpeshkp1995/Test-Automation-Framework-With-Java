package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {
	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest = true;

	@Parameters({ "browser", "isLambdaTest", "isHeadless" })
	@BeforeMethod(description = "load the homepage of the website")
	public void setup(@Optional("CHROME") String browser, @Optional("false") boolean isLambdaTest,
			@Optional("false") boolean isHeadless, ITestResult result) {
		this.isLambdaTest = isLambdaTest;
		WebDriver lambdaDriver;
		if (isLambdaTest) {

			lambdaDriver = LambdaTestUtility.initializeLambdaTestSession(browser, result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver);

		} else {
			logger.info("load the homepage of the website");

			// Safely convert the string to enum
			Browser browserEnum = Browser.valueOf(browser.trim().toUpperCase());

			homePage = new HomePage(browserEnum, isHeadless);

		}

	}

	public BrowserUtility getInstance() {
		return homePage;
	}

//	@AfterMethod(description = "Tear Down the Browser")
//	public void tearDown() {
//		if (isLambdaTest) {
//			LambdaTestUtility.quitSession(); // Close browser session on lambda test
//		} else {
//			homePage.quit();
//		}
//
//	}

}
