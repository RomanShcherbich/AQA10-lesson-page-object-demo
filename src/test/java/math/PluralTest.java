package math;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PluralTest {

    @DataProvider()
    public Object[][] calculatorDP() {
        return new Object[][]{
                {2.0, 4.0, 8, "message 2.0, 4.0, 8"},
                {3.0, 4.0, 12, "message 3.0, 4.0, 12"},
                {4.0, 5.0, 20.0, "message 2.0, 4.0, 8"},
                {2.5, 4.0, 10.0, "message 2.0, 4.0, 8"},
                {2.9, 4.0, 11.6, "message 2.0, 4.0, 8"},
                {3.1, 5.1, 15.809999999999999, "message 2.0, 4.0, 8"},
                {3.1, 5.1, 15.809999999999999, "message 2.0, 4.0, 8"},
                {3.1, 5.1, 15.809999999999999, "message 2.0, 4.0, 8"},
                {3.1, 5.1, 15.809999999999999, "message 2.0, 4.0, 8"},
                {3.1, 5.1, 15.809999999999999, "message 2.0, 4.0, 8"},
                {3.1, 5.1, 15.809999999999999, "message 2.0, 4.0, 8"},
                {3.1, 5.1, 15.809999999999999, "message 2.0, 4.0, 8"},
                {3.1, 5.1, 15.809999999999999, "message 2.0, 4.0, 8"},
        };
    }

    @Test(dataProvider = "calculatorDP")
    public void pluralTest1(double a, double b, double actualResult , String message) throws InterruptedException {
        Thread.sleep(500);
        double result = Calculator.plural(a, b);
        Assert.assertEquals(result, actualResult, message);
    }

}
