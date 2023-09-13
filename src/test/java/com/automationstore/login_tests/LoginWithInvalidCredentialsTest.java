package com.automationstore.login_tests;

import com.automationteststore.base.BrowserDriverFactory;
import com.automationteststore.base.CSVDataProvider;
import com.automationteststore.pages.HomePage;
import com.automationteststore.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Iterator;

@Ignore
public class LoginWithInvalidCredentialsTest {
    private WebDriver driver;


    @BeforeClass
    public void setUpDriver() {

        driver = BrowserDriverFactory.getDriver();
    }
    @DataProvider(name = "csvReader")
    public Iterator<Object[]> provideTestData() {
        String csvFilePath = "src/test/resources/DataProviders/invalid_credentials.csv";
        return CSVDataProvider.provideData(csvFilePath);
    }


    @Test(dataProvider = "csvReader")
    public void negativeLoginTest(HashMap<String, String> testData) {
        String username = testData.get("username");
        String password = testData.get("password");

        System.out.println((username + " " + password));

        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.clickLoginOrRegisterButton();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
