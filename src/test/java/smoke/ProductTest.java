package smoke;

import base.BaseAuthenticatedTest;
import matcher.ProductMatchers;
import model.Product;
import org.testng.annotations.Test;

import java.util.List;

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

    @Test
    public void sortedProductsTest(){
        validLogin();
        List<Product> savedProducts = catalogPage.getProductList();
        catalogPage.sortProductsByNameDesc();
        ProductMatchers.validateSortedProducts(catalogPage.getProductList(), savedProducts);
    }

}
