package functional_programming_exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Consumer<String> print = System.out::println;

        String[] input = scanner.nextLine().split("\\s+");

        for (String string : input) {
            print.accept(string);
        }

        // Arrays.stream(scanner.nextLine().split("\\s+"))
        //       .forEach(print);
    }
}