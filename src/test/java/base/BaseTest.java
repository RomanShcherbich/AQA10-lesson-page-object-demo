package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.TestListener;
import web.pages.CartPage;
import web.pages.LoginPage;
import web.pages.CatalogPage;
import java.io.File;
import java.time.Duration;
import java.util.HashMap;

@Listeners(TestListener.class)
//@Listeners({TestListener.class, utils.Retry.class})
public class BaseTest {

    public WebDriver driver;
    protected LoginPage loginPage;
    protected CatalogPage catalogPage;
    protected CartPage cartPage;

    public static String USERNAME;
    public static String PASSWORD;


    public static final File RESOURCE_PATH_FILE = new File("src/test/resources");
    public static final String ABSOLUTE_RESOURCE_PATH = RESOURCE_PATH_FILE.getAbsolutePath();


//    @Parameters ( {"username", "password"} )
//    @BeforeSuite(groups = {"config"})
//    public void addParams(String username, String password) {
//        USERNAME = username;
//        PASSWORD = password;
//    }

    public void initParams() {
        USERNAME = System.getProperty("username");
        PASSWORD = System.getProperty("password");
    }

    @BeforeMethod(groups = {"config"})
    public void setup(ITestContext context){
        initParams();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--ignore-popup-blocking");
        chromeOptions.addArguments("--ignore-certificate-errors");

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", ABSOLUTE_RESOURCE_PATH);
        chromeOptions.setExperimentalOption("prefs", chromePrefs);

        driver = new ChromeDriver(chromeOptions);
        setDriverAttribute(context);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        loginPage = new LoginPage(driver);
        catalogPage = new CatalogPage(driver);
        cartPage = new CartPage(driver);
    }

    private void setDriverAttribute(ITestContext context) {
        String variable = "driver";
        System.out.println("Setting driver into context with variable name " + variable);
        context.setAttribute(variable, driver);
    }

    @AfterClass(alwaysRun=true, groups = {"config"})
    public void teardown() {
        driver.close();
        driver.quit();
        System.out.println("driver closed");
    }

}
