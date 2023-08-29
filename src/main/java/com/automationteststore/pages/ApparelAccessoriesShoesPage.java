package com.automationteststore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ApparelAccessoriesShoesPage {
    private WebDriver driver;
    private String addToShoesProductPage = "(//a[@title= 'Add to Cart'])[1]";

    public ApparelAccessoriesShoesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openShoesProductPage(int id) {

        String locator = String.format(addToShoesProductPage, id);

        driver.findElement(By.xpath(locator)).click();

    }

}
