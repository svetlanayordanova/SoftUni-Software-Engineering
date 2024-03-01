package exam_preparation;

import java.util.*;
import java.util.stream.Collectors;

public class OffroadChallenge_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Stack<Integer> initialFuel = new Stack<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(initialFuel::push);

        Queue<Integer> additionalConsumptionIdx = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        Queue<Integer> neededFuelAmount = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        List<Integer> reachedAltitudes = new ArrayList<>();

        int count = 0;

        while (!initialFuel.isEmpty()) {
            count++;
            if (initialFuel.peek() - additionalConsumptionIdx.peek() >= neededFuelAmount.peek()) {
                initialFuel.pop();
                additionalConsumptionIdx.poll();
                neededFuelAmount.poll();
                reachedAltitudes.add(count);
                System.out.printf("John has reached: Altitude %d%n", count);
            } else {
                System.out.printf("John did not reach: Altitude %d%n", count);
                break;
            }
        }

        if (!initialFuel.isEmpty()) {
            if (!reachedAltitudes.isEmpty()) {
                System.out.println("John failed to reach the top.");
                System.out.print("Reached altitudes: ");
                int size = reachedAltitudes.size();

                for (int e : reachedAltitudes) {
                    if (size > 1) {
                        System.out.print("Altitude " + e + ", ");
                    } else {
                        System.out.println("Altitude " + e);
                    }

                    size--;
                }
            } else {
                System.out.println("John failed to reach the top.");
                System.out.println("John didn't reach any altitude.");
            }
        } else {
            System.out.println("John has reached all the altitudes and managed to reach the top!");
        }
    }
}