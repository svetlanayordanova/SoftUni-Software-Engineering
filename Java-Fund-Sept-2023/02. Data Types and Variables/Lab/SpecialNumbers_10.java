package data_types_and_variables;

import java.util.Scanner;
public class SpecialNumbers_10 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            int number = i;
            int sum = 0;

            while (number > 0) {
                int lastDigit = number % 10; //вземаме последната цифра на числото
                sum += lastDigit; //добавяме я към сумата

                number /= 10; //премахваме последната цифра от числото
                }

            boolean isSpecial = sum == 5 || sum == 7 || sum == 11;

            if (isSpecial) {
                System.out.printf("%d -> %s%n", i, "True");
            } else {
                System.out.printf("%d -> %s%n", i, "False");
            }
        }
    }
}
