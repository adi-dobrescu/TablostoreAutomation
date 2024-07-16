package tests.checkout;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductPage;
import pages.CheckoutPage;
import base.BaseTest;



public class InvalidDiscountTest extends BaseTest {
    @Test
    public void testCheckoutValidDiscount() {
        driver.get(config.getProperty("productUrl"));

        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        productPage.addToCart();
        cartPage.goToCheckout();
        String message=config.getProperty("invalidDiscount");
        checkoutPage.enterDiscount(message);
        String actualMessage= checkoutPage.getDiscount();
        Assert.assertEquals(actualMessage,message,"Invalid Discount Not Approved!" );

    }
}