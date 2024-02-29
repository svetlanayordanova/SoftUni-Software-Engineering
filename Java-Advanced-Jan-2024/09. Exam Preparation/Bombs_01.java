package exam_preparation;

import java.util.*;
import java.util.stream.Collectors;

public class Bombs_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> effectsQueue = new ArrayDeque<>();
        Deque<Integer> casingsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(effectsQueue::offer);

        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(casingsStack::push);

        Map<Integer, String> bombs = Map.of(
                40, "Datura Bombs",
                60, "Cherry Bombs",
                120, "Smoke Decoy Bombs");

        Map<String, Integer> createdBombs = new TreeMap<>();
        createdBombs.put("Datura Bombs", 0);
        createdBombs.put("Cherry Bombs", 0);
        createdBombs.put("Smoke Decoy Bombs", 0);

        while (!effectsQueue.isEmpty() && !casingsStack.isEmpty()) {
            int sum = effectsQueue.peek() + casingsStack.peek();

            if (bombs.containsKey(sum)) {
                effectsQueue.poll();
                casingsStack.pop();
                createdBombs.put(bombs.get(sum), createdBombs.get(bombs.get(sum)) + 1);
            } else {
                casingsStack.push(casingsStack.pop() - 5);
            }

            long createdBombsTypes = createdBombs.entrySet()
                    .stream()
                    .filter(entry -> entry.getValue() >= 3)
                    .count();

            if (createdBombsTypes == 3) {
                break;
            }
        }

        long createdBombsTypes = createdBombs.entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= 3)
                .count();

        if (createdBombsTypes == 3) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (effectsQueue.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.println("Bomb Effects: " + effectsQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (casingsStack.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.println("Bomb Casings: " + casingsStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        createdBombs.forEach((k, v) -> System.out.printf("%s: %d%n", k, v));
    }
}