package functional_programming_exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames_06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Predicate<String> withLengthSmallerThanN = s -> s.length() <= n;

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(withLengthSmallerThanN)
                .forEach(System.out::println);
    }
}