package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;

public class AddNewFirstAddressTest extends TestBase {

	private MyAccountPage myAccountPage;
	private AddressPage addressPage;
	private AddressPOJO address;

	@BeforeMethod(description = "Valid user is logs into the application")
	public void setup() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("timotoj174@asaption.com", "Password");
        address = FakeAddressUtility.getFakeAddress();
	}
	
	@Test
    public void addNewAddress() {    
        // navigate to the AddressPage
      String newAddress= myAccountPage.goToNewAddressPage().saveAddress(address);
      Assert.assertEquals(newAddress, address.getAddressAlias().toUpperCase());

	}
}
