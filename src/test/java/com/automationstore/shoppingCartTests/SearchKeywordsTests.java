package com.automationstore.shoppingCartTests;

import com.automationteststore.base.BrowserDriverFactory;
import com.automationteststore.base.CSVDataProvider;
import com.automationteststore.pages.HomePage;
import com.automationteststore.pages.ProductMeetingSearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class SearchKeywordsTests {
    private WebDriver driver;


    @BeforeTest
    public void setUpDriver() {

        driver = BrowserDriverFactory.getDriver();
    }
    @DataProvider(name = "csvReader")
    public Iterator<Object[]> provideTestData() {
        String csvFilePath = "src/test/resources/DataProviders/search_products.csv";
        return CSVDataProvider.provideData(csvFilePath);
    }
    @Test(dataProvider = "csvReader")

    public void verifyPositiveSearchProductTest(HashMap<String, String> testData) {

        String productName = testData.get("productName");
        System.out.println((productName));

        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.enterSearchValue(productName);

        ProductMeetingSearchPage productMeetingSearchPage = new ProductMeetingSearchPage(driver);
        productMeetingSearchPage.verifyExistingProduct(productName);

    }
<<<<<<< HEAD
=======

>>>>>>> 4fcfd96d644711ee337b6ee0e9737c834b076fed
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
