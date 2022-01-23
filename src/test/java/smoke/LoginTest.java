package smoke;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseAuthenticatedTest;
import web.pages.LoginPage;

public class LoginTest extends BaseAuthenticatedTest {

    @Test
    public void validCredentialsLoginTest() {
        validLogin();
    }

    @Test
    public void USERNAME_PLACEHOLDER_TEST() {
        openLoginPage();
        Assert.assertEquals(
                loginPage.getUsernamePlaceholder(),
                LoginPage.USERNAME_TEXT_FIELD_PLACEHOLDER,
                "Username placeholder is not valid"
        );
    }

}
