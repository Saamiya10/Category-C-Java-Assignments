public class SecondBestScore {
    public static int secondHighest(int[] scores) {
        int highest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int s : scores) {
            if (s > highest) {
                second = highest;
                highest = s;
            } else if (s > second && s != highest) {
                second = s;
            }
        }
        return (second == Integer.MIN_VALUE) ? -1 : second;
    }

    public static void main(String[] args) {
        System.out.println(secondHighest(new int[]{45, 78, 92, 78, 60}));
        System.out.println(secondHighest(new int[]{50, 50, 50}));
    }
}