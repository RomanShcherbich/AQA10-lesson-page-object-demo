package smoke;

import base.BaseAuthenticatedTest;
import io.qameta.allure.Flaky;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

import static smoke.ProductTest.TEST_PRODUCT_TITLE;

public class CatalogTest extends BaseAuthenticatedTest {

    @Test(groups = {"smoke"})
    @TmsLink("CALC-2")
    @Issue("CALC-3")
//    @Flaky
    public void menuIsOpenedTest(){
        validLogin();
        Assert.assertEquals(new Random().nextInt(1), 1, "Flacky fail");
        Assert.assertTrue(catalogPage.openMenu(), "Menu cross button is not displayed");
    }

    @Test
    public void badgeIsDisplayedTest() throws InterruptedException {
        validLogin();
        catalogPage.addProductToCart(TEST_PRODUCT_TITLE);
        Assert.assertTrue(catalogPage.isBadgeDisplayed(4), "Badge is not displayed");
    }

}
