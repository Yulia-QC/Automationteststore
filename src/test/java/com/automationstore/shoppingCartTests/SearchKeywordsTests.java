package com.automationstore.shoppingCartTests;

import com.automationteststore.base.BrowserDriverFactory;
import com.automationteststore.base.CSVDataProvider;
import com.automationteststore.pages.HomePage;
import com.automationteststore.pages.ProductMeetingSearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Iterator;


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

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
