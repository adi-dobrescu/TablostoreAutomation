package tests.products;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;
import pages.CartPage;
import base.BaseTest;

public class QuantityTest extends BaseTest {
    ProductPage productPage = new ProductPage(driver);
    CartPage cartPage = new CartPage(driver);

    @Test
    public void testQuantity() {
        driver.get(config.getProperty("productUrl"));
        productPage.setQuantity("3");
        productPage.addToCart();
        String actualQuantity=cartPage.checkQuantity();
        Assert.assertEquals(actualQuantity,config.getProperty("testQuantity"), "Quantities do not match" );

        }
    }
