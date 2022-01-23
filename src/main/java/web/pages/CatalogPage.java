package web.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class CatalogPage extends BasePage {

    public static final String BASE_URL = "https://www.saucedemo.com/inventory.html";

    private static final By TITLE_LOCATOR = By.xpath("//span[@class='title' and text()='Products']");
    private static final String PRODUCT_XPATH_PATTERN =
            "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//button";

    private static final By BURGER_MENU_BUTTON = By.id("react-burger-menu-btn");
    private static final By BURGER_MENU_CLOSE_BUTTON = By.id("react-burger-cross-btn");
    private static final By SHOPPING_CART_BADGE = By.className("shopping_cart_badge");


    public CatalogPage(WebDriver driver) {
        super(driver);
        this.baseUrl = BASE_URL;
        this.basePageElementId = TITLE_LOCATOR;
    }

    public void addProductToCart(String partialProductTitle) {
        driver.findElement(By.xpath(String.format(PRODUCT_XPATH_PATTERN, partialProductTitle))).click();
    }

    public boolean openMenu(){
        driver.findElement(BURGER_MENU_BUTTON).click();
        Wait<WebDriver> fluent = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(ElementNotInteractableException.class);
        WebElement crossButton = fluent.until(driver -> {
            System.out.println(" FLUENT WAIT ");
            driver.findElement(BURGER_MENU_CLOSE_BUTTON).sendKeys("");
            return driver.findElement(BURGER_MENU_CLOSE_BUTTON);
        });

        return crossButton.isDisplayed();
    }

    public boolean isBadgeDisplayed(int durationOfSeconds) throws InterruptedException {
        for (int i = 0; i < durationOfSeconds; i++) {
            try {
                driver.findElement(SHOPPING_CART_BADGE);
                return true;
            } catch (NoSuchElementException ex) {
                Thread.sleep(1000);
                System.out.printf("%s seconds left\n", durationOfSeconds - i);
            }
        }
        return false;
    }

}
