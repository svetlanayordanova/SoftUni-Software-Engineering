package data_types_and_variables_more_exercise;

import java.util.Scanner;
public class RefactoringPrimeChecker_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int number = 2; number <= n; number++) {
            boolean isPrime = true;
            for (int divisor = 2; divisor < number; divisor++) {
                if (number % divisor == 0) {
                    isPrime = false;
                    break;
                }
            }
            System.out.printf("%d -> %b%n", number, isPrime);
        }
    }
}
