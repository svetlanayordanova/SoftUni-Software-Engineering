package multidimensional_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readInputAsArray(scanner);

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = readInputAsArray(scanner);
        }

        int number = Integer.parseInt(scanner.nextLine());
        boolean hasFound = false;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == number) {
                    System.out.printf("%d %d%n", row, col);
                    hasFound = true;
                }
            }
        }

        if (!hasFound) {
            System.out.println("not found");
        }
    }

    public static int[] readInputAsArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}