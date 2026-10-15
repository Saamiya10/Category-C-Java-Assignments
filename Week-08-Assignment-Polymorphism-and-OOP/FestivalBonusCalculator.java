abstract class EmployeeBonus {
    protected double salary;
    public EmployeeBonus(double salary) { this.salary = salary; }
    public abstract double calculateBonus();
}

class FullTimeBonus extends EmployeeBonus {
    public FullTimeBonus(double salary) { super(salary); }
    @Override public double calculateBonus() { return salary * 0.10; }
}

public class FestivalBonusCalculator {
    public static void main(String[] args) {
        EmployeeBonus e = new FullTimeBonus(50000);
        System.out.println("Bonus: $" + e.calculateBonus());
    }
}