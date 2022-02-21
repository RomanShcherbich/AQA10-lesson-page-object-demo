package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.CapabilitiesGenerator;
import utils.PropertiesUtils;
import utils.TestListener;
import web.pages.CartPage;
import web.pages.LoginPage;
import web.pages.CatalogPage;
import java.io.File;
import java.time.Duration;
import java.util.HashMap;

@Listeners({TestListener.class})
public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected CatalogPage catalogPage;
    protected CartPage cartPage;

    public static String USERNAME = PropertiesUtils.getEnv("valid_login");
    public static String PASSWORD = PropertiesUtils.getEnv("valid_password");


    @BeforeMethod(groups = {"config"})
    public void setup(ITestContext iTestContext){
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        setContextAttribute(iTestContext, "driver", driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        loginPage = new LoginPage(driver);
        catalogPage = new CatalogPage(driver);
        cartPage = new CartPage(driver);
    }

    private void setContextAttribute(ITestContext iTestContext, String attributeKey, Object attributeValue) {
        iTestContext.setAttribute(attributeKey, attributeValue);
    }

    @AfterMethod(alwaysRun=true, groups = {"config"})
    public void teardown() {
        driver.close();
        driver.quit();
    }

}
