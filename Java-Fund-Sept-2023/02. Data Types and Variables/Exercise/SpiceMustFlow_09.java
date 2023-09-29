package data_types_and_variables_exercise;

import java.util.Scanner;
public class SpiceMustFlow_09 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());

        int days = 0;
        int total = 0;

        while (startingYield >= 100) {
            days++;
            int spicesPerDay = startingYield - 26;
            total += spicesPerDay;

            startingYield -= 10;
        }
        total -= 26;

        if (total < 0) {
            total = 0;
        }
        System.out.println(days);
        System.out.println(total);
    }
}
