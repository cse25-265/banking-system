package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private static int nextNumber = 1001;

    private int accountNumber;
    private double balance;
    private String branch;
    private Customer owner;
    private List<Transaction> transactions = new ArrayList<>();

    public Account(Customer owner, String branch) {
        this.accountNumber = nextNumber++;
        this.owner = owner;
        this.branch = branch;
    }

    // Deposit
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be more than 0");
        }
        balance = balance + amount;
        transactions.add(new Transaction("DEPOSIT", amount));
    }

    // Overloaded deposit: same name, extra note
    public void deposit(double amount, String note) {
        deposit(amount);
        transactions.add(new Transaction("NOTE: " + note, 0));
    }

    // Every account type decides its own withdraw rule
    public abstract void withdraw(double amount);

    public abstract String getAccountType();

    // Used by child classes that allow withdrawals
    protected void removeFunds(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal must be more than 0");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Not enough funds");
        }
        balance = balance - amount;
        transactions.add(new Transaction("WITHDRAWAL", amount));
    }

    // Used by child classes that pay interest
    protected void addInterest(double interest) {
        balance = balance + interest;
        transactions.add(new Transaction("INTEREST", interest));
    }

    public int getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public String getBranch() { return branch; }
    public Customer getOwner() { return owner; }
    public List<Transaction> getTransactions() { return transactions; }
}
