package sets_and_maps_exercise;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Set<Integer> firstSet = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            int numFirstSet = Integer.parseInt(scanner.nextLine());

            firstSet.add(numFirstSet);
        }

        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < m; i++) {
            int numSecondSet = Integer.parseInt(scanner.nextLine());

            secondSet.add(numSecondSet);
        }

        if (firstSet.size() < secondSet.size()) {
            for (int num : firstSet) {
                if (secondSet.contains(num)) {
                    System.out.print(num + " ");
                }
            }
        } else {
            for (int num : secondSet) {
                if (firstSet.contains(num)) {
                    System.out.print(num + " ");
                }
            }
        }

//        firstSet.stream()
//                .filter(secondSet::contains)
//                .forEach(e -> System.out.print(e + " "));

//        firstSet.retainAll(secondSet);
//        firstSet.forEach(e -> System.out.print(e + " "));
    }
}