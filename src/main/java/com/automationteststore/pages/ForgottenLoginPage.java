package com.automationteststore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ForgottenLoginPage {
    private WebDriver driver;
    private String maintext = "//span[contains(text(), ' Forgot Your Login Name?')]";
    private String lastNameField = "//input[@id='forgottenFrm_lastname']";
    private String emailField = "//input[@id='forgottenFrm_email']";
    private String continueButton = "//button[@title='Continue']";

    public String getMaintext() {
        return maintext;
    }
}
