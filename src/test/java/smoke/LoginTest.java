package smoke;

import base.BaseAuthenticatedTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.RetryAnalyzer;
import web.pages.LoginPage;

public class LoginTest extends BaseAuthenticatedTest {

    @Test
//    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void validCredentialsLoginTest() {

        System.out.println("validCredentialsLoginTest");
        validLogin();
    }

    @Test(testName = "NOT")
    public void USERNAME_PLACEHOLDER_TEST() {
        System.out.println("USERNAME_PLACEHOLDER_TEST");
        openLoginPage();
        Assert.assertEquals(
                loginPage.getUsernamePlaceholder(),
                LoginPage.USERNAME_TEXT_FIELD_PLACEHOLDER,
                "Username placeholder is not valid"
        );
    }

}
