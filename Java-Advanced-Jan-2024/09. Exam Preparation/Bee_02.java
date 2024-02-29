package exam_preparation;

import java.util.Scanner;

public class Bee_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];

        fillMatrix(matrix, scanner);

        int[] beeCoordinates = findCoordinates(matrix, "B");

        int beeRow = beeCoordinates[0];
        int beeCol = beeCoordinates[1];

        matrix[beeRow][beeCol] = ".";

        int pollinatedFlowers = 0;

        String command = scanner.nextLine();

        while (!"End".equals(command)) {
            switch (command) {
                case "up":
                    beeRow--;
                    break;
                case "down":
                    beeRow++;
                    break;
                case "left":
                    beeCol--;
                    break;
                case "right":
                    beeCol++;
                    break;
            }

            if (isOutOfTheMatrix(matrix, beeRow, beeCol)) {
                break;
            }

            String beePosition = matrix[beeRow][beeCol];
            matrix[beeRow][beeCol] = ".";

            if ("f".equals(beePosition)) {
                pollinatedFlowers++;
            } else if ("O".equals(beePosition)) {
                switch (command) {
                    case "up":
                        beeRow--;
                        break;
                    case "down":
                        beeRow++;
                        break;
                    case "left":
                        beeCol--;
                        break;
                    case "right":
                        beeCol++;
                        break;
                }
            }

            if (isOutOfTheMatrix(matrix, beeRow, beeCol)) {
                break;
            }

            if ("f".equals(matrix[beeRow][beeCol])) {
                pollinatedFlowers++;
            }

            matrix[beeRow][beeCol] = ".";

            command = scanner.nextLine();
        }

        if (isOutOfTheMatrix(matrix, beeRow, beeCol)) {
            System.out.println("The bee got lost!");
            print(pollinatedFlowers);
        } else {
            matrix[beeRow][beeCol] = "B";
            print(pollinatedFlowers);
        }

        printMatrix(matrix);
    }

    private static void print(int pollinatedFlowers) {
        if (pollinatedFlowers < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinatedFlowers);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
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