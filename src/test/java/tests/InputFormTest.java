package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.InputFormPage;

public class InputFormTest extends BaseTest {

    @Test
    public void verifyInputForm() {
        // FIX: Use getDriver()
        HomePage home = new HomePage(getDriver());

        home.openApplication();
        home.clickInputFormSubmit();

        // FIX: Use getDriver()
        InputFormPage page = new InputFormPage(getDriver());

       
        page.fillForm();
        page.clickSubmit();

        Assert.assertEquals(
                page.getSuccessMessage(),
                "Thanks for contacting us, we will get back to you shortly.");
    }
}