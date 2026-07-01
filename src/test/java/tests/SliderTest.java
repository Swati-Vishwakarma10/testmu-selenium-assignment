package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DragDropSliderPage;
import pages.HomePage;

public class SliderTest extends BaseTest {

    @Test
    public void verifySlider() {
        // FIX: Use getDriver()
        HomePage home = new HomePage(getDriver());

        home.openApplication();
        home.clickDragDropSliders();

        // FIX: Use getDriver()
        DragDropSliderPage sliderPage = new DragDropSliderPage(getDriver());

        sliderPage.moveSliderTo95();

        Assert.assertEquals(sliderPage.getSliderValue(), "95");
    }
}