package methods_exercise;

import java.util.Scanner;
public class TopNumber_10 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int number = 1; number <= n; number++) {
            boolean isValidSumDigits = checkSumDigitsIsDivisibleBy8(number);
            boolean containsOddDigit = checkContainsOddDigits(number);

            if (isValidSumDigits && containsOddDigit) {
                System.out.println(number);
            }
        }
    }

    public static boolean checkSumDigitsIsDivisibleBy8(int n) {
        int sum = 0;

        while (n > 0) {
            int lastDigit = n % 10;
            sum += lastDigit;
            n /= 10;
        }

        if (sum % 8 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkContainsOddDigits(int number) {
        while (number > 0) {
            int lastDigit = number % 10;

            if (lastDigit % 2 != 0) {
                return true;
            } else {
                number /= 10;
            }
        }

        return false;
    }
}
