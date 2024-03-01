package exam_preparation;

import java.util.*;
import java.util.stream.Collectors;

public class TreasureHunt_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dims = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dims[0];
        int cols = dims[1];

        String[][] matrix = new String[rows][cols];

        fillMatrix(matrix, scanner);

        int currentRow = -1;
        int currentCol = -1;

        Deque<String> directionsQueue = new ArrayDeque<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col].equals("Y")) {
                    currentRow = row;
                    currentCol = col;
                }
            }
        }

        String command = scanner.nextLine();
        boolean isTreasureFound = false;

        while (!"Finish".equals(command)) {
            int startRow = currentRow;
            int startCol = currentCol;

            directionsQueue.offer(command);

            switch (command) {
                case "up":
                    currentRow--;
                    if (currentRow < 0) {
                        currentRow++;
                        directionsQueue.pollLast();
                    }
                    break;
                case "down":
                    currentRow++;
                    if (currentRow >= rows) {
                        currentRow--;
                        directionsQueue.pollLast();
                    }
                    break;
                case "left":
                    currentCol--;
                    if (currentCol < 0) {
                        currentCol++;
                        directionsQueue.pollLast();
                    }
                    break;
                case "right":
                    currentCol++;
                    if (currentCol >= cols) {
                        currentCol--;
                        directionsQueue.pollLast();
                    }
                    break;
            }

            String currentPosition = matrix[currentRow][currentCol];
            if (currentPosition.equals("T")) {
                    currentRow = startRow;
                    currentCol = startCol;
                    directionsQueue.pollLast();
            } else if (currentPosition.equals("X")) {
                isTreasureFound = true;
                break;
            }

            command = scanner.nextLine();
        }

        if (isTreasureFound) {
            System.out.println("I've found the treasure!");
            System.out.println("The right path is " + directionsQueue.stream().map(Object::toString).collect(Collectors.joining(", ")));
        } else {
            System.out.println("The map is fake!");
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
}