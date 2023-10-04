package arrays;

import java.util.Arrays;
import java.util.Scanner;
public class EqualArrays_06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] firstSeq = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] secondSeq = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean identical = true;
        int sum = 0;

        for (int i = 0; i <= firstSeq.length - 1; i++) {
            sum += firstSeq[i];

            if (firstSeq[i] != secondSeq[i]) {
                System.out.printf("Arrays are not identical. Found difference at %d index.%n", i);
                identical = false;
                break;
            }
        }
        if (identical) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
    }
}
