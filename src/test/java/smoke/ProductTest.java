package smoke;

import base.BaseAuthenticatedTest;
import org.testng.annotations.Test;

public class ProductTest extends BaseAuthenticatedTest {

    public static final String TEST_PRODUCT_TITLE = "Test.allTheThings() T-Shirt (Red)";

    @Test
    public void addProductToCartTest() {
        validLogin();
        //add test product to cart
        catalogPage.addProductToCart(TEST_PRODUCT_TITLE);
        cartPage.open();
        cartPage.isPageLoaded();
        //validate product added
    }

}
