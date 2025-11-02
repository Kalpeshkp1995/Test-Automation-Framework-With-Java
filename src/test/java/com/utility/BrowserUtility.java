package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private Logger logger = LoggerUtility.getLogger(this.getClass());
	private WebDriverWait wait;

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
		; // initialize the instance variable driver
		wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
	}

	public BrowserUtility(String BrowserName) {
		logger.info("Launching Browser For  " + BrowserName);
		if (BrowserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		}

		else if (BrowserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else {
			logger.error("Invalid Browser Name....Please select chrome or edge");
			System.err.print("Invalid Browser Name....Please select chrome or edge ");
		}
	}

	public BrowserUtility(Browser browserName) {
		logger.info("Launching Browser For  " + browserName);
		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		}

		else if (browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		}

		else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
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
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {
				driver.set(new ChromeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}

		}

		else if (browserName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions option = new EdgeOptions();
				option.addArguments("--headless");
				option.addArguments("disable--gpu");
				driver.set(new EdgeDriver(option));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {
				driver.set(new EdgeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
		}

		else if (browserName == Browser.FIREFOX) {

			if (isHeadless) {
				FirefoxOptions option = new FirefoxOptions();
				option.addArguments("--headless");
				driver.set(new FirefoxDriver(option));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {
				driver.set(new FirefoxDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
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
		logger.info("Finding Element with the locator" + locator);
//		WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		logger.info("Element Found and performing click");
		element.click();

	}

	public void clickOnCheckbox(By locator) {
		logger.info("Finding Element with the locator" + locator);
//		WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element Found and performing click");
		element.click();

	}
	public void clickOn(WebElement element) {
		logger.info("Finding Element with the locator");
		element.click();

	}

	public void enterText(By locator, String textToEnter) {
		logger.info("Finding Element with the locator" + locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//		WebElement element = driver.get().findElement(locator);
		logger.info("Element Found and now enter text " + textToEnter);
		element.sendKeys(textToEnter);
	}

	public void clearText(By textlocator) {
		logger.info("Finding Element with the locator" + textlocator);
//		WebElement element = driver.get().findElement(textlocator);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(textlocator));
		logger.info("Element Found and now clearing text box field");
		element.clear();
	}

	public void selectFromDropdown(By dropdownLocator, String optionToSelect) {
		logger.info("Finding Element with the locator" + dropdownLocator);
		WebElement element = driver.get().findElement(dropdownLocator);
		Select select = new Select(element);
		logger.info("Selecting the Option" + optionToSelect);
		select.selectByVisibleText(optionToSelect);
	}

	public void enterSpecialKeyText(By locator, Keys keyToEnter) {
		logger.info("Finding Element with the locator" + locator);
//		WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element Found and now enter special keys " + keyToEnter);
		element.sendKeys(keyToEnter);
	}

	public List<String> getAllVisibleText(By locator) {
		logger.info("Finding All Elements with the locator" + locator);
		List<WebElement> elementList = driver.get().findElements(locator);
		logger.info("Elements Found and now printing the list of elements ");

		List<String> visileTextLst = new ArrayList<String>();

		for (WebElement element : elementList) {
			System.out.println(getVisibleText(element));
			visileTextLst.add(getVisibleText(element));
		}

		return visileTextLst;
	}

	public List<WebElement> getAllElements(By locator) {
		logger.info("Finding All Elements with the locator" + locator);
		List<WebElement> elementList = driver.get().findElements(locator);
		logger.info("Elements Found and now printing the list of elements ");

		return elementList;
	}

	public String getVisibleText(By locator) {
		logger.info("Finding Element with the locator" + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element Found and now returning visible text " + element.getText());
		return element.getText();
	}

	public String getVisibleText(WebElement element) {
		logger.info("Returning visible text " + element.getText());
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
