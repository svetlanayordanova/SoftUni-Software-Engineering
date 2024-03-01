package exam_preparation;

import java.util.*;
import java.util.stream.Collectors;

public class SantasPresentFactory_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> materialsStack = new ArrayDeque<>();
        Deque<Integer> levelsQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(materialsStack::push);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(levelsQueue::offer);

        Map<Integer, String> presents = Map.of(
                150, "Doll",
                250, "Wooden train",
                300, "Teddy bear",
                400, "Bicycle");

        Map<String, Integer> craftedPresents = new TreeMap<>();

        Deque<Integer> materialsQueue = new ArrayDeque<>();

        while (!materialsStack.isEmpty()) {
            materialsQueue.offer(materialsStack.pop());
        }

        for (int material : materialsQueue) {
            if (material == 0) {
                materialsQueue.poll();
            }
        }

        for (int level : levelsQueue) {
            if (level == 0) {
                levelsQueue.poll();
            } else {
                levelsQueue.offer(levelsQueue.poll());
            }
        }

        while (!materialsStack.isEmpty() && !levelsQueue.isEmpty()) {
            int material = materialsStack.pop();
            int level = levelsQueue.poll();

            int result = material * level;

            if (result > 0) {
                if (presents.containsKey(result)) {
                    craftedPresents.putIfAbsent(presents.get(result), 0);
                    craftedPresents.put(presents.get(result), craftedPresents.get(presents.get(result)) + 1);
                } else {
                    materialsStack.push(material + 15);
                }
            } else if (result < 0) {
                int sum = material + level;
                materialsStack.push(sum);
            }
        }

        if ((craftedPresents.containsKey("Doll") && craftedPresents.containsKey("Wooden train")) ||
                (craftedPresents.containsKey("Teddy bear") && craftedPresents.containsKey("Bicycle"))) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (!materialsStack.isEmpty()) {
            System.out.println("Materials left: " + materialsStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (!levelsQueue.isEmpty()) {
            System.out.println("Magic left: " + levelsQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        craftedPresents.forEach((k, v) -> System.out.printf("%s: %d%n", k, v));
    }
}