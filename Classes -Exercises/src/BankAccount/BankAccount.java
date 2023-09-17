package BankAccount;

public class BankAccount {
    private int id;
    private double balance;
    private static double interestRate = 0.2;

    public BankAccount() {
        this.id += 1;
    }

    public static void setInterestRate(double interest) {
        BankAccount.interestRate = interest;
    }

    public double getInterest(int years) {

        return BankAccount.interestRate * years * this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
