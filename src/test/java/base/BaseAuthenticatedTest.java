package base;

import io.qameta.allure.Allure;
import io.qameta.allure.Link;
import io.qameta.allure.Step;
import org.testng.Assert;
import utils.JsonUtils;

import java.util.Map;

public class BaseAuthenticatedTest extends BaseTest {

    @Step("Открывается страница логина")
    public void openLoginPage() {
        loginPage.open();
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded");
    }

    @Step("Login with valid credentials {USERNAME}/{PASSWORD}")
    @Link("https://www.saucedemo.com/")
    public void validLogin() {
        openLoginPage();
        loginPage.login(USERNAME, PASSWORD);
//        String json = String.format("{\"username\": \"%s\", \"password\": \"%s\"}", USERNAME, PASSWORD);
        String json = JsonUtils.load(Map.of(
                "credentials", Map.of("username", USERNAME, "password", PASSWORD)
        ));
//        AllureUtils.attachJson(json.getBytes(StandardCharsets.UTF_8));
        Allure.addAttachment("Credentials from allure static", "text/json", json);
        Assert.assertTrue(catalogPage.isPageLoaded(), "Catalog page is not loaded");
    }

}
