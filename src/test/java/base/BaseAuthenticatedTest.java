package base;

import org.testng.Assert;

public class BaseAuthenticatedTest extends BaseTest{

    public void openLoginPage() {
        loginPage.open();
        Assert.assertNotNull(loginPage.isPageLoaded(), "Login page is not loaded");
    }

    public void validLogin() {
        openLoginPage();
        loginPage.login(USERNAME, PASSWORD);
        Assert.assertNotNull(catalogPage.isPageLoaded(), "Catalog page is not loaded");
    }

}
