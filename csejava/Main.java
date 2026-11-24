import model.*;

public class Main {
    public static void main(String[] args) {
        Customer c = new Customer("C001", "Abi", "Test", "Gaborone", "abi@mail.com", "1234");

        c.openSavingsAccount("Main Branch").deposit(1000);
        c.openInvestmentAccount("Main Branch", 500);
        c.openChequeAccount("Main Branch", "ABC Ltd", "Plot 1, Gaborone").deposit(2000);

        for (Account a : c.getAccounts()) {
            if (a instanceof InterestBearing) {
                ((InterestBearing) a).payInterest();
            }
            System.out.println(a.getAccountType() + " " + a.getAccountNumber()
                + " balance: " + a.getBalance());
        }

        try {
            c.getAccounts().get(0).withdraw(100);
        } catch (UnsupportedOperationException e) {
            System.out.println("Expected error: " + e.getMessage());
        }
    }
}
