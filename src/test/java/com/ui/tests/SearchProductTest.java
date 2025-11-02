package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

@Listeners(com.ui.listners.TestListner.class)
public class SearchProductTest extends TestBase {

	private MyAccountPage myAccountPage;
	private static final String SEARCH_TEARM="Printed Summer Dress";

	@BeforeMethod(description = "Valid user is logs into the application")
	public void setup() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("timotoj174@asaption.com", "Password");

	}

	@Test(description = "Verify if the logged in user is able to search for a product and correct products", groups = {
			"e2e", "sanity", "smoke" }

	)

	public void verifyproductSearchTest() {
		boolean actualResult=myAccountPage.searchForAProduct(SEARCH_TEARM).isSearchTermPresentInProductList(SEARCH_TEARM); 
		Assert.assertEquals(actualResult, true);
	}

}
