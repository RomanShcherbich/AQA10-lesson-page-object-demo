package saucedemotest;

import org.testng.annotations.Test;

public class ProductTest extends LoginTest {

    public static final String TEST_PRODUCT_TITLE = "Test.allTheThings() T-Shirt (Red)";

    @Test
    public void addProductToCartTest() {
        //add test product to cart
        catalogPage.addProductToCart(TEST_PRODUCT_TITLE);
        cartPage.open();
        cartPage.isPageLoaded();
        //validate product added
    }

}
