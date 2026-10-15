import java.util.*;

interface BusUser {
    double getTransportFee();
}

abstract class StudentFee {
    protected String name;
    public StudentFee(String name) { this.name = name; }
    public abstract double calculateFee();
    public String getName() { return name; }
}

class DayScholar extends StudentFee implements BusUser {
    public DayScholar(String name) { super(name); }
    @Override public double calculateFee() { return 40000.0 + getTransportFee(); }
    @Override public double getTransportFee() { return 12000.0; }
}

class Hosteller extends StudentFee {
    public Hosteller(String name) { super(name); }
    @Override public double calculateFee() { return 40000.0 + 60000.0; }
}

class ScholarStudent extends StudentFee implements BusUser {
    public ScholarStudent(String name) { super(name); }
    @Override public double calculateFee() { return 20000.0 + getTransportFee(); }
    @Override public double getTransportFee() { return 12000.0; }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            StudentFee s = null;
            if (type.equalsIgnoreCase("DAY_SCHOLAR")) s = new DayScholar(name);
            else if (type.equalsIgnoreCase("HOSTELLER")) s = new Hosteller(name);
            else if (type.equalsIgnoreCase("SCHOLAR")) s = new ScholarStudent(name);

            if (s != null) {
                double fee = s.calculateFee();
                totalCollected += fee;
                System.out.printf("%s: %.2f%n", s.getName(), fee);
            }
        }
        System.out.printf("Total Collected: %.2f%n", totalCollected);
    }
}