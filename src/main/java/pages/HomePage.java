package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By simpleFormDemo = By.linkText("Simple Form Demo");
    private By dragDropSliders = By.linkText("Drag & Drop Sliders");
    private By inputFormSubmit = By.linkText("Input Form Submit");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openApplication() {
        System.out.println("About to navigate...");
        driver.get("https://www.testmuai.com/selenium-playground/");
        System.out.println("Navigated. Current URL: " + driver.getCurrentUrl());
    }

    public void clickSimpleFormDemo() {
        click(simpleFormDemo);
    }

    public void clickDragDropSliders() {
        click(dragDropSliders);
    }

    public void clickInputFormSubmit() {
        System.out.println("Clicking Input Form Submit link...");
        click(inputFormSubmit);
        System.out.println("Clicked. URL now: " + driver.getCurrentUrl());
    }
}