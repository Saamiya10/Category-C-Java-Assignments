import java.util.Scanner;

public class DigitSumReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int num = sc.nextInt();
        int original = num;
        int sum = 0, rev = 0;

        while (num > 0) {
            int digit = num % 10;
            sum += digit;
            rev = rev * 10 + digit;
            num /= 10;
        }
        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + rev);
    }
}