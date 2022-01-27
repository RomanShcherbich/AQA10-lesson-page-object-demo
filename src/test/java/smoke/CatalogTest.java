package smoke;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseAuthenticatedTest;

import static smoke.ProductTest.TEST_PRODUCT_TITLE;

public class CatalogTest extends BaseAuthenticatedTest {

    @Test
    public void menuIsOpenedTest(){
        validLogin();
        Assert.assertTrue(catalogPage.openMenu(), "Menu cross button is not displayed");
    }

    @Test
    public void badgeIsDisplayedTest() throws InterruptedException {
        validLogin();
        catalogPage.addProductToCart(TEST_PRODUCT_TITLE);
        Assert.assertTrue(catalogPage.isBadgeDisplayed(4), "Badge is not displayed");
    }

    @Test
    public void addProductTest() {
        loginPage.openWithValidation();
        loginPage.login(USERNAME, PASSWORD);
        catalogPage.addProductToCart(TEST_PRODUCT_TITLE);
        catalogPage.addProductToCart("Test");
        catalogPage.addProductToCart("Fleece");
        cartPage.open();
        cartPage.isPageLoaded();
    }

    @Test
    public void addProductTest2() {
        loginPage
                .open()
                .isPageLoaded()
                .validLogin(USERNAME, PASSWORD)
                .addProductToCart(TEST_PRODUCT_TITLE)
                .addProductToCart("Test")
                .addProductToCart("Fleece");
        Assert.assertNotNull(
            cartPage
                    .open()
                    .isPageLoaded(),
                "Products not valid in cart"
        );

    }

}
