package web.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage extends BaseElement {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public abstract BasePage open();
/*
    public BasePage open() {
        driver.get(baseUrl);
        return this;
    }



    public boolean isPageLoaded() {
        try {
            explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(basePageElementId));
        } catch (TimeoutException timeoutException) {
            return false;
        }
        return true;
    }



    public boolean validateProductInCart() {
        return true;
    }
 */
}
