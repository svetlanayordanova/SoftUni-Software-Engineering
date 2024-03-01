package exam_preparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class FlowerWreaths_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> liliesStack = new ArrayDeque<>();
        Deque<Integer> rosesQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(liliesStack::push);

        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(rosesQueue::offer);

        int countWreaths = 0;
        int storedFlowers = 0;

        while (!liliesStack.isEmpty() && !rosesQueue.isEmpty()) {
            int sum = liliesStack.peek() + rosesQueue.peek();

            if (sum == 15) {
                liliesStack.pop();
                rosesQueue.poll();
                countWreaths += 1;
            } else if (sum > 15) {
                liliesStack.push(liliesStack.pop() - 2);
                while (liliesStack.peek() + rosesQueue.peek() > 15) {
                    liliesStack.push(liliesStack.pop() - 2);
                }

                if (liliesStack.peek() + rosesQueue.peek() == 15) {
                    liliesStack.pop();
                    rosesQueue.poll();
                    countWreaths += 1;
                } else {
                    storedFlowers += liliesStack.pop();
                    storedFlowers += rosesQueue.poll();
                }
            } else {
                storedFlowers += liliesStack.pop();
                storedFlowers += rosesQueue.poll();
            }
        }

        countWreaths += storedFlowers / 15;

        if (countWreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", countWreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!%n", 5 - countWreaths);
        }
    }
}