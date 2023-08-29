package com.automationteststore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShoesProductPage {
    private WebDriver driver;
    private String addToCardButton = "//ul[@class = 'productpagecart']";
    private String selectSizeRadioButton = "//*[@id=\"option344747\"]";
    private String colourDropdown = "//select[@class='form-control ']";
    private String quantityField = "//input[contains(@name,'quantity')]";


    public ShoesProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCard() {
        driver.findElement(By.xpath(addToCardButton)).click();
    }

    public void clickSelectSizeRadioButton() {
        driver.findElement(By.xpath(selectSizeRadioButton)).click();
    }

    public void selectValueFromColourDropdown(String value) {
        WebElement selectColourDropdown = driver.findElement(By.xpath(colourDropdown));
        Select select = new Select(selectColourDropdown);
        select.selectByValue(value);

    }

    public void selectQuantityValue(int quantity) {
        driver.findElement(By.xpath(quantityField)).click();
        driver.findElement(By.xpath(quantityField)).clear();
        driver.findElement(By.xpath(quantityField)).sendKeys(String.valueOf(quantity));
    }


}
