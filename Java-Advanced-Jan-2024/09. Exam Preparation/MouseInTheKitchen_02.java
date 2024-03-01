package exam_preparation;

import java.util.Arrays;
import java.util.Scanner;

public class MouseInTheKitchen_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dims = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dims[0];
        int cols = dims[1];

        String[][] matrix = new String[rows][cols];

        fillMatrix(matrix, scanner);

        int mouseRow = -1;
        int mouseCol = -1;
        int countC = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col].equals("M")) {
                    mouseRow = row;
                    mouseCol = col;
                } else if (matrix[row][col].equals("C")) {
                    countC++;
                }
            }
        }

        boolean isOutside = false;
        boolean isCheeseEaten = false;
        String command = scanner.nextLine();

        while (!"danger".equals(command)) {
            int startRow = mouseRow;
            int startCol = mouseCol;
            switch (command) {
                case "up":
                    mouseRow--;
                    if (mouseRow < 0) {
                        isOutside = true;
                        mouseRow++;
                    }
                    break;
                case "down":
                    mouseRow++;
                    if (mouseRow >= rows) {
                        isOutside = true;
                        mouseRow--;
                    }
                    break;
                case "left":
                    mouseCol--;
                    if (mouseCol < 0) {
                        isOutside = true;
                        mouseCol++;
                    }
                    break;
                case "right":
                    mouseCol++;
                    if (mouseCol >= cols) {
                        isOutside = true;
                        mouseCol--;
                    }
                    break;
            }

            if (!isOutside) {
                String currentPosition = matrix[mouseRow][mouseCol];
                    if (currentPosition.equals("C")) {
                        countC--;
                        matrix[mouseRow][mouseCol] = "M";
                        matrix[startRow][startCol] = "*";

                        if (countC == 0) {
                            isCheeseEaten = true;
                            break;
                        }
                    } else if (currentPosition.equals("*")) {
                        matrix[mouseRow][mouseCol] = "M";
                        matrix[startRow][startCol] = "*";
                    } else if (currentPosition.equals("T")) {
                        matrix[mouseRow][mouseCol] = "M";
                        matrix[startRow][startCol] = "*";

                        System.out.println("Mouse is trapped!");
                        printMatrix(matrix);
                        return;
                    } else if (currentPosition.equals("@")) {
                        mouseRow = startRow;
                        mouseCol = startCol;
                    }
            } else {
                System.out.println("No more cheese for tonight!");
                printMatrix(matrix);
                return;
            }

            command = scanner.nextLine();
        }

        if (isCheeseEaten) {
            System.out.println("Happy mouse! All the cheese is eaten, good night!");
        } else {
            System.out.println("Mouse will come back later!");
        }

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
            matrix[row] = scanner.nextLine().split("");
        }
    }
}