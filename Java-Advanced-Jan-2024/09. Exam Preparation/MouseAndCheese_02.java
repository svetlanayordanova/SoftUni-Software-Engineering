package exam_preparation;

import java.util.Scanner;

public class MouseAndCheese_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];

        fillMatrix(matrix, scanner);

        int[] mouseCoordinates = findCoordinates(matrix, "M");

        int mouseRow = mouseCoordinates[0];
        int mouseCol = mouseCoordinates[1];

        matrix[mouseRow][mouseCol] = "-";

        int countCheese = 0;

        String command = scanner.nextLine();

        while (!"end".equals(command)) {
            switch (command) {
                case "up":
                    mouseRow--;
                    break;
                case "down":
                    mouseRow++;
                    break;
                case "left":
                    mouseCol--;
                    break;
                case "right":
                    mouseCol++;
                    break;
            }

            if (isOutOfTheMatrix(matrix, mouseRow, mouseCol)) {
                break;
            }

            String mousePosition = matrix[mouseRow][mouseCol];

            if ("c".equals(mousePosition)) {
                countCheese++;
                matrix[mouseRow][mouseCol] = "-";
            } else if ("B".equals(mousePosition)) {
                matrix[mouseRow][mouseCol] = "-";

                switch (command) {
                    case "up":
                        mouseRow--;
                        break;
                    case "down":
                        mouseRow++;
                        break;
                    case "left":
                        mouseCol--;
                        break;
                    case "right":
                        mouseCol++;
                        break;
                }
            }

            if (isOutOfTheMatrix(matrix, mouseRow, mouseCol)) {
                break;
            }

            if ("c".equals(matrix[mouseRow][mouseCol])) {
                countCheese++;
            }

            matrix[mouseRow][mouseCol] = "-";

            command = scanner.nextLine();
        }

        if (isOutOfTheMatrix(matrix, mouseRow, mouseCol)) {
            System.out.println("Where is the mouse?");
            print(countCheese);
        } else {
            matrix[mouseRow][mouseCol] = "M";
            print(countCheese);
        }

        printMatrix(matrix);
    }

    private static void print(int countCheese) {
        if (countCheese < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - countCheese);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", countCheese);
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
