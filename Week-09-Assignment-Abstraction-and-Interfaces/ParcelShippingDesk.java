import java.util.*;

interface Insurable {
    double calculateInsurance(double declaredValue);
}

abstract class Parcel {
    protected String type;
    protected double weightKg;
    protected double declaredValue;

    public Parcel(String type, double weightKg, double declaredValue) {
        this.type = type;
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    public abstract double calculateCharge();
    public String getType() { return type; }
}

class StandardParcel extends Parcel {
    public StandardParcel(double weightKg, double declaredValue) { super("STANDARD", weightKg, declaredValue); }
    @Override public double calculateCharge() { return 40.0 + (10.0 * weightKg); }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weightKg, double declaredValue) { super("EXPRESS", weightKg, declaredValue); }
    @Override public double calculateCharge() { return 80.0 + (15.0 * weightKg); }
    @Override public double calculateInsurance(double declaredValue) { return 0.02 * declaredValue; }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weightKg, double declaredValue) { super("FRAGILE", weightKg, declaredValue); }
    @Override public double calculateCharge() { return (40.0 + 10.0 * weightKg) + 50.0; }
    @Override public double calculateInsurance(double declaredValue) { return 0.02 * declaredValue; }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double val = sc.nextDouble();

            Parcel p = null;
            if (type.equalsIgnoreCase("STANDARD")) p = new StandardParcel(weight, val);
            else if (type.equalsIgnoreCase("EXPRESS")) p = new ExpressParcel(weight, val);
            else if (type.equalsIgnoreCase("FRAGILE")) p = new FragileParcel(weight, val);

            if (p != null) {
                double charge = p.calculateCharge();
                double insurance = (p instanceof Insurable) ? ((Insurable) p).calculateInsurance(val) : 0.0;
                double total = charge + insurance;
                grandTotal += total;
                System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", p.getType(), charge, insurance, total);
            }
        }
        System.out.printf("Grand Total: %.2f%n", grandTotal);
    }
}