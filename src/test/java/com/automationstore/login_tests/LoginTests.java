package com.automationstore.login_tests;

import com.automationteststore.base.DriverFactory;
import com.automationteststore.pages.HomePage;
import com.automationteststore.pages.LoginPage;
import com.automationteststore.pages.MyAccountPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTests {
    private WebDriver driver;

    @BeforeTest
    public void setUpDriver() {
        driver = DriverFactory.getDriver();
    }

    @Test
    public void loginTestWithValidCredentials() {

        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.clickLoginOrRegisterButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName();
        loginPage.enterPassword();
        loginPage.clickLoginButton();

        String expectedUrl = "https://automationteststore.com/index.php?rt=account/account";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.verifyMainText();

//        driver.quit();


    }
}
