package com.automationteststore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgottenPasswordPage {
    private WebDriver driver;
    private String maintext = "//span[contains(text(), ' Forgot Your Password?')]";
    private String lastNameField = "//input[@id='forgottenFrm_loginname']";
    private String emailField = "//input[@id='forgottenFrm_email']";
    private String continueButton = "//button[@title='Continue']";

    public String getMaintext() {
        return maintext;
    }

    public void enterlastName(String username) {
        driver.findElement(By.xpath(lastNameField)).sendKeys(username);
    }

    public void enterEmail(String email) {
        driver.findElement(By.xpath(emailField)).sendKeys(email);
    }
    public void clickContinueButton() {
        driver.findElement(By.xpath(continueButton)).click();
    }
}
