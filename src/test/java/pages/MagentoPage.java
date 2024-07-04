package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MagentoPage {

    private WebDriver driver;

    public MagentoPage(WebDriver driver) {
        this.driver = driver;
    }

    private By regAcc = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a");
    private By firstName = By.id("firstname");
    private By lastName = By.id("lastname");
    private By emailAdress = By.id("email_address");
    private By pass = By.id("password");
    private By rePass = By.id("password-confirmation");
    private By regBtn = By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span");
    private By logoBtn = By.xpath("/html/body/div[2]/header/div[2]/a/img");
    private By AddToCartBtn = By.id("product-addtocart-button");
    private By sizeBtn = By.id("option-label-size-143-item-168");
    private By colorbtn = By.id("option-label-color-93-item-50");
    private By cartBtn = By.xpath("/html/body/div[2]/header/div[2]/div[1]/a");
    private By checkoutBtn = By.id("top-cart-btn-checkout");
    private By strAddress = By.name("street[0]");
    private By city = By.name("city");
    private By postalCode = By.name("postcode");
    private By provice = By.name("region");
    private By phoneNumber = By.name("telephone");
    private By nextBtn = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button");
    private By placeOrderBtn = By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button/span");

    String password = "Marko.123";

    public static String randomEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public void clickRegister() {driver.findElement(regAcc).click();}
    public void enterName() {driver.findElement(firstName).sendKeys("Marko");}
    public void enterLastname() {driver.findElement(lastName).sendKeys("Mihajlovski");}
    public void enterEmail() {driver.findElement(emailAdress).sendKeys(randomEmail());}
    public void enterPassword() {driver.findElement(pass).sendKeys(password);}
    public void reEnterPassword() {driver.findElement(rePass).sendKeys(password);}
    public void clickRegAcc() {driver.findElement(regBtn).click();}
    public void clickLogoBtn() {driver.findElement(logoBtn).click();}
    public void clickAddToCartBtn() {driver.findElement(AddToCartBtn).click();}
    public void clickSize() {driver.findElement(sizeBtn).click();}
    public void clickColor() {driver.findElement(colorbtn).click();}
    public void clickCart() {driver.findElement(cartBtn).click();}
    public void clickcheckoutBtn() {driver.findElement(checkoutBtn).click();}
    public void enterAddress() {driver.findElement(strAddress).sendKeys("Markovska 45A");}
    public void enterCity() {driver.findElement(city).sendKeys("Kumanovo");}
    public void enterPostalCode() {driver.findElement(postalCode).sendKeys("1300");}
    public void enterProvice() {driver.findElement(provice).sendKeys("Kumanovo");}
    public void enterPhoneNumber() {driver.findElement(phoneNumber).sendKeys("071-123-456");}
    public void clickNext() {driver.findElement(nextBtn).click();}
    public void clickPlaceOrder() {driver.findElement(placeOrderBtn).click();}


}
