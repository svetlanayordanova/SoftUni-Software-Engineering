package multidimensional_arrays_exercise;

import java.util.Scanner;

public class FillTheMatrix_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] params = scanner.nextLine().split(", ");
        int dim = Integer.parseInt(params[0]);
        String pattern = params[1];

        int[][] matrix = new int[dim][dim];

        if ("A".equals(pattern)) {
            patternA(matrix);
        } else {
            patternB(matrix);
        }
    }

    public static void patternB(int[][] matrix) {
        int dim = matrix.length;
        int num = 1;

        for (int col = 0; col < dim; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < dim; row++) {
                    matrix[row][col] = num++;
                }
            } else {
                for (int row = dim - 1; row >= 0; row--) {
                    matrix[row][col] = num++;
                }
            }
        }

        printMatrix(matrix);
    }

    public static void patternA(int[][] matrix) {
        int dim = matrix.length;
        int num = 1;

        for (int col = 0; col < dim; col++) {
            for (int row = 0; row < dim; row++) {
                matrix[row][col] = num++;
            }
        }

        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
