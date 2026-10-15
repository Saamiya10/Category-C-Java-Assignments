public class SeatingGridOptimizer {
    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) return 0;
        double sum = 0;
        for (int score : row) sum += score;
        return sum / row.length;
    }

    public static String classifyRows(int[][] seatingScores, int threshold) {
        if (seatingScores == null) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            if (i > 0) sb.append(" | ");
            sb.append("Row ").append(i).append(": ");
            if (avg >= threshold) {
                sb.append("Buzzing Zone");
            } else {
                sb.append("Quiet Zone");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] grid = {{40, 50, 45}, {85, 90, 95}, {30, 20, 25}};
        System.out.println(classifyRows(grid, 60));
    }
}