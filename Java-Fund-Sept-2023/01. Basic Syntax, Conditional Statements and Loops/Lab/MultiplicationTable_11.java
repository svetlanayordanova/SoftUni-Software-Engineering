package basics_recap;

import java.util.Scanner;
public class MultiplicationTable_11 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int multiplier = Integer.parseInt(scanner.nextLine());

        do {
            int result = number * multiplier;
            System.out.printf("%d X %d = %d%n", number, multiplier, result);
            multiplier += 1;
        } while (multiplier <= 10);
    }
}
