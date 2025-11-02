package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class SearchResultPage extends BrowserUtility {

	private static final By PRODUCT_LISTING_TITLE_LOCATOR = By.xpath("//span[@class=\"lighter\"]");
	private static final By All_PRODUCT_LISTS_NAME_LOCATOR = By.xpath("//h5[@itemprop=\"name\"]/a");

	public SearchResultPage(WebDriver diver) {
		super(diver);
	}

	public String getSearchResultTitle() {
		return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
	}

	public boolean isSearchTermPresentInProductList(String searchTerm) {
		List<String> keywords = Arrays.asList(searchTerm.toLowerCase().split(" "));
		List<String> productNameList = getAllVisibleText(All_PRODUCT_LISTS_NAME_LOCATOR);
		boolean result = productNameList.stream()
				.anyMatch(name -> (keywords.stream().anyMatch(name.toLowerCase()::contains)));
		return result;

	}

	public ProductDetailPage clickOnProductAtIndex(int index) {
		clickOn(getAllElements(All_PRODUCT_LISTS_NAME_LOCATOR).get(index));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProductDetailPage productDetailPage = new ProductDetailPage(getDriver());
		return productDetailPage;
	};

}
