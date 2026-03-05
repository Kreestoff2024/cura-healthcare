package factory;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
      //  options.addArguments("--start-fullscreen");
        driver = new FirefoxDriver(options);
        driver.manage().window().setSize(new Dimension(1920,1080));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public void navigateTo(String url){
        driver.navigate().to(url);
    }
}
