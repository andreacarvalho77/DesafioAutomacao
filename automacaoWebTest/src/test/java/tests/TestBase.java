package tests;

import base.BaseTest;
import org.testng.annotations.Test;
public class TestBase extends BaseTest {
    @Test
    public void testHomePageTitle() {
        String expectedTitle = "";
        String actualTitle = driver.getTitle();

        assert actualTitle.contains(expectedTitle) : "";
    }
}
