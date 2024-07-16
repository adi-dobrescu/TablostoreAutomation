package tests.products;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;
import pages.CollectionPage;
import base.BaseTest;
import utils.ProductProperties;


public class NameTest extends BaseTest {

    private ProductProperties productProperties;

    @Test
    public void productNameTest() {

       // productProperties = new ProductProperties("src/main/resources/config/products.json");
        productProperties = new ProductProperties(config.getProperty("jsonFile"));

        CollectionPage collectionPage = new CollectionPage(driver);

        // check nr of products
        int expectedProductCount = productProperties.getProductCount();

        // iterate through products
        for (int i = 0; i < expectedProductCount; i++) {
            collectionPage.clickProduct(Integer.toString(i+1));

            // check name
            String expectedProductName = productProperties.getProductName(i);
            ProductPage productPage = new ProductPage(driver);
            String actualProductName = productPage.getProductName();
            System.out.println("\nThe name for the product from position "+Integer.toString(i+1)+ " is: " +actualProductName);
            Assert.assertEquals(actualProductName, expectedProductName, "Product name does not match");

            driver.navigate().back();

        }
    }
}
