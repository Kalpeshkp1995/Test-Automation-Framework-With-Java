package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pages.HomePage;
import com.ui.pages.LogInPage;

public class LoginTest2 {

	public static void main(String[] args) {
		WebDriver wd= new ChromeDriver();
		
		
		HomePage homePage=new HomePage(CHROME,true);
		homePage.goToWebsite("http://www.automationpractice.pl/index.php");
		LogInPage loginPage=homePage.goToLoginPage();
		loginPage.doLoginWith("timotoj174@asaption.com", "Password");
	}

}
