package banking;

public class BankingAccount {
    private int balance;

    // Constructor
    public BankingAccount() {
        this.balance = 0; // Initial balance
    }

    // Deposit method
    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    // Withdraw method
    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn: " + amount);
        } else {
            System.out.println("Invalid or insufficient funds");
        }
    }

    // View balance method
    public int getBalance() {
        return balance;
    }
}
