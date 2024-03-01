package exam_preparation;

import java.util.*;
import java.util.stream.Collectors;

public class RubberDuckDebuggers_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Queue<Integer> times = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        Stack<Integer> tasks = new Stack<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(tasks::push);

        int countDarthVaderDucky = 0;
        int countThorDucky = 0;
        int countBigBlueRubberDucky = 0;
        int countSmallYellowRubberDucky = 0;

        while (!times.isEmpty() && !tasks.isEmpty()) {
            int time = times.peek();
            int task = tasks.peek();

            int range = time * task;

            if (range <= 240) {
                if (range >= 0 & range <= 60) {
                    countDarthVaderDucky++;
                } else if (range >= 61 && range <= 120) {
                    countThorDucky++;
                } else if (range >= 121 && range <= 180) {
                    countBigBlueRubberDucky++;
                } else if (range >= 181) {
                    countSmallYellowRubberDucky++;
                }

                times.poll();
                tasks.pop();
            } else {
                tasks.push(tasks.pop() - 2);
                times.offer(times.poll());
            }
        }

        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        System.out.printf("Darth Vader Ducky: %d%n", countDarthVaderDucky);
        System.out.printf("Thor Ducky: %d%n", countThorDucky);
        System.out.printf("Big Blue Rubber Ducky: %d%n", countBigBlueRubberDucky);
        System.out.printf("Small Yellow Rubber Ducky: %d%n", countSmallYellowRubberDucky);
    }
}