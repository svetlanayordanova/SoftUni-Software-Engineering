package exam_preparation;

import java.util.Arrays;
import java.util.Scanner;

public class DeliveryBoy_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dims = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dims[0];
        int cols = dims[1];

        String[][] matrix = new String[rows][cols];

        fillMatrix(matrix, scanner);

        int boyRow = -1;
        int boyCol = -1;

        int startRow = -1;
        int startCol = -1;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col].equals("B")) {
                    startRow = row;
                    startCol = col;
                    boyRow = startRow;
                    boyCol = startCol;
                }
            }
        }

        boolean isOutside = false;

        while (true) {
            String command = scanner.nextLine();
            int currentRow = boyRow;
            int currentCol = boyCol;

            switch (command) {
                case "up":
                    boyRow--;
                    if (boyRow < 0) {
                        isOutside = true;
                        break;
                    }
                    break;
                case "down":
                    boyRow++;
                    if (boyRow >= rows) {
                        isOutside = true;
                        break;
                    }
                    break;
                case "left":
                    boyCol--;
                    if (boyCol < 0) {
                        isOutside = true;
                        break;
                    }
                    break;
                case "right":
                    boyCol++;
                    if (boyCol >= cols) {
                        isOutside = true;
                        break;
                    }
                    break;
            }

            if (!isOutside) {
                String currentPosition = matrix[boyRow][boyCol];
                if (currentPosition.equals("-")) {
                    matrix[boyRow][boyCol] = ".";
                } else if (currentPosition.equals("*")) {
                    boyRow = currentRow;
                    boyCol = currentCol;
                } else if (currentPosition.equals("P")) {
                    matrix[boyRow][boyCol] = "R";
                    System.out.println("Pizza is collected. 10 minutes for delivery.");
                } else if (currentPosition.equals("A")) {
                    matrix[boyRow][boyCol] = "P";

                    System.out.println("Pizza is delivered on time! Next order...");
                    break;
                }
            } else {
                matrix[startRow][startCol] = " ";
                System.out.println("The delivery is late. Order is canceled.");
                break;
            }
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