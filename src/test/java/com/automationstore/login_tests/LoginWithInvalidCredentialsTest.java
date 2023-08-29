package com.automationstore.login_tests;

import com.automationteststore.base.BrowserDriverFactory;
import com.automationteststore.base.CSVDataProvider;
import com.automationteststore.pages.HomePage;
import com.automationteststore.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.HashMap;


public class LoginWithInvalidCredentialsTest {
    private WebDriver driver;


    @BeforeTest
    public void setUpDriver() {

        driver = BrowserDriverFactory.getDriver();
    }


    @Test(dataProvider = "csvReader", dataProviderClass = CSVDataProvider.class)
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


    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
