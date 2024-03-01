package exam_preparation;

import java.util.Scanner;

public class NavyBattle_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];

        fillMatrix(matrix, scanner);

        int submarineRow = -1;
        int submarineCol = -1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("S")) {
                    submarineRow = row;
                    submarineCol = col;
                    matrix[row][col] = "-";
                }
            }
        }

        int countMines = 0;
        int countBattleCruiser = 0;

        while (true) {
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    submarineRow--;
                    break;
                case "down":
                    submarineRow++;
                    break;
                case "left":
                    submarineCol--;
                    break;
                case "right":
                    submarineCol++;
                    break;
            }

            String currentPosition = matrix[submarineRow][submarineCol];
            if (currentPosition.equals("*")) {
                countMines++;
                matrix[submarineRow][submarineCol] = "-";

                if (countMines == 3) {
                    matrix[submarineRow][submarineCol] = "S";
                    System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", submarineRow, submarineCol);
                    printMatrix(matrix);
                    return;
                }
            } else if (currentPosition.equals("C")) {
                countBattleCruiser++;
                matrix[submarineRow][submarineCol] = "-";

                if (countBattleCruiser == 3) {
                    matrix[submarineRow][submarineCol] = "S";
                    System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                    printMatrix(matrix);
                    return;
                }
            }
        }
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
