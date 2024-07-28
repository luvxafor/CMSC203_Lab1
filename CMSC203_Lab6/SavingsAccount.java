package lab6;

public class SavingsAccount extends BankAccount {
    private static final double RATE = 0.025; // annual interest rate of 2.5%
    private int savingsNumber = 0; // initialize to 0
    private String accountNumber; // hides the accountNumber from the superclass

    public SavingsAccount(String name, double initialBalance) {
        super(name, initialBalance);
        this.accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }

    // postInterest method
    public void postInterest() {
        double monthlyInterest = (getBalance() * RATE) / 12;
        deposit(monthlyInterest);
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    // copy constructor
    public SavingsAccount(SavingsAccount originalAccount, double initialBalance) {
        super(originalAccount, initialBalance);
        this.savingsNumber = originalAccount.savingsNumber + 1;
        this.accountNumber = super.getAccountNumber() + "-" + this.savingsNumber;
    }
}
