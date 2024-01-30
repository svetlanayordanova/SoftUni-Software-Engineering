package multidimensional_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimensionsFirst = readInputAsArray(scanner);

        int firstRows = dimensionsFirst[0];
        int firstCols = dimensionsFirst[1];

        int[][] firstArray = new int[firstRows][firstCols];

        for (int row = 0; row < firstRows; row++) {
            firstArray[row] = readInputAsArray(scanner);
        }

        int[] dimensionsSecond = readInputAsArray(scanner);

        int secondRows = dimensionsSecond[0];
        int secondCols = dimensionsSecond[1];

        int[][] secondArray = new int[secondRows][secondCols];

        for (int row = 0; row < secondRows; row++) {
            secondArray[row] = readInputAsArray(scanner);
        }

        if (!areEquals(dimensionsFirst, dimensionsSecond)) {
            System.out.println("not equal");
            return;
        }

        for (int i = 0; i < firstRows; i++) {
            if (!areEquals(firstArray[i], secondArray[i])) {
                System.out.println("not equal");
                return;
            }
        }

        System.out.println("equal");
    }

    public static boolean areEquals(int[] firstArray, int[] secondArray) {
        boolean areEquals = true;

        if (firstArray.length != secondArray.length) {
            return false;
        }

        for (int i = 0; i < firstArray.length; i++) {
            if (firstArray[i] != secondArray[i]) {
                return false;
            }
        }

        return areEquals;
    }

    public static int[] readInputAsArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}