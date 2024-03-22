package exceptions_and_error_handling;

import java.util.Arrays;
import java.util.Scanner;

public class NumberInRange_01 {
    private static int start = 0;
    private static int end = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        start = range[0];
        end = range[1];

        System.out.printf("Range: [%d...%d]%n", start, end);

        while (true) {
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (isInRange(number)) {
                    System.out.println("Valid number: " + number);
                    return;
                } else {
                    System.out.println("Invalid number: " + number);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number: " + input);
            }
        }
    }

    private static boolean isInRange(int number) {
        return start <= number && number <= end;
    }
}
