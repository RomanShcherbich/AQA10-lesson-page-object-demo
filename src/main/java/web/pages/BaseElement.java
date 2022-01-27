package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseElement {

    protected WebDriver driver;
    protected WebDriverWait explicitWait;

    public BaseElement(WebDriver driver) {
        this.driver = driver;
        this.explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public abstract BasePage isPageLoaded();

}
