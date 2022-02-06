package smoke;

import base.BaseAuthenticatedTest;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.pages.LoginPage;

public class LoginTest extends BaseAuthenticatedTest {

//    @Test(retryAnalyzer = Retry.class)
    @Test
    @TmsLink("CALC-2")
    @Issue("CALC-3")
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
