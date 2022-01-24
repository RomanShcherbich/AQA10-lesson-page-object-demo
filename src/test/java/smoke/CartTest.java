package smoke;

import base.BaseAuthenticatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseAuthenticatedTest {

    @Test
    public void menuIsOpenedTest(){
        validLogin();
        cartPage.open();
        Assert.assertTrue(cartPage.isPageLoaded(), "Cart page is not loaded");
        Assert.assertTrue(cartPage.burgerMenu.open(), "Menu cross button is not displayed");
    }

}
