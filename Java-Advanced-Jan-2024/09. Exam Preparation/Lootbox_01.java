package exam_preparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Lootbox_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> firstBoxQueue = new ArrayDeque<>();
        Deque<Integer> secondBoxStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(firstBoxQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondBoxStack::push);

        int sumClaimedItems = 0;

        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {
            int sum = firstBoxQueue.peek() + secondBoxStack.peek();

            if (sum % 2 == 0) {
                firstBoxQueue.poll();
                secondBoxStack.pop();
                sumClaimedItems += sum;
            } else {
                firstBoxQueue.offer(secondBoxStack.pop());
            }
        }

        if (firstBoxQueue.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else if (secondBoxStack.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }

        if (sumClaimedItems >= 100) {
            System.out.printf("Your loot was epic! Value: %d%n", sumClaimedItems);
        } else {
            System.out.printf("Your loot was poor... Value: %d%n", sumClaimedItems);
        }
    }
}