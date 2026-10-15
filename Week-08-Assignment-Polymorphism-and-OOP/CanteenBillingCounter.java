import java.util.*;

abstract class Customer {
    protected String type;
    protected double billAmount;

    public Customer(String type, double billAmount) {
        this.type = type;
        this.billAmount = billAmount;
    }

    public abstract double calculateFinalAmount();
}

class StudentCustomer extends Customer {
    public StudentCustomer(double billAmount) { super("STUDENT", billAmount); }
    @Override public double calculateFinalAmount() { return billAmount * 0.90; }
}

class StaffCustomer extends Customer {
    public StaffCustomer(double billAmount) { super("STAFF", billAmount); }
    @Override public double calculateFinalAmount() { return billAmount * 0.95; }
}

public class CanteenBillingCounter {
    public static void main(String[] args) {
        Customer c = new StudentCustomer(100.0);
        System.out.println("Final Bill: $" + c.calculateFinalAmount());
    }
}