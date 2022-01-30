package smoke;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base.BaseAuthenticatedTest;

import static smoke.ProductTest.TEST_PRODUCT_TITLE;

public class CatalogTest extends BaseAuthenticatedTest {


    @Test(groups = { "smoke", "regression" , "slow" })
    public void menuIsOpenedTest(){
        validLogin();
        Assert.assertTrue(catalogPage.openMenu(), "Menu cross button is not displayed");
    }

    @Test(groups = "smoke")
    @Parameters({"title"})
    public void badgeIsDisplayedTest(@Optional("Test") String title) throws InterruptedException {
        validLogin();
        catalogPage.addProductToCart(title);
        Assert.assertTrue(catalogPage.isBadgeDisplayed(4), "Badge is not displayed");
    }

}
