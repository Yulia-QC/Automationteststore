package com.automationteststore.pages;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class LoginPage {
    private WebDriver driver;
    private String usernameField = "//input[@id='loginFrm_loginname']";
    private String passwordField = "//input[@id='loginFrm_password']";
    private String loginButton = "//button[@title='Login']";
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


    public String getWrongUsernameErrorMessage() {
        String actualMessage = driver.findElement(By.xpath(usernameErrorMassage)).getText();
        return actualMessage;
    }

    public String getWrongPasswordErrorMessage() {
        String actualMessage = driver.findElement(By.xpath(invalidPasswordErrorMessage)).getText();
        return actualMessage;
    }

    public void clickLoginButton() {
        driver.findElement(By.xpath(loginButton)).click();
    }
}
