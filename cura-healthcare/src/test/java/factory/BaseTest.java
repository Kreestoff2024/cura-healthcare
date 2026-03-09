package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.VerifyInDriver;

public class BaseTest {

    protected WebDriver driver;
    protected VerifyInDriver verify;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "/home/christophe/.cache/selenium/geckodriver/linux64/0.36.0//geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");

        driver = new FirefoxDriver(options);
        verify = new VerifyInDriver(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void navigateTo(String url) {
        driver.get(url);
    }
}
