package exam_preparation;

import java.util.Scanner;

public class Snake_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];

        fillMatrix(matrix, scanner);

        int[] snakeCoordinates = findCoordinates(matrix, "S");

        int snakeRow = snakeCoordinates[0];
        int snakeCol = snakeCoordinates[1];

        matrix[snakeRow][snakeCol] = ".";

        int foodEaten = 0;

        while (foodEaten < 10) {
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    snakeRow--;
                    break;
                case "down":
                    snakeRow++;
                    break;
                case "left":
                    snakeCol--;
                    break;
                case "right":
                    snakeCol++;
                    break;
            }

            if (isOutOfTheMatrix(matrix, snakeRow, snakeCol)) {
                break;
            }

            String snakePosition = matrix[snakeRow][snakeCol];
            matrix[snakeRow][snakeCol] = ".";

            if ("B".equals(snakePosition)) {
                int[] lairCoordinates = findCoordinates(matrix, "B");

                int lairRow = lairCoordinates[0];
                int lairCol = lairCoordinates[1];

                snakeRow = lairRow;
                snakeCol = lairCol;
                matrix[snakeRow][snakeCol] = ".";
            } else if ("*".equals(snakePosition)) {
                foodEaten++;
            }
        }

        if (foodEaten >= 10) {
            matrix[snakeRow][snakeCol] = "S";
            System.out.println("You won! You fed the snake.");
        } else {
            System.out.println("Game over!");
        }

        System.out.printf("Food eaten: %d%n", foodEaten);

        printMatrix(matrix);
    }

    private static int[] findCoordinates(String[][] matrix, String symbol) {
        int[] coordinates = new int[2];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (symbol.equals(matrix[row][col])) {
                    coordinates[0] = row;
                    coordinates[1] = col;
                    break;
                }
            }
        }

        return coordinates;
    }

    private static boolean isOutOfTheMatrix(String[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length ||
                col < 0 || col >= matrix[row].length;
    }

    public static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
    }
}