package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import web.base.BasePage;
import web.elements.BurgerMenuElement;

public class CartPage extends BasePage {

    public static final String BASE_URL = "https://www.saucedemo.com/cart.html";

    private static final By TITLE_LOCATOR = By.xpath("//span[@class='title' and text()='Your Cart']");

    public BurgerMenuElement burgerMenu;

    public CartPage(WebDriver driver) {
        super(driver);
        this.burgerMenu = new BurgerMenuElement(driver);
        this.baseUrl=BASE_URL;
        this.baseElementLocator = TITLE_LOCATOR;
    }

}
