package exam_preparation;

import java.util.Scanner;

public class FishingCompetition_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        fillMatrix(matrix, scanner);

        int amount = 0;
        int currentRow = -1;
        int currentCol = -1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'S') {
                    currentRow = row;
                    currentCol = col;
                }
            }
        }

        String command = scanner.nextLine();

        while (!"collect the nets".equals(command)) {
            int startRow = currentRow;
            int startCol = currentCol;
            switch (command) {
                case "up":
                    currentRow--;
                    if (currentRow < 0) {
                        currentRow = size - 1;
                    }
                    break;
                case "down":
                    currentRow++;
                    if (currentRow >= size) {
                        currentRow = 0;
                    }
                    break;
                case "left":
                    currentCol--;
                    if (currentCol < 0) {
                        currentCol = size - 1;
                    }
                    break;
                case "right":
                    currentCol++;
                    if (currentCol >= size) {
                        currentCol = 0;
                    }
                    break;
            }

            char currentPosition = matrix[currentRow][currentCol];
            if (Character.isDigit(currentPosition)) {
                amount += Integer.parseInt(String.valueOf(currentPosition));
            } else if (currentPosition == 'W') {
                System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. Last coordinates of the ship: [%d,%d]%n", currentRow, currentCol);
                return;
            }

            matrix[currentRow][currentCol] = 'S';
            matrix[startRow][startCol] = '-';

            command = scanner.nextLine();
        }

        if (amount >= 20) {
            System.out.println("Success! You managed to reach the quota!");
        } else {
            System.out.printf("You didn't catch enough fish and didn't reach the quota! You need %d tons of fish more.%n", 20 - amount);
        }

        if (amount > 0) {
            System.out.printf("Amount of fish caught: %d tons.%n", amount);
        }

        printMatrix(matrix);
    }

    public static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + "");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++){
            matrix[row] = scanner.nextLine().replaceAll("\\s+", "")
                    .toCharArray();
        }
    }
}