package steps;

import org.testng.asserts.SoftAssert;
import web.pages.CartPage;
import web.pages.CatalogPage;
import web.pages.LoginPage;

public class BaseStep {

    protected LoginPage loginPage;
    protected CatalogPage catalogPage;
    protected CartPage cartPage;
    protected SoftAssert softAssert;

    public BaseStep(LoginPage loginPage, CatalogPage catalogPage, CartPage cartPage) {
        this.loginPage = loginPage;
        this.catalogPage = catalogPage;
        this.cartPage = cartPage;
    }

    public void setSoftAssert(SoftAssert softAssert) {
        this.softAssert = softAssert;
    }
}
