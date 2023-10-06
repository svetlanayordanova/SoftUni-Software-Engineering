package arrays_exercise;

import java.util.Arrays;
import java.util.Scanner;
public class TopIntegers_05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int index = 0; index < numbers.length - 1; index++) {
            int currentNumber = numbers[index];

            boolean isBigger = true;

            for (int i = index + 1; i <= numbers.length - 1; i++) {
                int numberAfter = numbers[i];

                if (currentNumber <= numberAfter) {
                    isBigger = false;
                    break;
                }
            }

            if (isBigger) {
                System.out.print(currentNumber + " ");
            }
        }

        System.out.println(numbers[numbers.length - 1]);
    }
}
