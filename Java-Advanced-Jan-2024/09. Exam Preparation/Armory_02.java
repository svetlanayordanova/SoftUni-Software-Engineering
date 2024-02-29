package exam_preparation;

import java.util.Scanner;

public class Armory_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];

        fillMatrix(matrix, scanner);

        int[] officerCoordinates = findCoordinates(matrix, "A");

        int officerRow = officerCoordinates[0];
        int officerCol = officerCoordinates[1];

        matrix[officerRow][officerCol] = "-";

        int coins = 0;

        while (coins < 65) {
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    officerRow--;
                    break;
                case "down":
                    officerRow++;
                    break;
                case "left":
                    officerCol--;
                    break;
                case "right":
                    officerCol++;
                    break;
            }

            if (isOutOfTheMatrix(matrix, officerRow, officerCol)) {
                break;
            }

            String officerPosition = matrix[officerRow][officerCol];
            matrix[officerRow][officerCol] = "-";

            if ("M".equals(officerPosition)) {
                int[] mirrorCoordinates = findCoordinates(matrix, "M");

                int mirrorRow = mirrorCoordinates[0];
                int mirrorCol = mirrorCoordinates[1];

                officerRow = mirrorRow;
                officerCol = mirrorCol;
                matrix[officerRow][officerCol] = "-";
            } else if (!"-".equals(officerPosition)) {
                coins += Integer.parseInt(officerPosition);
            }
        }

        if (coins >= 65) {
            matrix[officerRow][officerCol] = "A";
            System.out.println("Very nice swords, I will come back for more!");
        } else {
            System.out.println("I do not need more swords!");
        }

        System.out.printf("The king paid %d gold coins.%n", coins);

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