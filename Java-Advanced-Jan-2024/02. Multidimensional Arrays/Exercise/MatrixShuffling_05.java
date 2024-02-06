package multidimensional_arrays_exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling_05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];
        String[][] matrix = new String[rows][cols];

        fillMatrix(matrix, scanner);

        String command = scanner.nextLine();

        while (!"END".equals(command)) {
            String[] commandParts = command.split("\\s+");

            //валидираме командата
            if (validateCommand(commandParts, rows, cols)) {
                int rowFirstElement = Integer.parseInt(commandParts[1]);
                int colFirstElement = Integer.parseInt(commandParts[2]);

                int rowSecondElement = Integer.parseInt(commandParts[3]);
                int colSecondElement = Integer.parseInt(commandParts[4]);

                String firstElement = matrix[rowFirstElement][colFirstElement];
                String secondElement = matrix[rowSecondElement][colSecondElement];

                //размяна
                matrix[rowFirstElement][colFirstElement] = secondElement;
                matrix[rowSecondElement][colSecondElement] = firstElement;

                //отпечатваме матрицата с разменени елементи
                printMatrix(matrix);

            } else {
                System.out.println("Invalid input!");
            }

            command = scanner.nextLine();
        }
    }

    public static boolean validateCommand(String[] commandParts, int rows, int cols) {
        //1. брой на частите на командата
        if (commandParts.length != 5) {
            return false;
        }

        //2. започва с думата swap
        if (!"swap".equals(commandParts[0])) {
            return false;
        }

        //3. дали редовете и колоните са валидни
        int rowFirstElement = Integer.parseInt(commandParts[1]); //ред на първия елемент -> >= 0 и < бр. редове
        int colFirstElement = Integer.parseInt(commandParts[2]); //колона на първия елемент -> >= 0 и < бр. колони
        int rowSecondElement = Integer.parseInt(commandParts[3]); //ред на втория елемент -> >= 0 и < бр. редове
        int colSecondElement = Integer.parseInt(commandParts[4]); //колона на втория елемент -> >= 0 и < бр. колони

        if (rowFirstElement >= 0 && rowFirstElement < rows && rowSecondElement >= 0 && rowSecondElement < rows
        && colFirstElement >= 0 && colFirstElement < cols && colSecondElement >= 0 && colSecondElement < cols) {
            //валидни редове и колони
            return true;
        } else {
            //невалидни редове и колони
            return false;
        }
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