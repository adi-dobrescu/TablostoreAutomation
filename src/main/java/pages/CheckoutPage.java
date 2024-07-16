package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterDiscount(String s){
        WebElement discountField=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("._1fragem2n > ._1fragemo1:nth-of-type(1) > div:nth-of-type(5) ._1fragemva")));
        discountField.sendKeys(s);
        WebElement discountButton=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("._1fragempw._1m2hr9g25")));
        discountButton.click();
    }

    public String getDiscount(){
        WebElement discountCode=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("._1fragem74 ._1fragemr4 ._1fragemuq")));
        return discountCode.getText();
    }

    public void enterEmail(String email){

    }

    public void enterPersonalData(){

    }

}
