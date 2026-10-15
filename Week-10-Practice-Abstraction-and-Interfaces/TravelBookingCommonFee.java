import java.util.*;

abstract class Booking {
    protected String mode;
    protected double distanceKm;
    protected static final double BOOKING_FEE = 50.0;

    public Booking(String mode, double distanceKm) {
        this.mode = mode;
        this.distanceKm = distanceKm;
    }

    public abstract double calculateBaseFare();

    public double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }

    public String getMode() { return mode; }
}

class BusBooking extends Booking {
    public BusBooking(double distanceKm) {
        super("BUS", distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return distanceKm * 2.0;
    }
}

class TrainBooking extends Booking {
    public TrainBooking(double distanceKm) {
        super("TRAIN", distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return distanceKm * 1.5;
    }
}

class FlightBooking extends Booking {
    public FlightBooking(double distanceKm) {
        super("FLIGHT", distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return 2500.0 + (distanceKm * 4.0);
    }
}

public class TravelBookingCommonFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();
            Booking booking = null;

            if (mode.equalsIgnoreCase("BUS")) {
                booking = new BusBooking(distance);
            } else if (mode.equalsIgnoreCase("TRAIN")) {
                booking = new TrainBooking(distance);
            } else if (mode.equalsIgnoreCase("FLIGHT")) {
                booking = new FlightBooking(distance);
            }

            if (booking != null) {
                System.out.printf("%s: %.2f%n", booking.getMode(), booking.calculateTotalFare());
            }
        }
    }
}