package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoanPage extends BasePage {
    private final By amountLocator = By.id("amount");
    private final By downPaymentLocator = By.id("downPayment");
    private final By dropDownLocator = By.id("fromAccountId");
    private final By applyLoanLocator = By.xpath("//input[@value='Apply Now']");
    private final By loanStatusLocator = By.id("loanStatus");

    private WebDriver driver;

    public LoanPage(WebDriver driver) {
        super(driver);
    }

    public void fillInPayment(String amount, String downPayment, String accountNumber) {
        sendKeys(amountLocator, amount);
        sendKeys(downPaymentLocator, downPayment);
        selectDropDownElement(dropDownLocator, accountNumber);
    }

    public void applyLoan() {
        clickOnElement(applyLoanLocator);
    }

    public String getLoanStatus() {
        return getText(loanStatusLocator);
    }

}
