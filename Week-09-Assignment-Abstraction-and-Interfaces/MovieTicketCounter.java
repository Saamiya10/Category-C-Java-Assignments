import java.util.*;

abstract class Seat {
    protected String type;
    protected double basePrice;

    public Seat(String type, double basePrice) {
        this.type = type;
        this.basePrice = basePrice;
    }

    public abstract double calculateTotal(int count);

    public String getType() { return type; }
}

class RegularSeat extends Seat {
    public RegularSeat() { super("REGULAR", 150.0); }
    @Override public double calculateTotal(int count) { return count * (basePrice + 20.0); }
}

class PremiumSeat extends Seat {
    public PremiumSeat() { super("PREMIUM", 250.0); }
    @Override public double calculateTotal(int count) { return count * (basePrice + 20.0); }
}

class ReclinerSeat extends Seat {
    public ReclinerSeat() { super("RECLINER", 400.0); }
    @Override public double calculateTotal(int count) { return count * (basePrice + 20.0); }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int count = sc.nextInt();
            Seat seat = null;
            if (type.equalsIgnoreCase("REGULAR")) seat = new RegularSeat();
            else if (type.equalsIgnoreCase("PREMIUM")) seat = new PremiumSeat();
            else if (type.equalsIgnoreCase("RECLINER")) seat = new ReclinerSeat();

            if (seat != null) {
                double amount = seat.calculateTotal(count);
                grandTotal += amount;
                System.out.printf("%s: %.2f%n", seat.getType(), amount);
            }
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }
}