package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String checkQuantity() {
        WebElement checkQuantity=wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".medium-up--hide [type]")));
        return checkQuantity.getText();
    }

    public void goToCheckout(){
        WebElement goToCheckout=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn--small-wide")));
        goToCheckout.click();
    }

}
