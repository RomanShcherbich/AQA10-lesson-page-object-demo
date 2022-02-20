package smoke;

import base.BaseAuthenticatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static smoke.ProductTest.TEST_PRODUCT_TITLE;

public class CatalogTest extends BaseAuthenticatedTest {

    @Test(groups = {"smoke"})
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

}
