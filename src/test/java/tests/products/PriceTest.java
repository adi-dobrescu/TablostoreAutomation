package tests.products;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;
import pages.CollectionPage;
import base.BaseTest;
import utils.ProductProperties;
import java.util.Map;

public class PriceTest extends BaseTest {

    private ProductProperties productProperties;


    @Test
    public void testAllProductDetails() {

        productProperties = new ProductProperties(config.getProperty("jsonFile"));
        CollectionPage collectionPage = new CollectionPage(driver);

        int expectedProductCount = productProperties.getProductCount();

        for (int i = 0; i < expectedProductCount; i++) {
            collectionPage.clickProduct(Integer.toString(i+1));

            ProductPage productPage = new ProductPage(driver);

            String actualProductName = productPage.getProductName();
            System.out.println("\nProduct name: " + actualProductName);

            Map<String, String> expectedVariants = productProperties.getProductVariants(i);

            Select variantDropdown = new Select(driver.findElement(By.cssSelector("select#SingleOptionSelector-0")));

            for (Map.Entry<String, String> entry : expectedVariants.entrySet()) {

                String variantKey = entry.getKey();
                String expectedPrice = entry.getValue();

                variantDropdown.selectByVisibleText(variantKey);
                String displayedPrice = productPage.getVariantPrice();

                System.out.println("The price for variant "+ variantKey+ " is: " + displayedPrice);
                Assert.assertEquals(displayedPrice, expectedPrice, "Price does not match for variant: " + variantKey);
            }
            driver.navigate().back();
        }
    }
}
