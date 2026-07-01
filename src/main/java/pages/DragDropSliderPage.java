package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DragDropSliderPage extends BasePage {

    private By slider = By.xpath("(//input[@type='range'])[3]");
    private By sliderValue = By.id("rangeSuccess");

    public DragDropSliderPage(WebDriver driver) {
        super(driver);
    }

    public void moveSliderTo95() {
        WebElement element = find(slider);
        
        // Use keyboard events for reliable slider movement across remote clouds
        while (!getSliderValue().equals("95")) {
            element.sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public String getSliderValue() {
        return getText(sliderValue);
    }
}