package smoke;

import base.BaseAuthenticatedTest;
import lombok.SneakyThrows;
import matchers.ProductMatchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static smoke.ProductTest.TEST_PRODUCT_TITLE;

public class CatalogTest extends BaseAuthenticatedTest {

    @Test(groups = {"smoke"})
    public void menuIsOpenedTest(){
        validLogin();
        Assert.assertTrue(catalogPage.openMenu(), "Menu cross button is not displayed");
    }

    @SneakyThrows
    @Test
    public void badgeIsDisplayedTest() {
        validLogin();
        catalogPage.addProductToCart(TEST_PRODUCT_TITLE);
        Assert.assertTrue(catalogPage.isBadgeDisplayed(4), "Badge is not displayed");
    }

    @Test
    public void alphabetSortingTest() {
        validLogin();
        var savedBeforeSortProducts = catalogPage.getProductList();
        catalogPage.sortProductsByNameDesc();
        var actualSortedProducts = catalogPage.getProductList();
        ProductMatchers.validateListsSortingIsEqual(actualSortedProducts, savedBeforeSortProducts);
    }

}
