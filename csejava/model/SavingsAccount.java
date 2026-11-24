package model;

public class SavingsAccount extends Account implements InterestBearing {
    private static final double RATE = 0.0005; // 0.05% monthly

    public SavingsAccount(Customer owner, String branch) {
        super(owner, branch);
    }

    @Override
    public void withdraw(double amount) {
        throw new UnsupportedOperationException("Savings accounts do not allow withdrawals");
    }

    public double getInterestRate() { return RATE; }

    public void payInterest() {
        addInterest(getBalance() * RATE);
    }

    public String getAccountType() { return "Savings"; }
}
