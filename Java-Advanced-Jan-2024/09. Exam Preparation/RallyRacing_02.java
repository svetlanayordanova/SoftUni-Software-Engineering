package exam_preparation;

import java.util.Scanner;

public class RallyRacing_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String racingNumber = scanner.nextLine();

        String[][] matrix = new String[size][size];

        fillMatrix(matrix, scanner);

        int kilometers = 0;

        int currentRow = 0;
        int currentCol = 0;

        String command = scanner.nextLine();
        boolean isFinished = false;

        while (!"End".equals(command)) {
            int startRow = currentRow;
            int startCol = currentCol;

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

            String currentPosition = matrix[currentRow][currentCol];

            if (currentPosition.equals(".")) {
                kilometers += 10;
                matrix[currentRow][currentCol] = "C";
            } else if (currentPosition.equals("T")) {
                kilometers += 30;
                matrix[currentRow][currentCol] = ".";

                for (int row = currentRow; row < size; row++) {
                    for (int col = 0; col < size; col++) {
                        if (matrix[row][col].equals("T")) {
                            currentRow = row;
                            currentCol = col;
                            matrix[currentRow][currentCol] = "C";
                        }
                    }
                }
            } else if (currentPosition.equals("F")) {
                kilometers += 10;
                matrix[currentRow][currentCol] = "C";
                matrix[startRow][startCol] = ".";
                isFinished = true;
                break;
            }

            matrix[startRow][startCol] = ".";

            command = scanner.nextLine();
        }

        if (isFinished) {
            System.out.printf("Racing car %s finished the stage!%n", racingNumber);
        } else {
            System.out.printf("Racing car %s DNF.%n", racingNumber);
        }

        System.out.printf("Distance covered %d km.%n", kilometers);

        printMatrix(matrix);
    }

    public static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + "");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
}