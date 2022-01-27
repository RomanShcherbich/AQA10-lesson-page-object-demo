package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    public static final String BASE_URL = "https://www.saucedemo.com/cart.html";

    private static final By TITLE_LOCATOR = By.xpath("//span[@class='title' and text()='Your Cart']");

    public CartPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public BasePage isPageLoaded() {
        try {
            explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(TITLE_LOCATOR));
        } catch (TimeoutException timeoutException) {
            return null;
        }
        return this;
    }

    @Override
    public BasePage open() {
        driver.get(BASE_URL);
        return this;
    }

}
