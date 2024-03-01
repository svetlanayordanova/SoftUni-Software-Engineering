package exam_preparation;

import java.util.Scanner;

public class CookingJourney_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];

        fillMatrix(matrix, scanner);

        int[] currentCoordinates = findCoordinates(matrix, "S");

        int currentRow = currentCoordinates[0];
        int currentCol = currentCoordinates[1];

        matrix[currentRow][currentCol] = "-";

        int money = 0;

        while (money < 50) {
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    currentRow--;
                    break;
                case "down":
                    currentRow++;
                    break;
                case "left":
                    currentCol--;
                    break;
                case "right":
                    currentCol++;
                    break;
            }

            if (isOutOfTheMatrix(matrix, currentRow, currentCol)) {
                break;
            }

            String currentPosition = matrix[currentRow][currentCol];
            matrix[currentRow][currentCol] = "-";

            if ("P".equals(currentPosition)) {
                int[] pillarCoordinates = findCoordinates(matrix, "P");

                int pillarRow = pillarCoordinates[0];
                int pillarCol = pillarCoordinates[1];

                currentRow = pillarRow;
                currentCol = pillarCol;
                matrix[currentRow][currentCol] = "-";
            } else if (!"-".equals(currentPosition)) {
                money += Integer.parseInt(currentPosition);
            }
        }

        if (money >= 50) {
            matrix[currentRow][currentCol] = "S";
            System.out.println("Good news! You succeeded in collecting enough money!");
        } else {
            System.out.println("Bad news! You are out of the pastry shop.");
        }

        System.out.printf("Money: %d%n", money);

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