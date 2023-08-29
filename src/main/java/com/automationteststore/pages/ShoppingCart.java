package com.automationteststore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ShoppingCart {
    private WebDriver driver;
    private String maintext = "//span[@class='maintext']";
    private String unitPrice;
    private String totalPrice;
    private String quantity = "//input[contains(@name,'quantity')]";


    public ShoppingCart(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyMaintext() {
        String expectedText = "SHOPPING CART";
        String actualText = driver.findElement(By.xpath(maintext)).getText();
        Assert.assertEquals(actualText, expectedText, "Text is not match");
    }

    public int getProductQuantity() {
        WebElement quantityInput = driver.findElement(By.xpath(quantity));
        return Integer.parseInt(quantityInput.getAttribute("value"));
    }
}
