package sets_and_maps;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> numbers = new LinkedHashMap<>();

        for (double num : input) {
            numbers.putIfAbsent(num, 0);
            int newCount = numbers.get(num) + 1;
            numbers.put(num, newCount);
        }

        numbers.forEach((k, v) -> {
            System.out.printf("%.1f -> %d%n", k, v);
        });
    }
}