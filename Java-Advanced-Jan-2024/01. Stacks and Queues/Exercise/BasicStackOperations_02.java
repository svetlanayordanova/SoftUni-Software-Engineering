package stacks_and_queues_exercise;

import java.util.*;

public class BasicStackOperations_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> stack = new ArrayDeque<>();

        // n, s, x
        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = tokens[0];
        int s = tokens[1];
        int x = tokens[2];

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(stack::push);

        // Remove s elements from the stack
        for (int i = 0; i < s; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) { // check for empty stack
            System.out.println(0);
        } else if (stack.contains(x)) { // check whether x is present in the stack
            System.out.println(true);
        } else { // else get the smallest number
            Integer smallestElement = Collections.min(stack);
            System.out.println(smallestElement);
        }
    }
}
