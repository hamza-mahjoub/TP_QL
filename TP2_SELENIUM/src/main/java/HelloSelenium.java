
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HelloSelenium {

    WebDriver driver;
    JavascriptExecutor js;
    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

    @Before
    public void prepareDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(1));

        js = (JavascriptExecutor) driver;
    }

    @Test
    public void BuyMacBookTest() throws InterruptedException {

        //getting the page
        driver.get("https://www.tunisianet.com.tn");

        //creating an account
        Account account = new Account(
                RandomStringUtils.random(5, true, false),
                RandomStringUtils.random(5, true, false),
                RandomStringUtils.random(5,true,true)+"@gmail.com",
                RandomStringUtils.random(5,true,true)+"pass",
                new Date(new Date().getTime() - TimeUnit.DAYS.toMillis(1) * 365 * 18)
        );

        //going to the create account page
        WebElement userAccount = driver.findElement(By.cssSelector("ul.dropdown-menu.user-down.dropdown-menu-right>li>a"));
        clickButton(js,userAccount);
        WebElement createAccount = driver.findElement(By.cssSelector("div.no-account>a"));
        clickButton(js,createAccount);
        Thread.sleep(4000);

        // Fill the form with the random account information
        List<WebElement> genderOptions = driver.findElements(By.className("custom-radio"));
        clickButton(js,genderOptions.get(0));
        List<WebElement> signupForm = driver.findElements(By.cssSelector("input.form-control"));
        signupForm.get(1).sendKeys(account.firstName);
        signupForm.get(2).sendKeys(account.lastName);
        signupForm.get(3).sendKeys(account.email);
        signupForm.get(4).sendKeys(account.password);
        signupForm.get(5).sendKeys(dateFormatter.format(account.birthday));
        Thread.sleep(4000);
        WebElement signupButton = driver.findElement(By.className("form-control-submit"));
        clickButton(js,signupButton);
        Thread.sleep(4000);

        //logout
        WebElement logoutButton = driver.findElement(By.className("logout"));
        clickButton(js,logoutButton);
        Thread.sleep(4000);

        //authentification
        userAccount = driver.findElement(By.cssSelector("ul.dropdown-menu.user-down.dropdown-menu-right>li>a"));
        clickButton(js, userAccount);
        WebElement email = driver.findElement(By.name("email"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement submitLogin = driver.findElement(By.id("submit-login"));
        email.sendKeys(account.email);
        password.sendKeys(account.password);
        Thread.sleep(4000);
        clickButton(js, submitLogin);
        Thread.sleep(4000);

        //search for article
        WebElement searchQueryTop = driver.findElement(By.id("search_query_top"));
        WebElement submitSearch = driver.findElement(By.name("submit_search"));
        searchQueryTop.sendKeys("PC portable MacBook M1 13.3");
        Thread.sleep(4000);
        clickButton(js, submitSearch);
        Thread.sleep(4000);

        //choosing an item
        List<WebElement> productsList = driver.findElements(By.cssSelector("#js-product-list>div.products.product-thumbs.row.wb-product-list>div.item-product.col-xs-12"));
        if (!productsList.isEmpty()) {
            WebElement firstProductCartButton = driver.findElement(By.cssSelector("." + productsList.get(0).getAttribute("className").replace(" ", ".") + " button"));
            clickButton(js, firstProductCartButton);
            WebElement commandButton = driver.findElement(By.cssSelector("div.cart-content-btn>a"));
            clickButton(js, commandButton);
            WebElement addToCartButton = driver.findElement(By.cssSelector("main #main div.checkout.cart-detailed-actions.card-block a"));
            clickButton(js, addToCartButton);
        }
        Thread.sleep(4000);

        //filling address form
        List<WebElement> addressForm = driver.findElements(By.cssSelector(".form-fields>div.form-group.row>div.col-md-6>input"));
        addressForm.get(4).sendKeys("test place");
        addressForm.get(6).sendKeys("1111");
        addressForm.get(7).sendKeys("test place");
        addressForm.get(8).sendKeys("12345678");
        Thread.sleep(4000);
        WebElement confirmAddresses = driver.findElement(By.name("confirm-addresses"));
        clickButton(js, confirmAddresses);
        Thread.sleep(4000);

        //Comment section
        WebElement commentInput = driver.findElement(By.id("delivery_message"));
        js.executeScript("window.scrollBy(0,250)", "");
        commentInput.sendKeys("une commande urgente !");
        Thread.sleep(4000);
        WebElement confirmDeliveryModeButton = driver.findElement(By.name("confirmDeliveryOption"));
        clickButton(js, confirmDeliveryModeButton);
        Thread.sleep(4000);

        //payment method
        WebElement paymentMethod= driver.findElement(By.id("payment-option-1"));
        clickButton(js, paymentMethod);
        WebElement generalConditionToApprove = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        clickButton(js,generalConditionToApprove);
        Thread.sleep(4000);

        //confirm command
        WebElement submitFormButton= driver.findElement(By.cssSelector("#payment-confirmation button"));
        clickButton(js,submitFormButton);
        js.executeScript("alert('Test achieved !')");
    }

    @After
    public void quitDriver() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }

    private static void clickButton(JavascriptExecutor js, WebElement button) {
        js.executeScript("arguments[0].click()", button);
    }
}
