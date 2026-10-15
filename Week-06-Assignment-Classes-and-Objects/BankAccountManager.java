class BankAccount {
    String accountNumber;
    String accountHolder;
    double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) balance -= amount;
    }

    public void printDetails() {
        System.out.println(accountHolder + " (" + accountNumber + "): $" + balance);
    }
}

public class BankAccountManager {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC1001", "Priya", 1500.0);
        acc.deposit(500);
        acc.withdraw(200);
        acc.printDetails();
    }
}