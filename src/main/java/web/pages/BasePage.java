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

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

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

    public String getPlaceholder(By by) {
        return driver.findElement(by).getAttribute("placeholder");
    }

    public String getPlaceholder(WebElement element) {
        return element.getAttribute("placeholder");
    }

    public String getText(By by) {
        String elementText = driver.findElement(by).getText();
        if (elementText == null || elementText.isEmpty()) {
            elementText = driver.findElement(by).getAttribute("value");
        }
        return elementText;
    }

}
