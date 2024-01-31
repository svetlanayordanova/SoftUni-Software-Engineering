package multidimensional_arrays;

import java.util.Scanner;

public class IntersectionOfTwoMatrices_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] first = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            first[row] = scanner.nextLine().replaceAll("\\s+", "")
                    .toCharArray();
        }

        char[][] second = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            second[row] = scanner.nextLine().replaceAll("\\s+", "")
                    .toCharArray();
        }

        char[][] result = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char a = first[row][col];
                char b = second[row][col];

                result[row][col] = a == b ? a : '*';
            }
        }

        printMatrix(result);
    }

    public static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}