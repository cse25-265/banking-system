package model;

public class InvestmentAccount extends Account implements InterestBearing {
    private static final double RATE = 0.05; // 5% monthly
    private static final double MINIMUM = 500.00;

    public InvestmentAccount(Customer owner, String branch, double initialDeposit) {
        super(owner, branch);
        if (initialDeposit < MINIMUM) {
            throw new IllegalArgumentException("Investment account needs at least BWP500");
        }
        deposit(initialDeposit);
    }

    @Override
    public void withdraw(double amount) {
        removeFunds(amount);
    }

    public double getInterestRate() { return RATE; }

    public void payInterest() {
        addInterest(getBalance() * RATE);
    }

    public String getAccountType() { return "Investment"; }
}
