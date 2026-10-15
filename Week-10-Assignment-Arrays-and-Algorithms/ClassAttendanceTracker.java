public class ClassAttendanceTracker {
    public static String attendanceSummary(int[] days) {
        int presentCount = 0;
        int longestStreak = 0;
        int currentStreak = 0;

        for (int d : days) {
            if (d == 1) {
                presentCount++;
                currentStreak++;
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }
        return "Present: " + presentCount + ", Longest streak: " + longestStreak;
    }

    public static void main(String[] args) {
        System.out.println(attendanceSummary(new int[]{1, 1, 0, 1, 1, 1, 0, 1}));
        System.out.println(attendanceSummary(new int[]{0, 0, 0}));
    }
}