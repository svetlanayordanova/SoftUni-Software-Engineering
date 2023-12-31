package arrays_exercise;

import java.util.Scanner;
public class ZigZagArrays_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[] firstArray = new int[rows];
        int[] secondArray = new int[rows];

        for (int row = 1; row <= rows; row++) {
            String[] numbers = scanner.nextLine().split(" ");
            int number1 = Integer.parseInt(numbers[0]);
            int number2 = Integer.parseInt(numbers[1]);

            if (row % 2 != 0) {
                firstArray[row-1] = number1;
                secondArray[row-1] = number2;
            } else {
                secondArray[row-1] = number1;
                firstArray[row-1] = number2;
            }
        }
        for (int number : firstArray) {
            System.out.print(number + " ");
        }
        System.out.println();
        for (int number : secondArray) {
            System.out.print(number + " ");
        }
    }
}
