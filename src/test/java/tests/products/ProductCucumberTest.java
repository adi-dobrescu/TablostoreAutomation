package tests.products;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.CollectionPage;
import pages.ProductPage;
import utils.ProductProperties;
import base.BaseTest;

public class ProductCucumberTest extends BaseTest {
    private CollectionPage collectionPage;
    private ProductPage productPage;


    public ProductCucumberTest() {
    }

    @Given("I am on the collection page")
    public void i_am_on_the_collection_page() {
        collectionPage = new CollectionPage(driver);
        driver.get(config.getProperty("floralUrl"));
    }

    @When("I click on product number {string}")
    public void i_click_on_product_number(String productNumber) {
        collectionPage.clickProduct(productNumber);
        productPage = new ProductPage(driver);
    }

    @Then("the product name should be {string}")
    public void the_product_name_should_be(String expectedProductName) {
        String actualProductName = productPage.getProductName();
        System.out.println("\nThe name for the product is: " + actualProductName);
        Assert.assertEquals(actualProductName, expectedProductName, "Product name does not match");
    }

    @Then("the price for variant {string} should be {string}")
    public void the_price_for_variant_should_be(String variant, String expectedPrice) {
        Select variantDropdown = new Select(driver.findElement(By.cssSelector("select#SingleOptionSelector-0")));
        variantDropdown.selectByVisibleText(variant);
        String displayedPrice = productPage.getVariantPrice();
        System.out.println("The price for variant " + variant + " is: " + displayedPrice);
        Assert.assertEquals(displayedPrice, expectedPrice, "Price does not match for variant: " + variant);
    }

}

