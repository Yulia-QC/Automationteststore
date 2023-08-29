package com.automationstore.shoppingCartTests;

import com.automationstore.login_tests.SearchKeywordsTests;
import com.automationteststore.base.BrowserDriverFactory;
import com.automationteststore.pages.ApparelAccessoriesShoesPage;
import com.automationteststore.pages.MyAccountPage;
import com.automationteststore.pages.ShoesProductPage;
import com.automationteststore.pages.ShoppingCart;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;



public class AddShoppingCartTests {
    private WebDriver driver;


    @BeforeTest
    public void setUpDriver() {

        driver = BrowserDriverFactory.getDriver();
    }


    @Test
    @Parameters({"productQuantity"})
    public void addProductFromApparelAccessoriesShoesTest(int productQuantity) {
        System.out.println("Current input product quantity is " + productQuantity);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.openMyAccountPage();
        myAccountPage.clickOnApparelAccessoriesShoes();

        ApparelAccessoriesShoesPage shoesPage = new ApparelAccessoriesShoesPage(driver);
        shoesPage.openShoesProductPage(116);

        ShoesProductPage productPage = new ShoesProductPage(driver);
        productPage.clickSelectSizeRadioButton();
        productPage.selectValueFromColourDropdown("753");
        productPage.selectQuantityValue(1);
        productPage.addToCard();

        ShoppingCart shoppingCart = new ShoppingCart(driver);
        shoppingCart.verifyMaintext();
        int actualQuantity = shoppingCart.getProductQuantity();
        Assert.assertEquals(productQuantity, actualQuantity, "Quantity doesn't match.");


    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
