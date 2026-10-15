import java.util.Arrays;

public class DutyRosterRotation {
    public static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        if (n == 0) return names;
        int effectiveK = (int)(k % n);
        String[] rotated = new String[n];

        for (int i = 0; i < n; i++) {
            rotated[(i + effectiveK) % n] = names[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        String[] roster = {"A", "B", "C", "D", "E"};
        System.out.println(Arrays.toString(rotateRoster(roster, 2)));
        System.out.println(Arrays.toString(rotateRoster(roster, 7)));
    }
}