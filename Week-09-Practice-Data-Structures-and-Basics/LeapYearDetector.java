import java.util.Scanner;

public class LeapYearDetector {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int year = sc.nextInt();

        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        if (isLeap) System.out.println("Leap year");
        else System.out.println("Not a leap year");
    }
}