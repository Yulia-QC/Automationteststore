package com.automationteststore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductMeetingSearchPage {
    private WebDriver driver;
    private String productMeetingSearchPageUrl = "https://automationteststore.com/index.php?rt=product/search&keyword=armani&category_id=0";
    private String product = "//a[contains(@href,'Armani')]";
    public ProductMeetingSearchPage(WebDriver driver) {
        this.driver = driver;
    }
    public void verifyExistingProduct(String productName) {
        String productXPath = "//a[contains(@href,'" + productName + "')]";
        List<WebElement> searchResults = driver.findElements(By.xpath(productXPath));
        assert !searchResults.isEmpty() : "Search results not displayed";
    }
}
