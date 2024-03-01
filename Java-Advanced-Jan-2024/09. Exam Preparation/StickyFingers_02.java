package exam_preparation;

import java.util.Scanner;

public class StickyFingers_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] directions = scanner.nextLine().split(",");

        String[][] matrix = new String[size][size];
        fillMatrix(matrix, scanner);

        int dillingerRow = -1;
        int dillingerCol = -1;

        int moneyInPocket = 0;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col].equals("D")) {
                    dillingerRow = row;
                    dillingerCol = col;
                }
            }
        }

        for (String position : directions) {
            int startRow = dillingerRow;
            int startCol = dillingerCol;

            switch (position) {
                case "up":
                    dillingerRow--;
                    if (dillingerRow < 0) {
                        dillingerRow++;
                        System.out.println("You cannot leave the town, there is police outside!");
                        break;
                    }
                    break;
                case "down":
                    dillingerRow++;
                    if (dillingerRow >= size) {
                        dillingerRow--;
                        System.out.println("You cannot leave the town, there is police outside!");
                        break;
                    }
                    break;
                case "left":
                    dillingerCol--;
                    if (dillingerCol < 0) {
                        dillingerCol++;
                        System.out.println("You cannot leave the town, there is police outside!");
                        break;
                    }
                    break;
                case "right":
                    dillingerCol++;
                    if (dillingerCol >= size) {
                        dillingerCol--;
                        System.out.println("You cannot leave the town, there is police outside!");
                        break;
                    }
                    break;
            }

            String currentPosition = matrix[dillingerRow][dillingerCol];
            if (currentPosition.equals("$")) {
                int stolenMoney = dillingerRow * dillingerCol;
                moneyInPocket += stolenMoney;
                System.out.printf("You successfully stole %d$.%n", stolenMoney);
            } else if (currentPosition.equals("P")) {
                System.out.printf("You got caught with %d$, and you are going to jail.%n", moneyInPocket);
                matrix[dillingerRow][dillingerCol] = "#";
                matrix[startRow][startCol] = "+";
                printMatrix(matrix);
                return;
            }

            matrix[dillingerRow][dillingerCol] = "D";
            matrix[startRow][startCol] = "+";
        }

        System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", moneyInPocket);

        printMatrix(matrix);
    }

    public static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
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