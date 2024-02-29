package exam_preparation;

import java.util.*;

public class AutumnCocktails_01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> ingredientsQueue = new ArrayDeque<>();
        Deque<Integer> levelStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredientsQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(levelStack::push);

        Map<Integer, String> cocktails = Map.of(
                150, "Pear Sour",
                250, "The Harvest",
                300, "Apple Hinny",
                400, "High Fashion");

        Map<String, Integer> madeCocktails = new TreeMap<>();

        for (Integer ingredient : ingredientsQueue) {
            if (ingredient == 0) {
                ingredientsQueue.remove();
            }
        }

        while (!ingredientsQueue.isEmpty() && !levelStack.isEmpty()) {
            int ingredient = ingredientsQueue.poll();
            int level = levelStack.pop();

            int totalFreshnessLevel = ingredient * level;

            if (cocktails.containsKey(totalFreshnessLevel)) {
                madeCocktails.putIfAbsent(cocktails.get(totalFreshnessLevel), 0);
                madeCocktails.put(cocktails.get(totalFreshnessLevel), madeCocktails.get(cocktails.get(totalFreshnessLevel)) + 1);
            } else {
                ingredient += 5;
                ingredientsQueue.offer(ingredient);
            }
        }

        if (madeCocktails.size() == 4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!ingredientsQueue.isEmpty()) {
            int sum = ingredientsQueue.stream().mapToInt(Integer::intValue).sum();
            System.out.printf("Ingredients left: %d%n", sum);
        }

        madeCocktails.forEach((k, v) -> System.out.printf(" # %s --> %d%n", k, v));
    }
}