package com.automationteststore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class MyAccountPage {
    private WebDriver driver;
    private String myAccountPageUrl = "https://automationteststore.com/index.php?rt=account/account";

    private String maintext = "//span[@class='maintext']";
    private String apparelAccessoriesTab = "//ul[@class= 'nav-pills categorymenu']//a[contains (text(), 'Apparel & accessories')]";
    private String apparelAccessoriesShoes = "//a[contains (text(), 'Shoes')]";
    private String searchKeywords = "//div[@class='btn-group search-bar']";

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMyAccountPage() {
        driver.get(myAccountPageUrl);
    }

    public void verifyMainText() {
        String expectedText = "MY ACCOUNT";
        String actualText = driver.findElement(By.xpath(maintext)).getText();
        Assert.assertEquals(actualText, expectedText, "Text is not match");
    }

    public void clickOnApparelAccessoriesShoes() {
        WebElement elem = driver.findElement(By.xpath(apparelAccessoriesTab));
        Actions action = new Actions(driver);
        action.moveToElement(elem).perform();
        driver.findElement(By.xpath(apparelAccessoriesShoes)).click();
    }

    public void searchForItem() {
        driver.findElement(By.xpath(searchKeywords)).click();

    }


}
