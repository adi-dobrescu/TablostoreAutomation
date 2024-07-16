package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    List<By> collectionSelectors = Arrays.asList(
            By.cssSelector("#SiteNav li:nth-of-type(2) .site-nav__label"),
            By.cssSelector("#SiteNav li:nth-of-type(3) .site-nav__label"),
            By.cssSelector("#SiteNav li:nth-of-type(4) .site-nav__label"),
            By.cssSelector("#SiteNav li:nth-of-type(5) .site-nav__label")
    );

    public String navigateToCollections(By selector) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(selector));
        element.click();
        return driver.getCurrentUrl();
    }

    public List<By> getCollectionSelectors() {
        return collectionSelectors;
    }

    public void clickPage(){
        WebElement clickPage=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".medium-up--one-quarter:nth-of-type(1) .collection-grid-item__title-wrapper")));
        clickPage.click();

    }

    public void searchBar(String a){
        WebElement searchIcon=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".site-header__icons-wrapper .icon-search")));
        searchIcon.click();
        WebElement searchBar=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".search-form__input")));
        searchBar.clear();
        searchBar.sendKeys(a);
        WebElement searchResult=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".predictive-search-item__title")));
        searchResult.click();
    }

    public void subscribe(String s){
        WebElement subscribe=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#ContactFooter-email")));
        subscribe.sendKeys(s);
        WebElement subscribeButton=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#Subscribe")));
        subscribeButton.click();

    }

}
