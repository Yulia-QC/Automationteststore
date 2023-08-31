package com.automationteststore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
    private WebDriver driver;
    private String loginPage = "https://automationteststore.com/index.php?rt=account/login";
    private String usernameField = "//input[@id='loginFrm_loginname']";
    private String passwordField = "//input[@id='loginFrm_password']";
    private String loginButton = "//button[@title='Login']";
    private String forgotPasswordLink = "//a[contains(@href, '/forgotten/password')]";
    private String forgotLoginLink = "//a[contains(@href,'/forgotten/loginname')]";
    private String usernameErrorMassage = "//div[@class = 'alert alert-error alert-danger']";
    private String invalidPasswordErrorMessage = "//div[@class = 'alert alert-error alert-danger']";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserName(String username) {
        driver.findElement(By.xpath(usernameField)).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(By.xpath(passwordField)).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(By.xpath(loginButton)).click();
    }
    public void clickForgotLoginLink() {
        driver.findElement(By.xpath(forgotLoginLink)).click();
    }

    public void clickForgotPasswordLink() {
        driver.findElement(By.xpath(forgotPasswordLink)).click();
    }
}
