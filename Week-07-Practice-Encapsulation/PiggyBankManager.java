class PiggyBank {
    private final String id;
    private double savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) savings += amount;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= savings) savings -= amount;
    }

    public double getSavings() { return savings; }
}

public class PiggyBankManager {
    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        pb.withdraw(30);
        System.out.println("Savings: " + pb.getSavings());
    }
}