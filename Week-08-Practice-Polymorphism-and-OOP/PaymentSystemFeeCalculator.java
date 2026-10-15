abstract class Payment {
    protected double amount;
    public Payment(double amount) { this.amount = amount; }
    public abstract double calculateFinalAmount();
}

class CardPayment extends Payment {
    public CardPayment(double amount) { super(amount); }
    @Override public double calculateFinalAmount() { return amount * 1.02; }
}

public class PaymentSystemFeeCalculator {
    public static void main(String[] args) {
        Payment p = new CardPayment(100);
        System.out.println("Total: $" + p.calculateFinalAmount());
    }
}