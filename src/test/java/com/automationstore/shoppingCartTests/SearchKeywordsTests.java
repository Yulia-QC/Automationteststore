package com.automationstore.shoppingCartTests;

import com.automationteststore.base.BrowserDriverFactory;
import com.automationteststore.pages.HomePage;
import com.automationteststore.pages.ProductMeetingSearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;


public class SearchKeywordsTests {
    private WebDriver driver;


    @BeforeTest
    public void setUpDriver() {

        driver = BrowserDriverFactory.getDriver();
    }

    @Test
    public void verifyPositiveSearchProductTest() {
        String productName = "Armani";

        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.enterSearchValue(productName);

        ProductMeetingSearchPage productMeetingSearchPage = new ProductMeetingSearchPage(driver);
        productMeetingSearchPage.verifyExistingProduct(productName);

    }
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
