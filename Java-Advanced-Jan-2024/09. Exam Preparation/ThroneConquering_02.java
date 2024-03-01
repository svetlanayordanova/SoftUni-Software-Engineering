package exam_preparation;

import java.util.Scanner;

public class ThroneConquering_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];

        fillMatrix(matrix, scanner);

        int[] parisCoordinates = findCoordinates(matrix, "P");

        int parisRow = parisCoordinates[0];
        int parisCol = parisCoordinates[1];

        matrix[parisRow][parisCol] = "-";

        boolean isHelenReached = false;

        while (energy > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);

            matrix[row][col] = "S";

            switch (command) {
                case "up":
                    parisRow--;
                    if (parisRow < 0) {
                        parisRow++;
                    }
                    break;
                case "down":
                    parisRow++;
                    if (parisRow == matrix.length) {
                        parisRow--;
                    }
                    break;
                case "left":
                    parisCol--;
                    if (parisCol < 0) {
                        parisCol++;
                    }
                    break;
                case "right":
                    parisCol++;
                    if (parisCol == matrix.length) {
                        parisCol--;
                    }
                    break;
            }

            energy -= 1;

            String parisPosition = matrix[parisRow][parisCol];
            matrix[parisRow][parisCol] = "-";

            if ("S".equals(parisPosition)) {
                energy -= 2;
            } else if ("H".equals(parisPosition)) {
                isHelenReached = true;
            }

            if (isHelenReached) {
                break;
            }
        }

        if (isHelenReached) {
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
        } else {
            System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
            matrix[parisRow][parisCol] = "X";
        }

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