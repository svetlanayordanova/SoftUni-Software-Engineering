package exam_preparation;

import java.util.Scanner;

public class Bomb_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] directions = scanner.nextLine().split(",");

        String[][] matrix = new String[size][size];

        fillMatrix(matrix, scanner);

        int[] sapperCoordinates = findCoordinates(matrix, "s");

        int sapperRow = sapperCoordinates[0];
        int sapperCol = sapperCoordinates[1];

        matrix[sapperRow][sapperCol] = "+";

        boolean gameOver = false;

        for (String position : directions) {
            switch (position) {
                case "up":
                    sapperRow--;
                    if (sapperRow < 0) {
                        sapperRow++;
                    }
                    break;
                case "down":
                    sapperRow++;
                    if (sapperRow == matrix.length) {
                        sapperRow--;
                    }
                    break;
                case "left":
                    sapperCol--;
                    if (sapperCol < 0) {
                        sapperCol++;
                    }
                    break;
                case "right":
                    sapperCol++;
                    if (sapperCol == matrix.length) {
                        sapperCol--;
                    }
                    break;
            }

            String sapperPosition = matrix[sapperRow][sapperCol];
            matrix[sapperRow][sapperCol] = "+";

            if ("B".equals(sapperPosition)) {
                System.out.println("You found a bomb!");
            } else if ("e".equals(sapperPosition)) {
                gameOver = true;
            }

            if (gameOver) {
                break;
            }
        }

        int countLeftBombs = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if ("B".equals(matrix[row][col])) {
                    countLeftBombs++;
                }
            }
        }

        if (!gameOver) {
            if (countLeftBombs == 0) {
                System.out.println("Congratulations! You found all bombs!");
            } else {
                System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n", countLeftBombs, sapperRow, sapperCol);
            }
        } else {
            System.out.printf("END! %d bombs left on the field%n", countLeftBombs);
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