package multidimensional_arrays_exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];
        String[][] matrix = new String[rows][cols];

        fillMatrix(matrix);

        printMatrix(matrix);
    }

    public static void fillMatrix(String[][] matrix) {
        char firstLetter = 'a';
        char secondLetter;
        char thirdLetter = 'a';

        for (int row = 0; row < matrix.length; row++) {
            secondLetter = firstLetter;
            for (int col = 0; col < matrix[row].length; col++) {
                String threeLetters = String.valueOf(firstLetter) + secondLetter++ + thirdLetter;
                matrix[row][col] = threeLetters;

            }

            firstLetter++;
            thirdLetter++;
        }
    }

    public static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}