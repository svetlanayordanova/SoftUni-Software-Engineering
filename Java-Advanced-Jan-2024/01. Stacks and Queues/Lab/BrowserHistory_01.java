package stacks_and_queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> stack = new ArrayDeque<>();

        while (!"Home".equals(input)) {
            if (!"back".equals(input)) {
                stack.push(input);
                System.out.println(stack.peek());
            } else {
                if (stack.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    stack.pop();
                    System.out.println(stack.peek());
                }
            }

            input = scanner.nextLine();
        }
    }
}