import java.util.*;

abstract class Connection {
    protected String type;
    protected double units;

    public Connection(String type, double units) {
        this.type = type;
        this.units = units;
    }

    public abstract double calculateBill();

    public String getType() { return type; }
}

class HomeConnection extends Connection {
    public HomeConnection(double units) {
        super("HOME", units);
    }

    @Override
    public double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        } else {
            return (100 * 5.0) + ((units - 100) * 7.0);
        }
    }
}

class ShopConnection extends Connection {
    public ShopConnection(double units) {
        super("SHOP", units);
    }

    @Override
    public double calculateBill() {
        return (units * 8.0) + 100.0;
    }
}

class FactoryConnection extends Connection {
    public FactoryConnection(double units) {
        super("FACTORY", units);
    }

    @Override
    public double calculateBill() {
        return Math.max(1000.0, units * 6.0);
    }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double totalBill = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();
            Connection conn = null;

            if (type.equalsIgnoreCase("HOME")) {
                conn = new HomeConnection(units);
            } else if (type.equalsIgnoreCase("SHOP")) {
                conn = new ShopConnection(units);
            } else if (type.equalsIgnoreCase("FACTORY")) {
                conn = new FactoryConnection(units);
            }

            if (conn != null) {
                double bill = conn.calculateBill();
                totalBill += bill;
                System.out.printf("%s: %.2f%n", conn.getType(), bill);
            }
        }
        System.out.printf("Total: %.2f%n", totalBill);
    }
}