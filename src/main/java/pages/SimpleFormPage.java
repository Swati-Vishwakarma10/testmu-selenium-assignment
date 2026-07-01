package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SimpleFormPage extends BasePage {

    private By txtMessage = By.id("user-message");
    private By btnGetCheckedValue = By.id("showInput");
    
    // FIX: Use the precise paragraph locator id that receives the inner text
    private By lblMessage = By.id("message");
    
    public SimpleFormPage(WebDriver driver) {
        super(driver);
    }

    public void enterMessage(String message) {
        type(txtMessage, message);
    }

    public void clickGetCheckedValue() {
        click(btnGetCheckedValue);
    }

    public String getDisplayedMessage() {
        // .trim() removes any leading or trailing whitespace injected by the DOM
        return getText(lblMessage).trim();
    }
    
    
}