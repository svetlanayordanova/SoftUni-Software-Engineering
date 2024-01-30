package multidimensional_arrays;

import java.util.Scanner;

public class FindTheRealQueen_07 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[8][8];

        fillMatrix(matrix, scanner);

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'q') {
                    int currentQueenPositionRow = Integer.parseInt(String.valueOf(row));
                    int currentQueenPositionCol = Integer.parseInt(String.valueOf(col));


                    if (foundRealQueen(matrix, currentQueenPositionRow, currentQueenPositionCol)) {
                        System.out.printf("%d %d", currentQueenPositionRow, currentQueenPositionCol);
                    }
                }
            }
        }
    }

    public static boolean foundRealQueen(char[][] matrix, int currentQueenPositionRow, int currentQueenPositionCol) {
        //1. Обхождаме нагоре
        for (int row = currentQueenPositionRow - 1; row >= 0; row--) {
            if (matrix[row][currentQueenPositionCol] == 'q') {
                return false;
            }
        }

        //2. Обхождаме надолу
        for (int row = currentQueenPositionRow + 1; row < matrix.length; row++) {
            if (matrix[row][currentQueenPositionCol] == 'q') {
                return false;
            }
        }

        //3. Обхождаме наляво
        for (int col = currentQueenPositionCol - 1; col >= 0; col--) {
            if (matrix[currentQueenPositionRow][col] == 'q') {
                return false;
            }
        }

        //4. Обхождаме надясно
        for (int col = currentQueenPositionCol + 1; col < matrix.length; col++) {
            if (matrix[currentQueenPositionRow][col] == 'q') {
                return false;
            }
        }

        //5. Обхождаме горен ляв диагонал
        for (int row = currentQueenPositionRow - 1, col = currentQueenPositionCol - 1; row >= 0 && col >= 0; row--, col--) {
            if (matrix[row][col] == 'q') {
                return false;
            }
        }

        //6. Обхождаме долен ляв диагонал
        for (int row = currentQueenPositionRow + 1, col = currentQueenPositionCol - 1; row < matrix.length && col >= 0; row++, col--) {
            if (matrix[row][col] == 'q') {
                return false;
            }
        }

        //7. Обхождаме горен десен диагонал
        for (int row = currentQueenPositionRow - 1, col = currentQueenPositionCol + 1; row >= 0 && col < matrix.length; row--, col++) {
            if (matrix[row][col] == 'q') {
                return false;
            }
        }

        //8. Обхождаме долен десен диагонал
        for (int row = currentQueenPositionRow + 1, col = currentQueenPositionCol + 1; row < matrix.length && col < matrix.length; row++, col++) {
            if (matrix[row][col] == 'q') {
                return false;
            }
        }

        return true;
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s+", "")
                    .toCharArray();
        }
    }
}