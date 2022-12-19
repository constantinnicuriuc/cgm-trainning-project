package selenium.utils;

public enum LoanStatus {
    DENIED("Denied"),
    APPROVED("Approved");

    private final String status;

    LoanStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
