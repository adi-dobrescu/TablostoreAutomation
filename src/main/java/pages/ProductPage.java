package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getProductName(){
        WebElement productName=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-single__title")));
        return productName.getText();
    }

    public String getVariantPrice(){
        WebElement variantPrice=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".price__pricing-group .price__regular .price-item--regular")));
        return variantPrice.getText();
    }

//    public void selectVariant(int i) {
//        WebElement selVariant = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("select#SingleOptionSelector-0")));
//        Select dropdown = new Select(selVariant);
//        dropdown.selectByIndex(i);
//    }

    public void setQuantity(String i){
        WebElement quantity = wait.until(ExpectedConditions.elementToBeClickable(By.id("Quantity-product-template")));
        quantity.click();
        quantity.clear();
        quantity.sendKeys(i);
    }

    public void addToCart(){
        WebElement add = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".product-form__cart-submit")));
        add.click();
    }

}
