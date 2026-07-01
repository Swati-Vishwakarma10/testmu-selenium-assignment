package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SimpleFormPage;

public class SimpleFormTest extends BaseTest {

    @Test
    public void verifySimpleForm() {
        // FIX: Use getDriver()
        HomePage home = new HomePage(getDriver()); 
        home.openApplication();
        home.clickSimpleFormDemo();

        // FIX: Use getDriver()
        SimpleFormPage page = new SimpleFormPage(getDriver());

        Assert.assertTrue(page.getCurrentUrl().contains("simple-form-demo"));

        String message = "Welcome to TestMu AI";
        page.enterMessage(message);
        page.clickGetCheckedValue();

        Assert.assertEquals(page.getDisplayedMessage(), message);
    }
}