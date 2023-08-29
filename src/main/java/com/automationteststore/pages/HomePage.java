package com.automationteststore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class HomePage {
    private WebDriver driver;
    private String homePageUrl = "https://automationteststore.com/";
    private String loginOrRegisterButton = "//a[text()='Login or register']";
    private String searchKeywordsField = "//div[@class='btn-group search-bar']//input[@id= 'filter_keyword']";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginOrRegisterButton() {
        driver.findElement(By.xpath(loginOrRegisterButton)).click();

    }


    public void openPage() {
        driver.get(homePageUrl);
    }

    public void enterSearchValue(String product) {
        WebElement searchField = driver.findElement(By.xpath(searchKeywordsField));
        searchField.sendKeys(product);
        searchField.sendKeys(Keys.ENTER);


    }

    public void verifyExistingProduct(String product) {

    }
}
