package exam_preparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Bouquets_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> tulipsStack = new ArrayDeque<>();
        Deque<Integer> daffodilsQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(tulipsStack::push);

        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(daffodilsQueue::offer);

        int countBouquets = 0;
        int storedFlowers = 0;

        while (!tulipsStack.isEmpty() && !daffodilsQueue.isEmpty()) {
            int sum = tulipsStack.peek() + daffodilsQueue.peek();

            if (sum == 15) {
                tulipsStack.pop();
                daffodilsQueue.poll();
                countBouquets += 1;
            } else if (sum > 15) {
                tulipsStack.push(tulipsStack.pop() - 2);
                while (tulipsStack.peek() + daffodilsQueue.peek() > 15) {
                    tulipsStack.push(tulipsStack.pop() - 2);
                }

                if (tulipsStack.peek() + daffodilsQueue.peek() == 15) {
                    tulipsStack.pop();
                    daffodilsQueue.poll();
                    countBouquets += 1;
                } else {
                    storedFlowers += tulipsStack.pop();
                    storedFlowers += daffodilsQueue.poll();
                }
            } else {
                storedFlowers += tulipsStack.pop();
                storedFlowers += daffodilsQueue.poll();
            }
        }

        countBouquets += storedFlowers / 15;

        if (countBouquets >= 5) {
            System.out.println("You made it! You go to the competition with 5 bouquets!");
        } else {
            System.out.printf("You failed... You need more %d bouquets.%n", 5 - countBouquets);
        }
    }
}