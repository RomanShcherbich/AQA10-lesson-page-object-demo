package web.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait explicitWait;
    protected String baseUrl;
    protected By basePageElementId;

    public BasePage(WebDriver driver, String baseUrl, By basePageElementId) {
        this.driver = driver;
        this.explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.baseUrl = baseUrl;
        this.basePageElementId = basePageElementId;
    }

    public void open() {
        driver.get(baseUrl);
    }

    public boolean isPageLoaded() {
        try {
            explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(basePageElementId));
        } catch (TimeoutException timeoutException) {
            return false;
        }
        return true;
    }

}
