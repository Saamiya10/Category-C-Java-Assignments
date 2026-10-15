abstract class Room {
    protected int units;
    public Room(int units) { this.units = units; }
    public abstract double calculateBill();
}

class SingleRoom extends Room {
    public SingleRoom(int units) { super(units); }
    @Override public double calculateBill() { return units * 8.0; }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Room r = new SingleRoom(50);
        System.out.println("Bill: $" + r.calculateBill());
    }
}