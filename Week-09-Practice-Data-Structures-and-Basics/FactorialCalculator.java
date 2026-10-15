import java.util.Scanner;

public class FactorialCalculator {
    public static long factorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) fact *= i;
        return fact;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        System.out.println(factorial(n));
    }
}