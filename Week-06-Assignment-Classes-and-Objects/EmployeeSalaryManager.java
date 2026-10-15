class Employee {
    int id;
    String name;
    double baseSalary;

    public Employee(int id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double calculateNetSalary() {
        return baseSalary + (baseSalary * 0.12) - (baseSalary * 0.05);
    }

    public void printPaySlip() {
        System.out.println(name + " [ID: " + id + "] Net Salary: $" + calculateNetSalary());
    }
}

public class EmployeeSalaryManager {
    public static void main(String[] args) {
        Employee emp = new Employee(101, "Suresh", 50000);
        emp.printPaySlip();
    }
}