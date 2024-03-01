package exam_preparation;

import java.util.Scanner;

public class FormulaOne_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int countCommands = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];

        fillMatrix(matrix, scanner);

        int[] playerCoordinates = findCoordinates(matrix, "P");

        int playerRow = playerCoordinates[0];
        int playerCol = playerCoordinates[1];

        matrix[playerRow][playerCol] = ".";

        boolean isFinished = false;

        for (int i = 0; i < countCommands; i++) {
            int startRow = playerRow;
            int startCol = playerCol;

            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    playerRow--;
                    if (playerRow < 0) {
                        playerRow = matrix.length - 1;
                    }
                    break;
                case "down":
                    playerRow++;
                    if (playerRow == matrix.length) {
                        playerRow = 0;
                    }
                    break;
                case "left":
                    playerCol--;
                    if (playerCol < 0) {
                        playerCol = matrix.length - 1;
                    }
                    break;
                case "right":
                    playerCol++;
                    if (playerCol == matrix.length) {
                        playerCol = 0;
                    }
                    break;
            }

            String playerPosition = matrix[playerRow][playerCol];

            if ("B".equals(playerPosition)) {
                switch (command) {
                    case "up":
                        playerRow--;
                        if (playerRow < 0) {
                            playerRow = matrix.length - 1;
                        }
                        break;
                    case "down":
                        playerRow++;
                        if (playerRow == matrix.length) {
                            playerRow = 0;
                        }
                        break;
                    case "left":
                        playerCol--;
                        if (playerCol < 0) {
                            playerCol = matrix.length - 1;
                        }
                        break;
                    case "right":
                        playerCol++;
                        if (playerCol == matrix.length) {
                            playerCol = 0;
                        }
                        break;
                }
            } else if ("T".equals(playerPosition)) {
                playerRow = startRow;
                playerCol = startCol;
            } else if ("F".equals(playerPosition)) {
                isFinished = true;
                break;
            }

            matrix[playerRow][playerCol] = ".";
        }

        matrix[playerRow][playerCol] = "P";

        if (isFinished) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
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
