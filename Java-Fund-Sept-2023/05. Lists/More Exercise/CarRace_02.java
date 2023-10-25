package lists_more_exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int middleIndex = numbers.size() / 2;
        double timeLeftRacer = 0;
        double timeRightRacer = 0;

        for (int i = 0; i < middleIndex; i++) {
            timeLeftRacer += numbers.get(i);

            if (numbers.get(i) == 0) {
                timeLeftRacer -= 0.2 * timeLeftRacer;
            }
        }

        for (int i = numbers.size() - 1; i > middleIndex; i--) {
            timeRightRacer += numbers.get(i);

            if (numbers.get(i) == 0) {
                timeRightRacer -= 0.2 * timeRightRacer;
            }
        }

        if (timeLeftRacer < timeRightRacer) {
            System.out.printf("The winner is left with total time: %.1f", timeLeftRacer);
        } else {
            System.out.printf("The winner is right with total time: %.1f", timeRightRacer);
        }
    }
}