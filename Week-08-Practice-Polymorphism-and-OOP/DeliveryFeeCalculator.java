abstract class Delivery {
    protected double weight;
    public Delivery(double weight) { this.weight = weight; }
    public abstract double calculateFee();
}

class StandardDelivery extends Delivery {
    public StandardDelivery(double weight) { super(weight); }
    @Override public double calculateFee() { return 5.0 + (weight * 0.5); }
}

public class DeliveryFeeCalculator {
    public static void main(String[] args) {
        Delivery d = new StandardDelivery(10);
        System.out.println("Fee: $" + d.calculateFee());
    }
}