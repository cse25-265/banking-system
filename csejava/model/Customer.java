package model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerId;
    private String firstName;
    private String surname;
    private String address;
    private String email;
    private String password;
    private List<Account> accounts = new ArrayList<>();

    public Customer(String customerId, String firstName, String surname,
                    String address, String email, String password) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    public boolean login(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    // The customer creates its own accounts, so an account always has an owner
    public SavingsAccount openSavingsAccount(String branch) {
        SavingsAccount a = new SavingsAccount(this, branch);
        accounts.add(a);
        return a;
    }

    public InvestmentAccount openInvestmentAccount(String branch, double initialDeposit) {
        InvestmentAccount a = new InvestmentAccount(this, branch, initialDeposit);
        accounts.add(a);
        return a;
    }

    public ChequeAccount openChequeAccount(String branch, String employer, String employerAddress) {
        ChequeAccount a = new ChequeAccount(this, branch, employer, employerAddress);
        accounts.add(a);
        return a;
    }

    public String getCustomerId() { return customerId; }
    public String getFirstName() { return firstName; }
    public String getSurname() { return surname; }
    public String getAddress() { return address; }
    public String getEmail() { return email; }
    public List<Account> getAccounts() { return accounts; }
}
