package smoke;

import base.BaseAuthenticatedTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import web.pages.LoginPage;

import java.util.Random;

public class LoginTest extends BaseAuthenticatedTest {

    @Step("Second step {keyword}")
    public void productPageOpenedStep(String keyword) {
        if (new Random().nextInt(2) == 1) {
        }
            Assert.fail(" Искусственный провал теста");
    }

    @Step("Third step")
    public void accountCheck(){
        System.out.println(" accountCheck ");
    }

    @Test
//    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Parameters({"keyword"})
    @Flaky
    @Severity(SeverityLevel.BLOCKER)
    public void validCredentialsLoginTest(@Optional String keyword) {
        System.out.println("validCredentialsLoginTest");
        validLogin();
        productPageOpenedStep(keyword);
        accountCheck();
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
