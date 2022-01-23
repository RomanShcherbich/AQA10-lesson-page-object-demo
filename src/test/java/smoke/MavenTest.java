package smoke;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MavenTest {

    @Test
    public void mavenPropTest() {
        System.out.printf("testProp2 = %s\n",System.getenv("testProp2"));
        Assert.assertEquals(System.getProperty("testProp"), "MAVEN_TEST");
    }

}
