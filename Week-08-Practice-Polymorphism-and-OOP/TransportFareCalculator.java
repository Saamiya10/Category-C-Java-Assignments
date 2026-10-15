abstract class Transport {
    protected double distance;
    public Transport(double distance) { this.distance = distance; }
    public abstract double calculateFare();
}

class BusTransport extends Transport {
    public BusTransport(double distance) { super(distance); }
    @Override public double calculateFare() { return 2.0 + (distance * 0.10); }
}

public class TransportFareCalculator {
    public static void main(String[] args) {
        Transport t = new BusTransport(15);
        System.out.println("Fare: $" + t.calculateFare());
    }
}