package com.automationstore.login_tests;

import com.automationteststore.base.BrowserDriverFactory;
import com.automationteststore.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class ForgotFunctionalityTests {
    private WebDriver driver;
//    private String title = driver.getTitle();


    @BeforeTest
    public void setUpDriver() {

        driver = BrowserDriverFactory.getDriver();
    }

    @BeforeMethod
    public void openLoginPage() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.clickLoginOrRegisterButton();

    }

    @Test
    public void forgotLoginNovigationPageTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickForgotLoginLink();

        String expectedUrl = "https://automationteststore.com/index.php?rt=account/forgotten/loginname";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");

        ForgottenLoginPage forgottenLoginPage = new ForgottenLoginPage();
        String expectedText = "FORGOT YOUR LOGIN NAME?";
        String actualText = driver.findElement(By.xpath(forgottenLoginPage.getMaintext())).getText();
        Assert.assertEquals(actualText, expectedText, "Text is not match");


    }

    @Test
    public void forgotPasswordNovigationTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickForgotPasswordLink();

        String expectedUrl = "https://automationteststore.com/index.php?rt=account/forgotten/password";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");

        ForgottenPasswordPage forgottenpasswordPage = new ForgottenPasswordPage(driver);
        String expectedText = "FORGOT YOUR PASSWORD?";
        String actualText = driver.findElement(By.xpath(forgottenpasswordPage.getMaintext())).getText();
        Assert.assertEquals(actualText, expectedText, "Text is not match");


    }

    @Test
    public void resetPasswordTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickForgotPasswordLink();

        ForgottenPasswordPage forgottenPasswordPage = new ForgottenPasswordPage(driver);
        forgottenPasswordPage.enterlastName("username");
        forgottenPasswordPage.enterEmail("any@valid.com");
        forgottenPasswordPage.clickContinueButton();

        String expectedUrl = "https://automationteststore.com/index.php?rt=account/account";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");

    }



    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
