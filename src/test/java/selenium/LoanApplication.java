package selenium;

public class LoanApplication {
    private final String amount;
    private final String downPayment;
    private final String accountNumber;

    public LoanApplication(String amount, String downPayment, String accountNumber) {
        this.amount = amount;
        this.downPayment = downPayment;
        this.accountNumber = accountNumber;
    }

    public String getAmount() {
        return amount;
    }

    public String getDownPayment() {
        return downPayment;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
