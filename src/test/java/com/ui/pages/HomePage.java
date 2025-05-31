package com.ui.pages;

import static com.constants.Env.QA;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

public final class HomePage extends BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final By Sign_In_Link_Locator = By.xpath("//a[contains(text(),'Sign in')]");

	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName, isHeadless);// responsibility of child class to call parent class constructor with the help
		goToWebsite(JSONUtility.readJson(QA).getUrl()); // of super keyword
	}

	public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(JSONUtility.readJson(QA).getUrl());
	}

	public LogInPage goToLoginPage() { // Page Function--->cannot use void return type
		logger.info("Trying to perform click to go to Sign in  page");
		clickOn(Sign_In_Link_Locator);
		LogInPage loginPage = new LogInPage(getDriver());
		return loginPage;

	}

	


	}


