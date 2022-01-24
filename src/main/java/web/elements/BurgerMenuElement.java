package web.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import web.base.AbstractElement;

import java.time.Duration;

public class BurgerMenuElement extends AbstractElement {

    private static final By BURGER_MENU_BUTTON = By.id("react-burger-menu-btn");
    private static final By BURGER_MENU_CLOSE_BUTTON = By.id("react-burger-cross-btn");

    public BurgerMenuElement(WebDriver driver) {
        super(driver);
        super.baseElementLocator = BURGER_MENU_BUTTON;
    }

    public boolean open() {
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
        return driver.findElement(BURGER_MENU_CLOSE_BUTTON).isDisplayed();
    }

}
