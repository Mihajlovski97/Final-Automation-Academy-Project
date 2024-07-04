package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("121");
        driver = new ChromeDriver(options);
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void testFinish() {
        driver.quit();
    }

}
