package tests.homepage;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;
import base.BaseTest;
import utils.ProductProperties;

public class SearchTest extends BaseTest {
    private ProductProperties productProperties;

    @Test
    public void testSearchBar() {

        productProperties = new ProductProperties("src/main/resources/config/products.json");
        HomePage homePage = new HomePage(driver);

        int expectedProductCount = productProperties.getProductCount();

        for (int i = 0; i < expectedProductCount; i++) {
            String expectedProductName = productProperties.getProductName(i);
            homePage.searchBar(expectedProductName);

            ProductPage productPage = new ProductPage(driver);
            String actualProductName = productPage.getProductName();
            System.out.println("\nThe name for the product from position "+Integer.toString(i+1)+ " is: " +actualProductName);
            Assert.assertEquals(actualProductName, expectedProductName, "Product name does not match");
        }
    }
}
