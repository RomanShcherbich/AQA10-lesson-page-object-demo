package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement usernamePassword;

    @FindBy(id = "login-button")
    WebElement button;

//    @FindBy(css = "[data-test=error]")
//    WebElement errorMessage;

    /*** @FindBys : When the required WebElement objects need to match all of the given criteria use @FindBys annotation
    * @FindAll : When required WebElement objects need to match at least one of the given criteria use @FindAll
    *  annotation
    *  Usage:
    *      @FindBys( {
    *         @FindBy(className = "class1")
    *         @FindBy(className = "class2")
    *      } )
    *      private List<WebElement> elementsWithBoth_class1ANDclass2;
    *
    *      @FindAll({
    *         @FindBy(className = "class1")
    *         @FindBy(className = "class2")
    *      })
    *      private List<WebElement> elementsWithEither_class1ORclass2
     */

    public static final String BASE_URL = "https://www.saucedemo.com/";
    private static final By LOGIN_BUTTON = By.id("login-button");
    public static final String USERNAME_TEXT_FIELD_PLACEHOLDER = "Username";

    public LoginPage(WebDriver driver) {
        super(driver, BASE_URL, LOGIN_BUTTON);
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        usernamePassword.sendKeys(password);
        button.click();
    }

    public String getElementPlaceholder(WebElement element) {
        return element.getAttribute("placeholder");
    }

    public String getUsernamePlaceholder() {
        return getElementPlaceholder(usernameInput);
    }

}
