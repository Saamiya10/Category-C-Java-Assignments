public class ExamScoreBandCounter {
    public static int countInBand(int[] scores, int low, int high) {
        int firstGte = findFirstGte(scores, low);
        int firstGt = findFirstGt(scores, high);
        return firstGt - firstGte;
    }

    private static int findFirstGte(int[] scores, int target) {
        int left = 0, right = scores.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private static int findFirstGt(int[] scores, int target) {
        int left = 0, right = scores.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] > target) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        System.out.println(countInBand(scores, 42, 58));
        System.out.println(countInBand(scores, 90, 100));
    }
}