package smoke;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseAuthenticatedTest;
import web.pages.LoginPage;

public class LoginTest extends BaseAuthenticatedTest {

    @Test()
    public void T02_validCredentialsLoginTest() {
        validLogin();
    }

    @Test()
    public void T03_USERNAME_PLACEHOLDER_TEST() {
        openLoginPage();
        Assert.assertEquals(
                loginPage.getUsernamePlaceholder(),
                LoginPage.USERNAME_TEXT_FIELD_PLACEHOLDER,
                "Username placeholder is not valid"
        );
    }

    @Test()
    public void T04_validCredentialsLoginStepTest() {
        loginSteps
                .openSauceDemo()
                .checkTextOfElement()
                .validLogin(USERNAME, PASSWORD);
        softAssert.assertAll();
    }

    @Test()
    public void T01_validCredentialsLoginNoStepTest() {
        loginPage.open();
        Assert.assertTrue(loginPage.isPageLoaded(), "Some page is not loaded");
        softAssert.assertEquals(
                loginPage.getUsernamePlaceholder(),
                "testing_data", "invalid placeholder"
        );
        softAssert.assertEquals(
                loginPage.getPasswordPlaceholder(), "testing_pass", "invalid placeholder"
        );
        softAssert.assertEquals(
                loginPage.getButtonText(), "login", "invalid button text"
        );
        loginPage.login(USERNAME, PASSWORD);
        softAssert.assertAll();
        Assert.assertTrue(catalogPage.isPageLoaded(), "Some page is not loaded");
    }

}
