package model;

public class ChequeAccount extends Account {
    private String employer;
    private String employerAddress;

    public ChequeAccount(Customer owner, String branch, String employer, String employerAddress) {
        super(owner, branch);
        if (employer == null || employer.isEmpty()) {
            throw new IllegalArgumentException("Cheque account is only for working people");
        }
        this.employer = employer;
        this.employerAddress = employerAddress;
    }

    @Override
    public void withdraw(double amount) {
        removeFunds(amount);
    }

    public String getEmployer() { return employer; }
    public String getEmployerAddress() { return employerAddress; }

    public String getAccountType() { return "Cheque"; }
}
