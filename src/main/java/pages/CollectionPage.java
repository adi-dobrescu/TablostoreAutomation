package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CollectionPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CollectionPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickProduct(String i) {
        WebElement clickProduct = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".medium-up--one-quarter:nth-of-type("+i+") .grid-view-item__image-container")));
        clickProduct.click();
    }
}
