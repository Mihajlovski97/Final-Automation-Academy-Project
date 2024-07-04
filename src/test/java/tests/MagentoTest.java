package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MagentoPage;
import utils.BaseClass;

import java.util.concurrent.TimeUnit;

public class MagentoTest extends BaseClass {

    @Test
    public void registerTest() throws InterruptedException {
        MagentoPage magento = new MagentoPage(driver);

        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a")).getText(),
                "Create an Account");
        magento.clickRegister();
        Thread.sleep(2000);
        // Verify that user is on right place
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span")).getText(),
                "Create New Customer Account");
        // Enter personal information
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"form-validate\"]/fieldset[1]/div[1]/label/span")).getText(),
                "First Name");
        magento.enterName();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"form-validate\"]/fieldset[1]/div[2]/label/span")).getText(),
                "Last Name");
        magento.enterLastname();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"form-validate\"]/fieldset[2]/div[1]/label/span")).getText(),
                "Email");
        magento.enterEmail();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"form-validate\"]/fieldset[2]/div[2]/label/span")).getText(),
                "Password");
        magento.enterPassword();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"form-validate\"]/fieldset[2]/div[3]/label/span")).getText(),
                "Confirm Password");
        magento.reEnterPassword();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span")).getText(),
                "Create an Account");
        magento.clickRegAcc();
        Thread.sleep(2000);
    }

    @Test
    public void addProductsTest() throws InterruptedException {
        MagentoPage magento = new MagentoPage(driver);
        magento.clickLogoBtn();
        // Add first product to the cart
        WebElement mainMenu = driver.findElement(By.xpath("//*[@id=\"ui-id-2\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(mainMenu);
        WebElement subMenu = driver.findElement(By.xpath("//*[@id=\"ui-id-5\"]"));
        actions.moveToElement(subMenu);
        actions.click(driver.findElement(By.xpath("//*[@id=\"ui-id-17\"]"))).build().perform();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"page-title-heading\"]/span")).getText(),
                "Tops");
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[2]/div")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div/div[1]/div[1]/h1/span")).getText(),
                "Atlas Fitness Tank");
        magento.clickSize();
        magento.clickColor();
        magento.clickAddToCartBtn();
        Thread.sleep(3000);
        // Verify that product is added to the cart
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).getText(),
                "You added Atlas Fitness Tank to your shopping cart.");
        // Add Second product to the cart
        driver.findElement(By.id("search")).sendKeys("backpack", Keys.ENTER);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span")).getText(),
                "Search results for: 'backpack'");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[1]/div/a/span/span/img")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div/div[1]/div[1]/h1/span")).getText(),
                "Driven Backpack");
        magento.clickAddToCartBtn();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).getText(),
                "You added Driven Backpack to your shopping cart.");
        magento.clickCart();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"top-cart-btn-checkout\"]")).getText(),
                "Proceed to Checkout");
        magento.clickcheckoutBtn();
        Thread.sleep(3000);
    }

    @Test
    public void finalE2ETest() throws InterruptedException {
        MagentoPage magento = new MagentoPage(driver);
        registerTest();
        addProductsTest();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"shipping\"]/div[1]")).getText(),
                "Shipping Address");
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"shipping-new-address-form\"]/div[1]/label/span")).getText(),
                "First Name");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"shipping-new-address-form\"]/div[2]/label/span")).getText(),
                "Last Name");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"shipping-new-address-form\"]/fieldset/legend/span")).getText(),
                "Street Address");
        magento.enterAddress();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"shipping-new-address-form\"]/div[4]/label/span")).getText(),
                "City");
        magento.enterCity();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"shipping-new-address-form\"]/div[7]/label/span")).getText(),
                "Zip/Postal Code");
        magento.enterPostalCode();
        js.executeScript("window.scrollBy(0,250)", "");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"shipping-new-address-form\"]/div[8]/label/span")).getText(),
                "Country");
        Select dropdown = new Select(driver.findElement(By.name("country_id")));
        dropdown.selectByVisibleText("North Macedonia");
        Thread.sleep(3000);
        magento.enterProvice();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"shipping-new-address-form\"]/div[9]/label/span")).getText(),
                "Phone Number");
        magento.enterPhoneNumber();
        magento.clickNext();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"checkout\"]/ul/li[2]/span")).getText(),
                "Review & Payments");
        magento.clickPlaceOrder();
        Thread.sleep(3000);
    }
}
