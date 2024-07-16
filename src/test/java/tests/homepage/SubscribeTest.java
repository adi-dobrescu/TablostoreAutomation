package tests.homepage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import base.BaseTest;


public class SubscribeTest extends BaseTest {
    @Test
    public void testSearchBar() {
        driver.get(config.getProperty("homeUrl"));
        HomePage homePage = new HomePage(driver);
        homePage.subscribe(config.getProperty("invalidEmail"));
        WebElement subscribeError=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".site-footer__newsletter-error")));
        String actualMessage=subscribeError.getText();
        String desiredMessage=config.getProperty("invalidEmailMessage");
        Assert.assertEquals(actualMessage, desiredMessage, "Subscribe error message not displayed!");
    }
}
