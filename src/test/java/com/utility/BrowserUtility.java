package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
		; // initialize the instance variable driver
	}

	public BrowserUtility(String BrowserName) {
		logger.info("Launching Browser For  " + BrowserName);
		if (BrowserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		}

		else if (BrowserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		} else {
			logger.error("Invalid Browser Name....Please select chrome or edge");
			System.err.print("Invalid Browser Name....Please select chrome or edge ");
		}
	}

	public BrowserUtility(Browser browserName) {
		logger.info("Launching Browser For  " + browserName);
		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
		}

		else if (browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());
		}

		else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
		}

		else {
			System.err.print("Invalid Browser Name....Please select chrome or edge ");
		}
	}

// Headless mode script
	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info("Launching Browser For  " + browserName);
		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--headless");
				option.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(option));
			} else {
				driver.set(new ChromeDriver());
			}

		}

		else if (browserName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions option = new EdgeOptions();
				option.addArguments("--headless");
				option.addArguments("disable--gpu");
				driver.set(new EdgeDriver(option));
			} else {
				driver.set(new EdgeDriver());
			}
		}

		else if (browserName == Browser.FIREFOX) {

			if (isHeadless) {
				FirefoxOptions option = new FirefoxOptions();
				option.addArguments("--headless");
				driver.set(new FirefoxDriver(option));
			} else {
				driver.set(new FirefoxDriver());
			}

		}

		else {
			System.err.print("Invalid Browser Name....Please select chrome or edge ");
		}
	}

	public void goToWebsite(String url) {
		logger.info("Visiting the website " + url);
		driver.get().get(url);
	}

	public void maximizeWindow() {
		logger.info("Maximizing the browser window");
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		logger.info("Finding Element woth the locator" + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element Found and performing click");
		element.click();

	}

	public void enterText(By locator, String textToEnter) {
		logger.info("Finding Element woth the locator" + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element Found and now enter text " + textToEnter);
		element.sendKeys(textToEnter);
	}

	public String getVisibleText(By locator) {
		logger.info("Finding Element woth the locator" + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element Found and now returning visible text " + element.getText());
		return element.getText();

	}

	public String takesScreenshot(String name) {

		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String path = "./screenshots/" + name + " - " + timeStamp + ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	public void quit() {

		driver.get().quit();
	}

}
