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


    public static void main(String[] args) {
        int x = 7;
        int y = 3;
        int z = 4;
        System.out.println(x++ + ++y - --z + (z-- + x + y++) + x++ + ++y + z--);
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);

        z+=10;
        y-=5;
        System.out.println(z);
        System.out.println(y);

        int e =5;
        int r = 5;
        System.out.println(e == r);
        System.out.println(e != r);
        System.out.println(7 != 8);

        int t = 7;
        int o = 9;
        System.out.println(t > o);
        System.out.println(t >= o);
        System.out.println(t < o);
        System.out.println(t <= o);
        System.out.println(9 <= 9);

    }

}
