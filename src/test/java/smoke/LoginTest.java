package smoke;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseAuthenticatedTest;
import web.pages.LoginPage;

public class LoginTest extends BaseAuthenticatedTest {

    @Test
    public void validCredentialsLoginTest() {
        Assert.assertNotNull(
                loginPage
                        .open()
                        .isPageLoaded()
                , "Login page is not loaded"
        );

        Assert.assertNotNull(
                loginPage
                        .validLogin(USERNAME, PASSWORD)
                        .isPageLoaded()
                , "Catalog page is not loaded."
        );
    }

    @Test
    public void validCredentialsLoginTest2() {
        Assert.assertNotNull(
                loginPage
                        .open()
                        .isPageLoaded()
                        .validLogin(USERNAME, PASSWORD)
                        .isPageLoaded()
                , "Catalog page is not loaded"
        );
    }


}
