package exam_preparation;

import java.util.Scanner;

public class ReVolt_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];

        fillMatrix(matrix, scanner);

        int[] playerCoordinates = findCoordinates(matrix, "f");

        int playerRow = playerCoordinates[0];
        int playerCol = playerCoordinates[1];

        matrix[playerRow][playerCol] = "-";

        boolean isFinished = false;

        for (int i = 0; i < commandsCount; i++) {
            String command = scanner.nextLine();
            int startRow = playerRow;
            int startCol = playerCol;

            switch (command) {
                case "up":
                    playerRow--;
                    if (playerRow < 0) {
                        playerRow = size - 1;
                    }
                    break;
                case "down":
                    playerRow++;
                    if (playerRow == size) {
                        playerRow = 0;
                    }
                    break;
                case "left":
                    playerCol--;
                    if (playerCol < 0) {
                        playerCol = size - 1;
                    }
                    break;
                case "right":
                    playerCol++;
                    if (playerCol == size) {
                        playerCol = 0;
                    }
                    break;
            }

            String playerPosition = matrix[playerRow][playerCol];

            if ("F".equals(playerPosition)) {
                isFinished = true;
            } else if ("B".equals(playerPosition)) {
                switch (command) {
                    case "up":
                        playerRow--;
                        if (playerRow < 0) {
                            playerRow = size - 1;
                        }
                        break;
                    case "down":
                        playerRow++;
                        if (playerRow > matrix.length - 1) {
                            playerRow = 0;
                        }
                        break;
                    case "left":
                        playerCol--;
                        if (playerCol < 0) {
                            playerCol = size - 1;
                        }
                        break;
                    case "right":
                        playerCol++;
                        if (playerCol > matrix.length - 1) {
                            playerCol = 0;
                        }
                        break;
                }
            } else if ("T".equals(playerPosition)) {
                playerRow = startRow;
                playerCol = startCol;
            }

            if (isFinished) {
                break;
            }
        }

        matrix[playerRow][playerCol] = "f";

        if (isFinished) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
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