package data_types_and_variables_more_exercise;

import java.util.Scanner;
public class FromLeftToTheRight_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            int sum = 0;

            String input = scanner.nextLine();

            String[] parts = input.split(" ");
            long leftNum = Long.parseLong(parts[0]);
            long rightNum = Long.parseLong(parts[1]);

            if (leftNum > rightNum) {
                while (!(leftNum == 0)) {
                    sum += leftNum % 10;
                    leftNum /= 10;
                }
                System.out.println(Math.abs(sum));
            } else {
                while (!(rightNum == 0)) {
                    sum += rightNum % 10;
                    rightNum /= 10;
                }
                System.out.println(Math.abs(sum));
            }
        }
    }
}
