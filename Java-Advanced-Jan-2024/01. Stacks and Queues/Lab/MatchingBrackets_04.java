package stacks_and_queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);

            if ('(' == current) {
                stack.push(i);
            } else if (')' == current) {
                int startIndex = stack.pop();
                String match = expression.substring(startIndex, i + 1);
                System.out.println(match);
            }
        }
    }
}