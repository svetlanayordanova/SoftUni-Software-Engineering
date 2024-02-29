package exam_preparation;

import java.util.Arrays;
import java.util.Scanner;

public class BlindMansBuff_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dims = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dims[0];
        int cols = dims[1];

        String[][] playground = new String[rows][cols];

        int myRow = -1;
        int myCol = -1;

        int opponentsTouched = 0;
        int moves = 0;

        for (int i = 0; i < rows; i++) {
            String[] row = scanner.nextLine().split("\\s+",-1);
            for (int j = 0; j < cols; j++) {
                playground[i][j] = row[j];
                if (playground[i][j].equals("B")) {
                    myRow = i;
                    myCol = j;
                    playground[i][j] = "-";
                }
            }
        }

        String direction;
        while (!(direction = scanner.nextLine()).equals("Finish")) {
            if (("left".equals(direction) && myCol == 0) ||
                    ("right".equals(direction) && myCol == playground.length - 1) ||
                    ("up".equals(direction) && myRow == 0) ||
                    ("down".equals(direction) && myRow == playground[0].length - 1)) {
                continue;
            }

            switch(direction) {
                case "left":
                    if (playground[myRow][myCol - 1].equals("O")) {
                        continue;
                    }
                    break;
                case "right":
                    if (playground[myRow][myCol + 1].equals("O")) {
                        continue;
                    }
                    break;
                case "up":
                    if (playground[myRow - 1][myCol].equals("O")) {
                        continue;
                    }
                    break;
                case "down":
                    if (playground[myRow + 1][myCol].equals("O")) {
                        continue;
                    }
                    break;
            }

            moves++;
            switch (direction) {
                case "left":
                    myCol--;
                    break;
                case "right":
                    myCol++;
                    break;
                case "up":
                    myRow--;
                    break;
                case "down":
                    myRow++;
                    break;

            }

            if (playground[myRow][myCol].equals("P")) {
                opponentsTouched++;
                playground[myRow][myCol] = "-";

                if (opponentsTouched == 3) {
                    break;
                }
            }
        }
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", opponentsTouched, moves);
    }
}