package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class InputFormPage extends BasePage {

	  private By txtName = By.id("name");
	    private By txtEmail = By.id("inputEmail4");       
	    private By txtPassword = By.id("inputPassword4"); 
	    private By txtCompany = By.id("company");
	    private By txtWebsite = By.id("websitename");
	    private By ddlCountry = By.name("country");
	    private By txtCity = By.id("inputCity");          
	    private By txtAddress1 = By.id("inputAddress1");   
	    private By txtAddress2 = By.id("inputAddress2");   
	    private By txtState = By.id("inputState");         
	    private By txtZip = By.id("inputZip");             
	    private By btnSubmit = By.cssSelector("button.selenium_btn");  
	    private By successMessage = By.className("success-msg");

    public InputFormPage(WebDriver driver) {
        super(driver);
    }

    public void clickSubmit() {
        click(btnSubmit);
    }

    public String getValidationMessage() {
        return find(txtName).getDomProperty("validationMessage");
    }

    public void fillForm() {

        type(txtName, "John Doe");
        type(txtEmail, "john@test.com");
        type(txtPassword, "Password123");
        type(txtCompany, "ABC Pvt Ltd");
        type(txtWebsite, "https://abc.com");

        Select select = new Select(find(ddlCountry));
        select.selectByVisibleText("United States");

        type(txtCity, "New York");
        type(txtAddress1, "Street 1");
        type(txtAddress2, "Street 2");
        type(txtState, "NY");
        type(txtZip, "10001");
    }

    public String getSuccessMessage() {
        return getText(successMessage);
    }
}