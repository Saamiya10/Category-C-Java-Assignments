class AttendanceSheet {
    private final String[] presentStudents;
    private int count;

    public AttendanceSheet(int maxClassSize) {
        this.presentStudents = new String[maxClassSize];
        this.count = 0;
    }

    public void markPresent(String studentName) {
        if (studentName != null && count < presentStudents.length) {
            presentStudents[count++] = studentName;
        }
    }

    public int getPresentCount() { return count; }
}

public class AttendanceSheetManager {
    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        System.out.println("Present Count: " + sheet.getPresentCount());
    }
}