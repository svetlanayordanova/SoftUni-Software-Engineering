package exam_preparation;

import java.util.*;
import java.util.stream.Collectors;

public class PastryShop_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> liquidsQueue = new ArrayDeque<>();
        Deque<Integer> ingredientsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(liquidsQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredientsStack::push);

        Map<Integer, String> foods = Map.of(
                25, "Biscuit",
                50, "Cake",
                75, "Pastry",
                100, "Pie");

        Map<String, Integer> cookedFood = new LinkedHashMap<>();
        cookedFood.put("Biscuit", 0);
        cookedFood.put("Cake", 0);
        cookedFood.put("Pie", 0);
        cookedFood.put("Pastry", 0);

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int liquid = liquidsQueue.poll();
            int ingredient = ingredientsStack.pop();

            int sum = liquid + ingredient;

            if (foods.containsKey(sum)) {
                cookedFood.put(foods.get(sum), cookedFood.get(foods.get(sum)) + 1);
            } else {
                ingredient += 3;
                ingredientsStack.push(ingredient);
            }
        }

        long cookedFoodTypes = cookedFood.entrySet()
                .stream()
                .filter(entry -> entry.getValue() != 0)
                .count();

        if (cookedFoodTypes == 4) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.println("Liquids left: " + liquidsQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.println("Ingredients left: " + ingredientsStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        cookedFood.forEach((k, v) -> System.out.printf("%s: %d%n", k, v));
    }
}