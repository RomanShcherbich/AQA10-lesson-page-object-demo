package utils;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.util.concurrent.TimeUnit;

public class TestListener implements ITestListener {


    public void onTestFailure(ITestResult iTestResult) {
        String infoSeparator = "==================================";
        System.out.println(String.format(
                "%sFAILED TEST %s Duration: %ss %s",
                infoSeparator,
                iTestResult.getName(),
                getExecutionTime(iTestResult),
                infoSeparator
        ));
        AllureUtils.attachScreenshot(takeScreenshot(iTestResult));
//        Allure.addAttachment(iTestResult.getName(), new ByteArrayInputStream(takeScreenshot(iTestResult)));
    }

    private long getExecutionTime(ITestResult iTestResult) {
        return TimeUnit.MILLISECONDS.toSeconds(iTestResult.getEndMillis() - iTestResult.getStartMillis());
    }

    private byte[] takeScreenshot(ITestResult iTestResult) {
        ITestContext context = iTestResult.getTestContext();
        try {
            WebDriver driver = (WebDriver) context.getAttribute("driver");
            if (driver != null) {
                System.out.println("taking screenshot");
                return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            } else {
                return new byte[]{};
            }
        } catch (NoSuchSessionException | IllegalStateException ex) {
            return new byte[]{};
        }
    }

}