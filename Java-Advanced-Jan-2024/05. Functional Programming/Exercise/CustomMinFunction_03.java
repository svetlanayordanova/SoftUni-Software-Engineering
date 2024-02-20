package functional_programming_exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Function<Integer[], Integer> findSmallestNumber =
                arr -> Arrays.stream(arr).min(Integer::compareTo).get();

        Integer[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        System.out.println(findSmallestNumber.apply(numbers));
    }
}