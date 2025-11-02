package com.ui.tests;

import static com.constants.Browser.CHROME;
import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners(com.ui.listners.TestListner.class)
public class InvalidCredLoginTest extends TestBase {
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final String INVALID_EMAIL_ADDRESS = "kalpeshkp354@gmail.com";
	private static final String INVALID_PASSWORD = "1234";

	@Test(description = "Verifies if the proper message is shown when the user enters invalid credentials", groups = {
			"e2e", "sanity", "smoke" })
	
	public void logintest() {
	assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS, INVALID_PASSWORD)
	.getErrorMessage(), "Invalid password.");

	}
}
