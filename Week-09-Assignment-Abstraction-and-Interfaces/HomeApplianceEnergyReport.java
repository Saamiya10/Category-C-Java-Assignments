import java.util.*;

interface SaverModifiable {
    double applySaverDiscount(double units);
}

abstract class Appliance {
    protected String name;
    protected double powerWatts;

    public Appliance(String name, double powerWatts) {
        this.name = name;
        this.powerWatts = powerWatts;
    }

    public double calculateUnits(double hours) {
        return (powerWatts * hours) / 1000.0;
    }

    public String getName() { return name; }
}

class FridgeAppliance extends Appliance {
    public FridgeAppliance() { super("FRIDGE", 150.0); }
}

class ACAppliance extends Appliance implements SaverModifiable {
    public ACAppliance() { super("AC", 1500.0); }
    @Override public double applySaverDiscount(double units) { return units * 0.75; }
}

class TVAppliance extends Appliance {
    public TVAppliance() { super("TV", 100.0); }
}

class WasherAppliance extends Appliance implements SaverModifiable {
    public WasherAppliance() { super("WASHER", 500.0); }
    @Override public double applySaverDiscount(double units) { return units * 0.75; }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = Integer.parseInt(sc.nextLine().trim());
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+");
            String type = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean saverRequested = (parts.length > 2 && parts[2].equalsIgnoreCase("SAVER"));

            Appliance app = null;
            if (type.equalsIgnoreCase("FRIDGE")) app = new FridgeAppliance();
            else if (type.equalsIgnoreCase("AC")) app = new ACAppliance();
            else if (type.equalsIgnoreCase("TV")) app = new TVAppliance();
            else if (type.equalsIgnoreCase("WASHER")) app = new WasherAppliance();

            if (app != null) {
                if (saverRequested && !(app instanceof SaverModifiable)) {
                    System.out.printf("%s: saver mode not supported%n", app.getName());
                } else {
                    double units = app.calculateUnits(hours);
                    if (saverRequested) {
                        units = ((SaverModifiable) app).applySaverDiscount(units);
                    }
                    double cost = units * 8.0;
                    totalCost += cost;
                    System.out.printf("%s: Units=%.2f Cost=%.2f%n", app.getName(), units, cost);
                }
            }
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
    }
}