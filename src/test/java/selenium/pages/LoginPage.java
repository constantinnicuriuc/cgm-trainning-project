package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By usernameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By loginButton = By.xpath("//input[@value='Log In']");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void navigateToLoginPage() {
        this.driver.get("https://parabank.parasoft.com");
    }

    public void fillInCredentials(String username, String password) {
        sendKeys(usernameField, username);
        sendKeys(passwordField, password);
    }

    public void clickLogin() {
        clickOnElement(loginButton);
    }
}
