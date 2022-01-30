package base;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class BaseAuthenticatedTest extends BaseTest{

    public void openLoginPage() {
        loginPage.open();
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded");
    }

    public void validLogin() {
        openLoginPage();
        loginPage.login(USERNAME, PASSWORD);
        Assert.assertTrue(catalogPage.isPageLoaded(), "Catalog page is not loaded");
    }

    public void asserts() {
        softAssert.assertAll();
    }

}
