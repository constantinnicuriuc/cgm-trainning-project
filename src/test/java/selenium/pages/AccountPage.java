package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {
    private final By requestLoan = By.linkText("Request Loan");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void accessRequestLoan() {
        clickOnElement(requestLoan);
    }
}
