import java.util.*;

interface NightServiceable {
    double applyNightSurcharge(double baseFare);
}

abstract class Cab {
    protected String type;
    protected double ratePerKm;

    public Cab(String type, double ratePerKm) {
        this.type = type;
        this.ratePerKm = ratePerKm;
    }

    public double calculateBaseFare(double km) {
        return Math.max(100.0, km * ratePerKm);
    }

    public String getType() { return type; }
}

class MiniCab extends Cab {
    public MiniCab() { super("MINI", 10.0); }
}

class SedanCab extends Cab implements NightServiceable {
    public SedanCab() { super("SEDAN", 14.0); }
    @Override public double applyNightSurcharge(double baseFare) { return baseFare * 1.20; }
}

class SUVCab extends Cab implements NightServiceable {
    public SUVCab() { super("SUV", 18.0); }
    @Override public double applyNightSurcharge(double baseFare) { return baseFare * 1.20; }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String cabType = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab = null;
            if (cabType.equalsIgnoreCase("MINI")) cab = new MiniCab();
            else if (cabType.equalsIgnoreCase("SEDAN")) cab = new SedanCab();
            else if (cabType.equalsIgnoreCase("SUV")) cab = new SUVCab();

            if (cab != null) {
                if (time.equalsIgnoreCase("NIGHT") && !(cab instanceof NightServiceable)) {
                    System.out.printf("%s: night service not available%n", cab.getType());
                } else {
                    double fare = cab.calculateBaseFare(km);
                    if (time.equalsIgnoreCase("NIGHT")) {
                        fare = ((NightServiceable) cab).applyNightSurcharge(fare);
                    }
                    total += fare;
                    System.out.printf("%s: %.2f%n", cab.getType(), fare);
                }
            }
        }
        System.out.printf("Total: %.2f%n", total);
    }
}