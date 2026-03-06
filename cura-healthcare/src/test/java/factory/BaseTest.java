package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BaseTest {

    protected WebDriver driver;

    public void setUp() {
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        options.addArguments("--window-size=1920,1080");
        System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");

        driver = new FirefoxDriver(options);
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void navigateTo(String url) {
        driver.get(url);
    }
}
