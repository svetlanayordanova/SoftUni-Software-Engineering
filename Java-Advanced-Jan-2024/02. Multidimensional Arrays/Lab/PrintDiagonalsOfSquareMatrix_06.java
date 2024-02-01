package multidimensional_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix_06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        fillMatrix(matrix, scanner);

        int[][] result = new int[2][size];

        int resultColumn = 0;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                if (row == col) {
                    result[0][resultColumn] = matrix[row][col];
                    resultColumn++;
                }
            }
        }

        resultColumn = 0;

        for (int row = size - 1; row >= 0; row--) {
            for (int col = 0; col < size; col++) {

                if (col == size - row - 1) {
                    result[1][resultColumn] = matrix[row][col];
                    resultColumn++;
                }
            }
        }

        printMatrix(result);
    }

    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}