package multidimensional_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements_08 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][];
        int[][] fixedMatrix;
        fixedMatrix = matrix;

        fillMatrix(matrix, scanner);

        String[] wrongValueCoordinates = scanner.nextLine().split(" ");
        int wrongValueRow = Integer.parseInt(wrongValueCoordinates[0]);
        int wrongValueCol = Integer.parseInt(wrongValueCoordinates[1]);

        replaceWrongValues(matrix, fixedMatrix, wrongValueRow, wrongValueCol);

        printMatrix(fixedMatrix);
    }

    public static void printMatrix(int[][] fixedMatrix) {
        for (int row = 0; row < fixedMatrix.length; row++) {
            for (int col = 0; col < fixedMatrix[row].length; col++) {
                System.out.print(fixedMatrix[row][col] + " ");
            }

            System.out.println();
        }
    }

    public static void replaceWrongValues(int[][] matrix, int[][] fixedMatrix, int wrongValueRow, int wrongValueCol) {
        int wrongValue = matrix[wrongValueRow][wrongValueCol];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongValue) {
                    int sum = 0;

                    //1. Обхождаме нагоре
                    if (row > 0) {
                        if (wrongValue != matrix[row - 1][col]) {
                            sum += matrix[row - 1][col];
                        }
                    }

                    //2. Обхождаме надолу
                    if (row < matrix.length - 1) {
                        if (wrongValue != matrix[row + 1][col]) {
                            sum += matrix[row + 1][col];
                        }
                    }

                    //3. Обхождаме наляво
                    if (col > 0) {
                        if (wrongValue != matrix[row][col - 1]) {
                            sum += matrix[row][col - 1];
                        }
                    }

                    //4. Обхождаме надясно
                    if (col < matrix[row].length - 1) {
                        if (wrongValue != matrix[row][col + 1]) {
                            sum += matrix[row][col + 1];
                        }
                    }

                    fixedMatrix[row][col] = sum;
                }
            }
        }
    }

    private static void fillMatrix(int[][] matrix,Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}