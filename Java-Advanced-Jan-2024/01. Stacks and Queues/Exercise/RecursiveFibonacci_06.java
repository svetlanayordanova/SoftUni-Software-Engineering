package stacks_and_queues_exercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class RecursiveFibonacci_06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Deque<Long> stack = new ArrayDeque<>();
        stack.push(0L);
        stack.push(1L);

        if (n < 2) {
            System.out.println(1);
            return;
        }

        for (int i = 0; i < n; i++) {
            long num1 = stack.pop();
            long num2 = stack.pop();

            // rewrite num1
            stack.push(num1);
            // calculate num2
            stack.push(num1 + num2);
        }

        System.out.println(stack.pop());
    }
}