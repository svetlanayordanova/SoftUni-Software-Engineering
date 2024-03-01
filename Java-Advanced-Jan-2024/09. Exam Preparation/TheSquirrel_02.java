package exam_preparation;

import java.util.Scanner;

public class TheSquirrel_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] directions = scanner.nextLine().split(", ");

        String[][] matrix = new String[size][size];
        fillMatrix(matrix, scanner);

        int countHazelnuts = 0;

        int squirrelRow = -1;
        int squirrelCol = -1;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col].equals("s")) {
                    squirrelRow = row;
                    squirrelCol = col;
                }
            }
        }

        boolean isOutside = false;

        for (String position : directions) {
            switch (position) {
                case "up":
                    squirrelRow--;
                    if (squirrelRow < 0) {
                        isOutside = true;
                        break;
                    }
                    break;
                case "down":
                    squirrelRow++;
                    if (squirrelRow >= size) {
                        isOutside = true;
                        break;
                    }
                    break;
                case "left":
                    squirrelCol--;
                    if (squirrelCol < 0) {
                        isOutside = true;
                        break;
                    }
                    break;
                case "right":
                    squirrelCol++;
                    if (squirrelCol >= size) {
                        isOutside = true;
                        break;
                    }
                    break;
            }

            if (!isOutside) {
                String currentPosition = matrix[squirrelRow][squirrelCol];
                if (currentPosition.equals("h")) {
                    countHazelnuts++;
                    matrix[squirrelRow][squirrelCol] = "*";
                    if (countHazelnuts == 3) {
                        System.out.println("Good job! You have collected all hazelnuts!");
                        break;
                    }
                } else if (currentPosition.equals("t")) {
                    System.out.println("Unfortunately, the squirrel stepped on a trap...");
                    System.out.printf("Hazelnuts collected: %d%n", countHazelnuts);
                    return;
                }
            } else {
                System.out.println("The squirrel is out of the field.");
                System.out.printf("Hazelnuts collected: %d%n", countHazelnuts);
                return;
            }
        }

        if (countHazelnuts < 3) {
            System.out.println("There are more hazelnuts to collect.");
        }

        System.out.printf("Hazelnuts collected: %d%n", countHazelnuts);
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
    }
}