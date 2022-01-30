package steps;

import org.testng.Assert;
import web.pages.CartPage;
import web.pages.CatalogPage;
import web.pages.LoginPage;

public class LoginSteps extends BaseStep {


     public LoginSteps(LoginPage loginPage, CatalogPage catalogPage, CartPage cartPage) {
          super(loginPage, catalogPage, null);
     }

     public LoginSteps openSauceDemo() {
          loginPage.open();
          Assert.assertTrue(loginPage.isPageLoaded(), "Some page is not loaded");
          return this;
     }

     public LoginSteps insertUsername(String username) {
          loginPage.insertUserName(username);
          //assertEquals(username, actualInputValue)
          return this;
     }

     public LoginSteps insertPassword(String password) {
          loginPage.insertUserName(password);
          //assertEquals(username, actualInputValue)
          return this;
     }

     public LoginSteps checkTextOfElement() {
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
          return this;
     }

     public LoginSteps validLogin(String validUsername, String validPassword) {
          loginPage.login(validUsername, validPassword);
          Assert.assertTrue(catalogPage.isPageLoaded(), "Some page is not loaded");
          return this;
     }

}
