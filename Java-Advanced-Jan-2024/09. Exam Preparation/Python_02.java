package exam_preparation;

import java.util.Scanner;

public class Python_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] directions = scanner.nextLine().split(",\\s+");

        String[][] matrix = new String[size][size];

        fillMatrix(matrix, scanner);

        int[] pythonCoordinates = findCoordinates(matrix, "s");

        int pythonRow = pythonCoordinates[0];
        int pythonCol = pythonCoordinates[1];

        int pythonLength = 1;

        for (String position : directions) {
            switch (position) {
                case "up":
                    pythonRow--;
                    if (pythonRow < 0) {
                        pythonRow = matrix.length - 1;
                    }
                    break;
                case "down":
                    pythonRow++;
                    if (pythonRow == matrix.length) {
                        pythonRow = 0;
                    }
                    break;
                case "left":
                    pythonCol--;
                    if (pythonCol < 0) {
                        pythonCol = matrix.length - 1;
                    }
                    break;
                case "right":
                    pythonCol++;
                    if (pythonCol == matrix.length) {
                        pythonCol = 0;
                    }
                    break;
            }

            String pythonPosition = matrix[pythonRow][pythonCol];

            if ("f".equals(pythonPosition)) {
                pythonLength += 1;
                matrix[pythonRow][pythonCol] = "*";
            } else if ("e".equals(pythonPosition)) {
                System.out.println("You lose! Killed by an enemy!");
                return;
            }
        }

        int countLeftFood = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if ("f".equals(matrix[row][col])) {
                    countLeftFood++;
                }
            }
        }

        if (countLeftFood == 0) {
            System.out.printf("You win! Final python length is %d%n", pythonLength);
        } else {
            System.out.printf("You lose! There is still %d food to be eaten.%n", countLeftFood);
        }
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

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
}