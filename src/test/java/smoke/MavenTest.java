package smoke;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import io.qameta.allure.TmsLinks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MavenTest {

    @Test(description = "Тестирование параметров, которые передаются через мавен")
    @Description("Какое-то описание из аннотации @Description")
    @Issue(value = "SHAR-16")
    @TmsLinks({
        @TmsLink(value = "SHAR-1"),
        @TmsLink(value = "SHAR-2"),
    })
    public void mavenPropTest() {
        System.out.printf("testProp2 = %s\n",System.getenv("testProp2"));
        Assert.assertEquals(System.getProperty("testProp"), "MAVEN_TEST");
    }

}
