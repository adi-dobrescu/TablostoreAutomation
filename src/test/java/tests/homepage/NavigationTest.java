package tests.homepage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import base.BaseTest;
import java.util.Arrays;
import java.util.List;

public class NavigationTest extends BaseTest {

        @Test
    public void testNavigation() {
        driver.get(config.getProperty("homeUrl"));
        HomePage homePage = new HomePage(driver);
        List<By> selectors = homePage.getCollectionSelectors();
        List<String> expectedUrls = Arrays.asList(
                config.getProperty("collectionsUrl"),
                config.getProperty("personalizateUrl"),
                config.getProperty("aboutusUrl"),
                config.getProperty("contactUrl")
        );

        for (int i = 0; i < selectors.size(); i++) {
            String currentUrl = homePage.navigateToCollections(selectors.get(i));
            Assert.assertEquals(currentUrl, expectedUrls.get(i), "URL does not match expected URL: " + currentUrl);
            driver.navigate().back();
        }
    }
    }
