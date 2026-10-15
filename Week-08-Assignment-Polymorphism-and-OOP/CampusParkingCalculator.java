abstract class Vehicle {
    protected int hours;
    public Vehicle(int hours) { this.hours = hours; }
    public abstract double calculateCharge();
}

class Bike extends Vehicle {
    public Bike(int hours) { super(hours); }
    @Override public double calculateCharge() { return hours * 10.0; }
}

class Car extends Vehicle {
    public Car(int hours) { super(hours); }
    @Override public double calculateCharge() { return 30.0 + (hours > 1 ? (hours - 1) * 20.0 : 0); }
}

public class CampusParkingCalculator {
    public static void main(String[] args) {
        Vehicle v = new Car(3);
        System.out.println("Parking Fee: $" + v.calculateCharge());
    }
}