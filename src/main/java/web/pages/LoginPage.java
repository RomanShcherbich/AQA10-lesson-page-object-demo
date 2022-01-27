package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public static final String BASE_URL = "https://www.saucedemo.com/";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final By USERNAME_TEXT_FIELD = By.id("user-name");
    private static final By PASSWORD_TEXT_FIELD = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");

    public static final String USERNAME_TEXT_FIELD_PLACEHOLDER = "Username";

    public LoginPage login(String username, String password) {
        driver.findElement(USERNAME_TEXT_FIELD).sendKeys(username);
        driver.findElement(PASSWORD_TEXT_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    public CatalogPage validLogin(String validUsername, String validPassword) {
        login(validUsername, validPassword);
        return new CatalogPage(driver);
    }


    public String getUsernamePlaceholder() {
        return driver.findElement(USERNAME_TEXT_FIELD).getAttribute("placeholder");
    }

    public LoginPage openWithValidation() {
        open();
        isPageLoaded();
        return this;
    }

    @Override
    public LoginPage isPageLoaded() {
        try {
            explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(LOGIN_BUTTON));
        } catch (TimeoutException timeoutException) {
            return null;
        }
        return this;
    }

    @Override
    public LoginPage open() {
        driver.get(BASE_URL);
        return this;
    }

}
