package exam_preparation;

import java.util.Scanner;

public class TheGambler_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];

        fillMatrix(matrix, scanner);

        int amount = 100;
        int playerRow = -1;
        int playerCol = -1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("G")) {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }

        boolean isOutside = false;
        boolean isJackpot = false;
        String command = scanner.nextLine();

        while (!"end".equals(command)) {
            int startRow = playerRow;
            int startCol = playerCol;
            switch (command) {
                case "up":
                    playerRow--;
                    if (playerRow < 0) {
                        isOutside = true;
                    }
                    break;
                case "down":
                    playerRow++;
                    if (playerRow >= size) {
                        isOutside = true;
                    }
                    break;
                case "left":
                    playerCol--;
                    if (playerCol < 0) {
                        isOutside = true;
                    }
                    break;
                case "right":
                    playerCol++;
                    if (playerCol >= size) {
                        isOutside = true;
                    }
                    break;
            }

            if (!isOutside) {
                String currentPosition = matrix[playerRow][playerCol];
                if (currentPosition.equals("W")) {
                    amount += 100;
                } else if (currentPosition.equals("P")) {
                    amount -= 200;
                } else if (currentPosition.equals("J")) {
                    amount += 100000;
                    isJackpot = true;
                }

                matrix[playerRow][playerCol] = "G";
                matrix[startRow][startCol] = "-";
            } else {
                System.out.println("Game over! You lost everything!");
                return;
            }

            if (amount <= 0) {
                System.out.println("Game over! You lost everything!");
                return;
            }

            if (isJackpot) {
                System.out.println("You win the Jackpot!");
                System.out.printf("End of the game. Total amount: %d$%n", amount);
                printMatrix(matrix);
                return;
            }

            command = scanner.nextLine();
        }

        System.out.printf("End of the game. Total amount: %d$%n", amount);
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