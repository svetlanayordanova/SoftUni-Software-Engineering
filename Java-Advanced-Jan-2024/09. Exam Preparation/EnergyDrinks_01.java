package exam_preparation;

import java.util.*;
import java.util.stream.Collectors;

public class EnergyDrinks_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Stack<Integer> caffeineStack = new Stack<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(caffeineStack::push);

        Deque<Integer> drinksQueue = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int stamatCaffeine = 0;

        while (!caffeineStack.isEmpty() && !drinksQueue.isEmpty()) {
            int caffeineInDrink = caffeineStack.peek() * drinksQueue.peek();

            if (caffeineInDrink + stamatCaffeine <= 300) {
                stamatCaffeine += caffeineInDrink;
                caffeineStack.pop();
                drinksQueue.poll();
            } else {
                caffeineStack.pop();
                drinksQueue.offer(drinksQueue.poll());

                if (stamatCaffeine - 30 > 0) {
                    stamatCaffeine -= 30;
                }
            }
        }

        if (!drinksQueue.isEmpty()) {
            System.out.println("Drinks left: " + drinksQueue.stream().map(Object::toString).collect(Collectors.joining(", ")));
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }

        System.out.printf("Stamat is going to sleep with %d mg caffeine.%n", stamatCaffeine);
    }
}