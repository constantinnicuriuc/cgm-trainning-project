package selenium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import selenium.pages.AccountPage;
import selenium.pages.LoanPage;
import selenium.pages.LoginPage;
import selenium.utils.Credentials;
import selenium.utils.LoanStatus;

import java.util.stream.Stream;

public class RequestLoanTest extends BaseTest {

    private static Stream<Arguments> testArguments() {
        LoanApplication firstLoanApplication = new LoanApplication("10000", "1000", "13344");
        LoanApplication secondLoanApplication = new LoanApplication("10000", "5000", "13344");
        LoanApplication thirdLoanApplication = new LoanApplication("300", "50", "54321");

        return Stream.of(
                Arguments.of("Loan Denied", firstLoanApplication, LoanStatus.DENIED.getStatus()),
                Arguments.of("Loan Denied", secondLoanApplication, LoanStatus.DENIED.getStatus()),
                Arguments.of("Loan Approved", thirdLoanApplication, LoanStatus.APPROVED.getStatus())
        );
    }

    @ParameterizedTest(name = "{index} => Test type: ''{0}''")
    @MethodSource("testArguments")
    public void requestLoan(@SuppressWarnings("unused") String testType, LoanApplication loanApplication, String status) {
        // Test setup
        LoginPage loginPage = new LoginPage(driver);
        AccountPage accountPage = new AccountPage(driver);
        LoanPage loanPage = new LoanPage(driver);

        // Navigate to application
        loginPage.navigateToLoginPage();

        // Log in
        loginPage.fillInCredentials(Credentials.PARABANK.getUsername(), Credentials.PARABANK.getPassword());
        loginPage.clickLogin();

        // Go to Request Loan page
        accountPage.accessRequestLoan();

        // Fill in loan application form
        loanPage.fillInPayment(
                loanApplication.getAmount(),
                loanApplication.getDownPayment(),
                loanApplication.getAccountNumber());
        loanPage.applyLoan();

        Assertions.assertEquals(status, loanPage.getLoanStatus());
    }
}
