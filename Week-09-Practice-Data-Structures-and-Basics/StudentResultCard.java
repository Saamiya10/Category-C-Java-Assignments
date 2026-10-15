class StudentResult {
    String name;
    int[] marks;

    public StudentResult(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public double calculateAverage() {
        int sum = 0;
        for (int m : marks) sum += m;
        return (double) sum / marks.length;
    }

    public void printReport() {
        double avg = calculateAverage();
        String grade = (avg >= 75) ? "B" : (avg >= 40) ? "D" : "F";
        System.out.printf("%s: Average %.1f, Grade %s%n", name.toUpperCase(), avg, grade);
    }
}

public class StudentResultCard {
    public static void main(String[] args) {
        StudentResult s1 = new StudentResult("Asha", new int[]{80, 90, 70});
        s1.printReport();
    }
}