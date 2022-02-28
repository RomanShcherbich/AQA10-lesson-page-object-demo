package web.pages;

import model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CatalogPage extends BasePage {

    public static final String BASE_URL = "https://www.saucedemo.com/inventory.html";

    private static final By TITLE_LOCATOR = By.xpath("//span[@class='title' and text()='Products']");
    private static final String PRODUCT_XPATH_PATTERN =
            "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//button";

    private static final By BURGER_MENU_BUTTON = By.id("react-burger-menu-btn");
    private static final By BURGER_MENU_CLOSE_BUTTON = By.id("react-burger-cross-btn");
    private static final By SHOPPING_CART_BADGE = By.className("shopping_cart_badge");
    private static final By PRODUCTS_LIST_CONTAINER = By.cssSelector("#inventory_container .inventory_item");
    private static final By PRODUCT_TITLE = By.className("inventory_item_name");
    private static final By PRODUCT_PRICE = By.className("inventory_item_price");
    private static final By PRODUCT_DESC = By.className("inventory_item_desc");
    private static final By ORDER_SELECT = By.className("product_sort_container");

    Logger log = LogManager.getLogger(CatalogPage.class);


    public CatalogPage(WebDriver driver) {
        super(driver);
        this.baseUrl = BASE_URL;
        this.basePageElementId = TITLE_LOCATOR;
    }

    public void addProductToCart(String partialProductTitle) {
        driver.findElement(By.xpath(String.format(PRODUCT_XPATH_PATTERN, partialProductTitle))).click();
    }

    public boolean openMenu(){
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

        return crossButton.isDisplayed();
    }

    public boolean isBadgeDisplayed(int durationOfSeconds) throws InterruptedException {
        for (int i = 0; i < durationOfSeconds; i++) {
            try {
                driver.findElement(SHOPPING_CART_BADGE);
                return true;
            } catch (NoSuchElementException ex) {
                Thread.sleep(1000);
                System.out.printf("%s seconds left\n", durationOfSeconds - i);
            }
        }
        return false;
    }

    public List<Product> getProductList() {
        log.info("Read all products in catalog");
        List<Product> products = new ArrayList<>();
        for (WebElement productElement : driver.findElements(PRODUCTS_LIST_CONTAINER)) {
            String title = productElement.findElement(PRODUCT_TITLE).getText();
            double price = Double.parseDouble(productElement.findElement(PRODUCT_PRICE).getText().split("\\$")[1]); // $\n7.99
            String desc = productElement.findElement(PRODUCT_DESC).getText();
//            Product newProd = new Product(title, price, desc, null);
            Product newProd = Product.builder()
                                    .title(title)
                                    .price(price)
                                    .description(desc)
                                    .build();
            products.add(newProd);
        }
        return products;
    }

    public void sortProductsByNameDesc() {
        log.info("Sort catalog products by Name from Z to A");
        Select orderList = new Select(driver.findElement(ORDER_SELECT));
        List<WebElement> options = orderList.getOptions();
        for (WebElement option : options) {
            if (option.getText().contains("Z to A")) {
                orderList.selectByVisibleText(option.getText());
                return;
            }
        }
    }

}
