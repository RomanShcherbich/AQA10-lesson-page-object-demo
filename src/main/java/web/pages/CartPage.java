package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public static final String BASE_URL = "https://www.saucedemo.com/cart.html";

    private static final By TITLE_LOCATOR = By.xpath("//span[@class='title' and text()='Your Cart']");

    public CartPage(WebDriver driver) {
        super(driver, BASE_URL, TITLE_LOCATOR);
    }

}
