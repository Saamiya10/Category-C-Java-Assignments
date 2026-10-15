class StudentGrading {
    String name;
    int[] marks;

    public StudentGrading(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public double calculateAverage() {
        int sum = 0;
        for (int mark : marks) sum += mark;
        return (double) sum / marks.length;
    }

    public void printGradeReport() {
        double avg = calculateAverage();
        String grade = (avg >= 80) ? "A" : (avg >= 60) ? "B" : "C";
        System.out.println(name + " - Average: " + avg + " Grade: " + grade);
    }
}

public class StudentGradeManager {
    public static void main(String[] args) {
        StudentGrading s = new StudentGrading("Kavya", new int[]{85, 90, 78, 92});
        s.printGradeReport();
    }
}