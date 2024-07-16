package base;

import utils.ConfigReader;
import utils.WDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.Properties;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Properties config;

    @BeforeMethod
    public void setUp() {
        config = ConfigReader.initProperties();
        driver = WDriver.getDriver(config.getProperty("browser"));
        driver.manage().window().maximize();
        driver.get(config.getProperty("url"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            Thread.sleep(2000);
            driver.quit();
        }
    }
}
