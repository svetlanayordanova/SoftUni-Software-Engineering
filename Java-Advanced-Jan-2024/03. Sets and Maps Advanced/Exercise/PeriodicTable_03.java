package sets_and_maps_exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> elements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
//            Arrays.stream(scanner.nextLine().split("\\s+"))
//                    .forEach(elements::add);

            elements.addAll(Arrays.asList(scanner.nextLine().split("\\s+")));
        }

        System.out.println(String.join(" ", elements));
    }
}